package com.groupa.ssi.common.exception;

/**
 * @author Miguel Rojas
 */
public class DefaultSSIRuntimeException extends RuntimeException {

    public DefaultSSIRuntimeException() {
        super();
    }

    public DefaultSSIRuntimeException(String message) {
        super(message);
    }

    public DefaultSSIRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
