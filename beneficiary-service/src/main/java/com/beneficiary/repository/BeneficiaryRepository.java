package com.beneficiary.repository;

import com.beneficiary.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
    Beneficiary findByEmailId(String emailId);

    Beneficiary findByEmailIdAndPassword(String emailId, String password);
}
