package br.com.spotippos.challenge.service.dto;

import java.io.Serializable;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public class BottomRightDTO implements Serializable {
    private static final long serialVersionUID = -7412175992121323156L;

    private long x;
    private long y;

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
}
