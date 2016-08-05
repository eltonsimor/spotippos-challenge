package br.com.spotippos.challenge.rest.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by eltonmoraes on 04/08/16.
 */
public class PropertyRequest implements Serializable {
    private static final long serialVersionUID = 2031642290627384696L;

    private long id;

    @NotNull(message = "{x.notnull}")
    @Min(value = 0, message = "{x.min}")
    @Max(value = 1400, message = "{x.max}")
    private long x;

    @NotNull(message = "{y.notnull}")
@Min(value = 0, message = "{y.min}")
    @Max(value = 1000, message = "{y.max}")
    private long y;
    private String title;
    private double price;
    private String description;

    @NotNull(message = "{beds.notnull}")
    @Min(value = 1, message = "{beds.min}")
    @Max(value = 5, message = "{beds.max}")
    private int beds;

    @NotNull(message = "{baths.notnull}")
    @Min(value = 1, message = "{baths.min}")
    @Max(value = 4, message = "{baths.max}")
    private int baths;

    @NotNull(message = "{squaremeters.notnull}")
    @Min(value = 20, message = "{squaremeters.min}")
    @Max(value = 240, message = "{squaremeters.max}")
    private long squareMeters;

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
}
