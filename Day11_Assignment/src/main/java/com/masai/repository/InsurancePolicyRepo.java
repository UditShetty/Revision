package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.InsurancePolicy;

@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Integer>{

}
