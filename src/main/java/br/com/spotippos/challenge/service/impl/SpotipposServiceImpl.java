package br.com.spotippos.challenge.service.impl;

import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
@Singleton
public class SpotipposServiceImpl implements SpotipposService {

    private List<ProvinceDTO> provinces;
    private List<PropertyDTO> properties;

    public SpotipposServiceImpl() {
        provinces = new ArrayList<ProvinceDTO>();
        properties = new ArrayList<PropertyDTO>();
    }


    @Override
    public PropertyDTO saveProperty(PropertyDTO property) {
        property.setId(getPropertyID());
        properties.add(property);
        return property;
    }

    private long getPropertyID(){
        return properties.isEmpty() ? 1 : properties.get(properties.size() - 1).getId() + 1;
    }

}
