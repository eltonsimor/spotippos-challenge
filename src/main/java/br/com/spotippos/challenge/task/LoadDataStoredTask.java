package br.com.spotippos.challenge.task;

import br.com.spotippos.challenge.config.Converter;
import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by mtzcpd663 on 09/08/2016.
 */
@Component
public class LoadDataStoredTask {

    private static final Logger LOG = LoggerFactory.getLogger(LoadDataStoredTask.class);

    @Autowired
    private SpotipposService spotipposService;

    @Scheduled(fixedRate = 1000 * 60)
    public void loadStoredData(){
        List<ProvinceDTO> provinces = spotipposService.getAllProvinces();

        if(provinces.isEmpty()){
            LOG.info("[PROCESS STARTED] ::::::::::: ");
            loadProvinces();
            loadProperties();
            LOG.info("[PROCESS COMPLETED] :::::::::: ");
        }

    }


    private void loadProvinces(){
        LOG.info("[LOADING PROVINCES] :: PLEASE WAIT....:");

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("https://raw.githubusercontent.com/VivaReal/code-challenge/master/provinces.json", String.class);

        JsonParser gson = new GsonJsonParser();
        Map<String, Object> mapProvinces = gson.parseMap(json);

        mapProvinces.entrySet()
                .stream()
                .forEach(p -> {
                    String nameProvince = p.getKey();
                    ProvinceDTO province = Converter.convertTo(p.getValue(), ProvinceDTO.class);
                    province.setName(nameProvince);

                    spotipposService.saveProvince(province);
                });
        LOG.info("[LOADED PROVINCES] :: TKS....:");

    }

    private void loadProperties(){
        LOG.info("[LOADING PROPERTIES] :: PLEASE WAIT....:");
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("https://raw.githubusercontent.com/VivaReal/code-challenge/master/properties.json", String.class);
        String jsonFormatted = json.replaceAll("lat", "x").replaceAll("long", "y");

        JsonParser gson = new GsonJsonParser();

        Map<String, Object> mapProperties = gson.parseMap(jsonFormatted);

        List properties = (ArrayList) mapProperties.get("properties");

        properties.stream().forEach(p -> {
            PropertyDTO property = Converter.convertTo(p, PropertyDTO.class);
            spotipposService.saveProperty(property);
        });

        LOG.info("[LOADED PROPERTIES] :: TKS....:");

    }

}
