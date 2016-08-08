package br.com.spotippos.challenge.rest.response;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eltonmoraes on 04/08/16.
 */
public class PropertyResponse implements Serializable{
    private static final long serialVersionUID = 820968244392482946L;

    private long id;
    private long x;
    private long y;
    private String title;
    private double price;
    private String description;
    private int beds;
    private int baths;
    private long squareMeters;
    private List<ProvinceResponse> provinces;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getProvinces() {
        return provinces.stream().map(p -> p.getName()).collect(Collectors.toList());
    }

    public void setProvinces(List<ProvinceResponse> provinces) {
        this.provinces = provinces;
    }
}
