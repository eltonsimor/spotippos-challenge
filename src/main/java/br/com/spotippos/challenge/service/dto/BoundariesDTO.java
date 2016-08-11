package br.com.spotippos.challenge.service.dto;

import java.io.Serializable;

/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
public class BoundariesDTO implements Serializable {
    private static final long serialVersionUID = -2329567899100853512L;

    private BottomRightDTO bottomRight;
    private UpperLeftDTO upperLeft;

    public BottomRightDTO getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(BottomRightDTO bottomRight) {
        this.bottomRight = bottomRight;
    }

    public UpperLeftDTO getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(UpperLeftDTO upperLeft) {
        this.upperLeft = upperLeft;
    }
}
