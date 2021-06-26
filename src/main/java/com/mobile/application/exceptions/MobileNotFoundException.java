package com.mobile.application.exceptions;

/**
 * This exception indicates that the entity is not found.
 *
 * @author shobha
 * @version 1.0
 */
public class MobileNotFoundException extends ApplicationBaseException {
    private static final long serialVersionUID = 1L;

    public MobileNotFoundException(String message) {
        super(message);
    }

    public MobileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
