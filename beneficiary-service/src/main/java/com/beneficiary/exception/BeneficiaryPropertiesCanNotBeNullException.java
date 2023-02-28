package com.beneficiary.exception;

public class BeneficiaryPropertiesCanNotBeNullException extends RuntimeException {

    public BeneficiaryPropertiesCanNotBeNullException() {
    }

    public BeneficiaryPropertiesCanNotBeNullException(String message) {
        super(message);
    }
}
