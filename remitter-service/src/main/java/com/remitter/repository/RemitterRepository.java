package com.remitter.repository;

import com.remitter.entity.Remitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemitterRepository extends JpaRepository<Remitter, Integer> {

    Remitter findByEmailId(String emailId);

    Remitter findByEmailIdAndPassword(String emailId, String password);
}
