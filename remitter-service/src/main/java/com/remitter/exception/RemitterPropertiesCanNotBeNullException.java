package com.remitter.exception;

public class RemitterPropertiesCanNotBeNullException extends RuntimeException {

    public RemitterPropertiesCanNotBeNullException() {
    }

    public RemitterPropertiesCanNotBeNullException(String message) {
        super(message);
    }
}
