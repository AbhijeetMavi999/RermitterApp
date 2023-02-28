package com.beneficiary.service;

import com.beneficiary.entity.Beneficiary;

import java.util.List;

public interface BeneficiaryService {

    public Beneficiary registerBeneficiary(Beneficiary beneficiary);

    public Beneficiary findByEmailAndPassword(String emailId, String password);

    public List<Beneficiary> getAllBeneficiary();
}
