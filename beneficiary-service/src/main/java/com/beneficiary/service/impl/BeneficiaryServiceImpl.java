package com.beneficiary.service.impl;

import com.beneficiary.entity.Beneficiary;
import com.beneficiary.exception.BeneficiaryAlreadyExistException;
import com.beneficiary.exception.BeneficiaryNotFoundException;
import com.beneficiary.repository.BeneficiaryRepository;
import com.beneficiary.service.BeneficiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Override
    public Beneficiary registerBeneficiary(Beneficiary beneficiary) {
        log.info("registerBeneficiary() method of BeneficiaryServiceImpl is called");
        Beneficiary isPresent = beneficiaryRepository.findByEmailId(beneficiary.getEmailId());
        if(isPresent != null) {
            log.warn("This is email is already taken");
            throw new BeneficiaryAlreadyExistException("Email already taken");
        }
        Beneficiary registeredBeneficiary = beneficiaryRepository.save(beneficiary);
        return registeredBeneficiary;
    }

    @Override
    public Beneficiary findByEmailAndPassword(String emailId, String password) {
        log.info("findByEmailAndPassword() method of BeneficiaryServiceImpl is called");
        Beneficiary beneficiary = beneficiaryRepository.findByEmailIdAndPassword(emailId, password);
        if(beneficiary == null) {
            log.warn("Beneficiary is not found by email: "+emailId+" and password: "+password);
            throw new BeneficiaryNotFoundException("Beneficiary is not found by email: "+emailId+" and password: "+password);
        }
        return beneficiary;
    }

    @Override
    public List<Beneficiary> getAllBeneficiary() {
        log.info("getAllBeneficiary() method of BeneficiaryServiceImpl is called");
        List<Beneficiary> beneficiaries = beneficiaryRepository.findAll();
        if(beneficiaries == null) {
            log.warn("beneficiary not found");
            throw new BeneficiaryNotFoundException("beneficiary not found");
        }
        return beneficiaries;
    }
}
