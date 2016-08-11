package br.com.spotippos.challenge.service.dto;

import java.io.Serializable;

/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
public class ProvinceDTO implements Serializable {
    private static final long serialVersionUID = -3957629644271592198L;

    private String name;
    private BoundariesDTO boundaries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoundariesDTO getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(BoundariesDTO boundaries) {
        this.boundaries = boundaries;
    }
}
