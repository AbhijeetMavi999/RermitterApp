package com.beneficiary.controller;

import com.beneficiary.entity.Beneficiary;
import com.beneficiary.exception.BeneficiaryPropertiesCanNotBeNullException;
import com.beneficiary.exception.ValidAmountException;
import com.beneficiary.service.BeneficiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiary")
@Slf4j
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @PostMapping("/register")
    public ResponseEntity<Beneficiary> registerBeneficiary(@RequestBody Beneficiary beneficiary) {
        log.info("registerBeneficiary() method of BeneficiaryController is called");
        if(beneficiary.getName().equals("") || beneficiary.getEmailId().equals("") || beneficiary.getAccountNumber().equals("")
        || beneficiary.getIfscCode().equals("") || beneficiary.getAccountStatus().equals("")) {
            log.warn("Beneficiary properties can not be empty");
            throw new BeneficiaryPropertiesCanNotBeNullException("Beneficiary properties can not be empty");
        } else if (beneficiary.getTransferAmountLimit() < 500) {
            log.warn("Beneficiary minimum transfer amount is 500");
            throw new ValidAmountException("Beneficiary minimum transfer amount is 500");
        }
        Beneficiary registeredBeneficiary = beneficiaryService.registerBeneficiary(beneficiary);
        return new ResponseEntity<>(registeredBeneficiary, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Beneficiary> getBeneficiaryByEmailAndPassword(@RequestBody Beneficiary beneficiary) {
        log.info("getBeneficiaryByEmailAndPassword() method of BeneficiaryController is called");
        if(beneficiary.getEmailId().equals("") || beneficiary.getPassword().equals("")) {
            log.warn("Email or Password can not be null");
            throw new BeneficiaryPropertiesCanNotBeNullException("Email or Password can not be null");
        }
        Beneficiary beneficiary1 = beneficiaryService.findByEmailAndPassword(beneficiary.getEmailId(), beneficiary.getPassword());
        return new ResponseEntity<>(beneficiary1, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Beneficiary>> getAllBeneficiary() {
        log.info("getAllBeneficiary() method of BeneficiaryController is called");
        List<Beneficiary> beneficiaries = beneficiaryService.getAllBeneficiary();
        return new ResponseEntity<>(beneficiaries, HttpStatus.OK);
    }
}
