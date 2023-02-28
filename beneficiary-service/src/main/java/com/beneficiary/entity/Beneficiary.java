package com.beneficiary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer beneficiaryId;
    private String name;
    private String accountNumber;
    private String accountStatus;
    private String ifscCode;
    private String emailId;
    private String password;
    private Long transferAmountLimit;
}
