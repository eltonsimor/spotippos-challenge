package br.com.spotippos.challenge.service.impl;

import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
@Singleton
public class SpotipposServiceImpl implements SpotipposService {

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
        if(province.getBoundaries() != null){
            provinces.add(province);
        }
        return province;
    }

    @Override
    public long getPropertyID(){
        return properties.isEmpty() ? 1 : properties.get(properties.size() - 1).getId() + 1;
    }

}
