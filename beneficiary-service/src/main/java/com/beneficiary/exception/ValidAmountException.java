package com.beneficiary.exception;

public class ValidAmountException extends RuntimeException {

    public ValidAmountException() {
    }

    public ValidAmountException(String message) {
        super(message);
    }
}
