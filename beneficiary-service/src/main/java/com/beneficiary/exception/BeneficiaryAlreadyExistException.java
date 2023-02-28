package com.beneficiary.exception;

public class BeneficiaryAlreadyExistException extends RuntimeException{

    public BeneficiaryAlreadyExistException() {
    }

    public BeneficiaryAlreadyExistException(String message) {
        super(message);
    }
}
