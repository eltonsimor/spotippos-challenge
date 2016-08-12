package br.com.spotippos.challenge.service.impl;

import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertiesDTO;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;
import br.com.spotippos.challenge.utils.SpotipposUtils;
import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Elton Moraes
 * @since 04/08/2016.
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
        List<ProvinceDTO> provinces = this.provinces.stream()
                .filter(p ->
                        p.getBoundaries().getUpperLeft().getX() <= x && x <= p.getBoundaries().getBottomRight().getX() &&
                        p.getBoundaries().getBottomRight().getY() <= y && y <= p.getBoundaries().getUpperLeft().getY()
                )
                .collect(Collectors.toList());

        return provinces;
    }

    @Override
    public PropertyDTO findPropertyByID(final long id){
        return this.properties
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public ProvinceDTO saveProvince(ProvinceDTO province){
        provinces.add(province);
        return province;
    }

    @Override
    public List<ProvinceDTO> getAllProvinces(){
        return provinces;
    }

    private long getPropertyID(){
        return properties.isEmpty() ? 1 : properties.get(properties.size() - 1).getId() + 1;
    }

    @Override
    public PropertiesDTO findPropertiesByRange(final long ax, final long ay, final long bx, final long by){
        PropertiesDTO propertiesDTO = new PropertiesDTO();
        Range<Long> rangeX = SpotipposUtils.setRange(ax, bx);
        Range<Long> rangeY = SpotipposUtils.setRange(ay, by);

        List<PropertyDTO> properties = this.properties.parallelStream()
                .filter(p -> rangeX.contains(p.getX()) && rangeY.contains(p.getY()))
                .collect(Collectors.toList());

        propertiesDTO.setFoundProperties(properties.size());
        propertiesDTO.setProperties(properties);

        return propertiesDTO;
    }



}
