package com.beneficiary.exception;

public class BeneficiaryNotFoundException extends RuntimeException {

    public BeneficiaryNotFoundException() {
    }

    public BeneficiaryNotFoundException(String message) {
        super(message);
    }
}
