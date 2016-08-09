package br.com.spotippos.challenge.task;

import br.com.spotippos.challenge.config.Converter;
import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
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
        LOG.info("Inicializando scheduler para carregar massa de dados.");

        List<ProvinceDTO> provinces = spotipposService.getAllProvinces();
        if(provinces.isEmpty()){
            loadProvinces();
            loadProperties();
            LOG.info("Carregando massa de dados...");
        }

        LOG.info("Finalizado scheduler da massa de dados.");

    }


    private void loadProvinces(){
        LOG.info("[INIT PROVINCE] Inilializin stored data ::::");
        RestTemplate restTemplate = new RestTemplate();

        String json = restTemplate.getForObject("https://raw.githubusercontent.com/VivaReal/code-challenge/master/provinces.json", String.class);

        JsonParser gson = new GsonJsonParser();
        Map<String, Object> mapProvinces = gson.parseMap(json);

        mapProvinces.entrySet()
                .parallelStream()
                .forEach(p -> {
                    String nameProvince = p.getKey();
                    ProvinceDTO province = Converter.convertTo(p.getValue(), ProvinceDTO.class);
                    province.setName(nameProvince);

                    spotipposService.saveProvince(province);
                    LOG.trace(".");
                });
        LOG.info("[END PROVINCE] Finish stored data ::::");

    }

    private void loadProperties(){
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("https://raw.githubusercontent.com/VivaReal/code-challenge/master/properties.json", String.class);
        String jsonFormatted = json.replaceAll("lat", "x").replaceAll("long", "y");

        JsonParser gson = new GsonJsonParser();

        Map<String, Object> mapProperties = gson.parseMap(jsonFormatted);


        mapProperties.entrySet().parallelStream().forEach(map ->{
            List properties = (ArrayList) map.getValue();
            properties.stream().forEach(property -> {
                PropertyDTO dto = Converter.convertTo(property, PropertyDTO.class);
                spotipposService.saveProperty(dto);
            });
        });

    }

}
