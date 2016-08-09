package br.com.spotippos.challenge.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public class PropertyDTO implements Serializable {
    private static final long serialVersionUID = 7019892482970351093L;

    private long id;
    private long x;
    private long y;
    private int beds;
    private int baths;
    private long squareMeters;
    private String title;
    private String description;
    private double price;

    private List<ProvinceDTO> provinces;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public long getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(long squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProvinceDTO> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<ProvinceDTO> provinces) {
        this.provinces = provinces;
    }
}
