package com.mobile.application.exceptions;

/**
 * This exception is a base exception of all exceptions to be defined in the application.
 *
 * @author shobha
 * @version 1.0
 */
public class ApplicationBaseException extends RuntimeException {
    private static final long serialVersionUID = 231108967133826696L;

    public ApplicationBaseException(String message) {
        super(message);
    }

    public ApplicationBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}