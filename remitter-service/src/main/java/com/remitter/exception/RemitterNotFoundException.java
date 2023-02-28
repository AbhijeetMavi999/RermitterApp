package com.remitter.exception;

public class RemitterNotFoundException extends RuntimeException {

    public RemitterNotFoundException() {
    }

    public RemitterNotFoundException(String message) {
        super(message);
    }
}
