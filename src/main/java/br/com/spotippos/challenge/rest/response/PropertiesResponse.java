package br.com.spotippos.challenge.rest.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mtzcpd663 on 12/08/2016.
 */
public class PropertiesResponse implements Serializable {
    private static final long serialVersionUID = -360072890749149491L;

    private long foundProperties;
    private List<PropertyResponse> properties;

    public long getFoundProperties() {
        return foundProperties;
    }

    public void setFoundProperties(long foundProperties) {
        this.foundProperties = foundProperties;
    }

    public List<PropertyResponse> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyResponse> properties) {
        this.properties = properties;
    }
}
