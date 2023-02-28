package com.admin.exception;

public class AdminPropertiesCanNotBeNull extends RuntimeException {

    public AdminPropertiesCanNotBeNull() {
    }

    public AdminPropertiesCanNotBeNull(String message) {
        super(message);
    }
}
