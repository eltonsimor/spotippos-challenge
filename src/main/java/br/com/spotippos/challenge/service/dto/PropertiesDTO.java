package br.com.spotippos.challenge.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mtzcpd663 on 12/08/2016.
 */
public class PropertiesDTO implements Serializable {
    private static final long serialVersionUID = -3507778158034405175L;

    private long foundProperties;
    private List<PropertyDTO> properties;

    public long getFoundProperties() {
        return foundProperties;
    }

    public void setFoundProperties(long foundProperties) {
        this.foundProperties = foundProperties;
    }

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }
}
