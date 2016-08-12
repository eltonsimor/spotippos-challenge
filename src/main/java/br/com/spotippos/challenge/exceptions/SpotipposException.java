package br.com.spotippos.challenge.exceptions;

/**
 * @author Elton Moraes
 * @since 12/08/2016.
 */
public class SpotipposException extends Exception {
    private static final long serialVersionUID = 4683185244490381265L;

    public SpotipposException(String message, Throwable cause) {
        super(message, cause);
    }
}
