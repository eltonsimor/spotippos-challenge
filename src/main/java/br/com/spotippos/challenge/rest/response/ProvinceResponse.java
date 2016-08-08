package br.com.spotippos.challenge.rest.response;

import java.io.Serializable;

/**
 * Created by eltonmoraes on 08/08/16.
 */
public class ProvinceResponse implements Serializable {
    private static final long serialVersionUID = 8351610867682616593L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
