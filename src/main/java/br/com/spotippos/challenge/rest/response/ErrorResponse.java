package br.com.spotippos.challenge.rest.response;

import java.io.Serializable;

/**
 * Created by mtzcpd663 on 09/08/2016.
 */
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = -3445978911363703959L;

    private long code;
    private String message;

    public ErrorResponse(final long code, final String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
