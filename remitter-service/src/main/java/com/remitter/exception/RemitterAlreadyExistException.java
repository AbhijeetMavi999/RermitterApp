package com.remitter.exception;

public class RemitterAlreadyExistException extends RuntimeException {

    public RemitterAlreadyExistException() {
    }

    public RemitterAlreadyExistException(String message) {
        super(message);
    }
}
