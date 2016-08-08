package br.com.spotippos.challenge.service.impl;

import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
@Singleton
@Component
public class SpotipposServiceImpl implements SpotipposService {

    private static final long serialVersionUID = -8920309356454705639L;

    private List<ProvinceDTO> provinces;
    private List<PropertyDTO> properties;

    public SpotipposServiceImpl() {
        provinces = new ArrayList<>();
        properties = new ArrayList<>();
    }


    @Override
    public PropertyDTO saveProperty(PropertyDTO property) {
        property.setId(getPropertyID());
        List<ProvinceDTO> provinces = findProvinces(property.getX(), property.getY());
        property.setProvinces(provinces);
        properties.add(property);
        return property;
    }

    @Override
    public List<ProvinceDTO> findProvinces(long x, long y){

        if(provinces.isEmpty()){
            loadProvinces();
        }

        List<ProvinceDTO> provinces = this.provinces.stream()
                .filter(p ->
                        p.getBoundaries().getUpperLeft().getX() <= x && x <= p.getBoundaries().getBottomRight().getX() &&
                        p.getBoundaries().getBottomRight().getY() <= y && y <= p.getBoundaries().getUpperLeft().getY()
                )
                .collect(Collectors.toList());

        return provinces;
    }

    @Override
    public ProvinceDTO saveProvince(ProvinceDTO province){
        provinces.add(province);
        return province;
    }

    @Override
    public long getPropertyID(){
        return properties.isEmpty() ? 1 : properties.get(properties.size() - 1).getId() + 1;
    }


    private void loadProvinces(){
        ProvinceDTO gode = new ProvinceDTO();
        BoundariesDTO boundariesGode = new BoundariesDTO();
        UpperLeftDTO uppperleftGode = new UpperLeftDTO();
        BottomRightDTO bottomRightGode = new BottomRightDTO();

        gode.setName("Gode");
        uppperleftGode.setX(0L);
        uppperleftGode.setY(1000L);

        bottomRightGode.setX(600L);
        bottomRightGode.setY(500L);
        boundariesGode.setBottomRight(bottomRightGode);
        boundariesGode.setUpperLeft(uppperleftGode);
        gode.setBoundaries(boundariesGode);


        ProvinceDTO ruja = new ProvinceDTO();
        BoundariesDTO boundariesRuja = new BoundariesDTO();
        UpperLeftDTO uppperleftRuja = new UpperLeftDTO();
        BottomRightDTO bottomRightRuja = new BottomRightDTO();

        ruja.setName("Ruja");
        uppperleftRuja.setX(400L);
        uppperleftRuja.setY(1000L);

        bottomRightRuja.setX(1100L);
        bottomRightRuja.setY(500L);
        boundariesRuja.setBottomRight(bottomRightRuja);
        boundariesRuja.setUpperLeft(uppperleftRuja);
        ruja.setBoundaries(boundariesRuja);


        ProvinceDTO scavy = new ProvinceDTO();
        BoundariesDTO boundariesScavy = new BoundariesDTO();
        UpperLeftDTO uppperleftScavy = new UpperLeftDTO();
        BottomRightDTO bottomRightScavy = new BottomRightDTO();

        scavy.setName("Scavy");
        uppperleftScavy.setX(0L);
        uppperleftScavy.setY(500L);

        bottomRightScavy.setX(600L);
        bottomRightScavy.setY(0L);
        boundariesScavy.setBottomRight(bottomRightScavy);
        boundariesScavy.setUpperLeft(uppperleftScavy);
        scavy.setBoundaries(boundariesScavy);


        ProvinceDTO groola = new ProvinceDTO();
        BoundariesDTO boundariesGroola = new BoundariesDTO();
        UpperLeftDTO uppperleftGroola = new UpperLeftDTO();
        BottomRightDTO bottomRightGroola = new BottomRightDTO();

        groola.setName("Groola");
        uppperleftGroola.setX(600L);
        uppperleftGroola.setY(500L);

        bottomRightGroola.setX(800L);
        bottomRightGroola.setY(0L);
        boundariesGroola.setBottomRight(bottomRightGroola);
        boundariesGroola.setUpperLeft(uppperleftGroola);
        groola.setBoundaries(boundariesGroola);


        ProvinceDTO jaby = new ProvinceDTO();
        BoundariesDTO boundariesJaby = new BoundariesDTO();
        UpperLeftDTO uppperleftJaby = new UpperLeftDTO();
        BottomRightDTO bottomRightJaby = new BottomRightDTO();

        jaby.setName("Jaby");
        uppperleftJaby.setX(1100L);
        uppperleftJaby.setY(1000L);

        bottomRightJaby.setX(1400L);
        bottomRightJaby.setY(500L);
        boundariesJaby.setBottomRight(bottomRightJaby);
        boundariesJaby.setUpperLeft(uppperleftJaby);
        jaby.setBoundaries(boundariesJaby);


        ProvinceDTO nova = new ProvinceDTO();
        BoundariesDTO boundariesNova = new BoundariesDTO();
        UpperLeftDTO uppperleftNova = new UpperLeftDTO();
        BottomRightDTO bottomRightNova = new BottomRightDTO();

        nova.setName("Nova");
        uppperleftNova.setX(1100L);
        uppperleftNova.setY(1000L);

        bottomRightNova.setX(1400L);
        bottomRightNova.setY(500L);
        boundariesNova.setBottomRight(bottomRightNova);
        boundariesNova.setUpperLeft(uppperleftNova);
        nova.setBoundaries(boundariesNova);


        saveProvince(gode);
        saveProvince(ruja);
        saveProvince(scavy);
        saveProvince(groola);
        saveProvince(jaby);
        saveProvince(nova);
    }

}
