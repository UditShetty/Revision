package com.masai.service;

import java.util.List;

import com.masai.exception.InsurancePolicyException;
import com.masai.model.InsurancePolicy;

public interface InsurancePolicyService {

	public InsurancePolicy savePolicy(InsurancePolicy ip);
	
	public InsurancePolicy deletePolicy(Integer id) throws InsurancePolicyException;
	
	public InsurancePolicy updatePolicy(InsurancePolicy ip) throws InsurancePolicyException;
	
	public InsurancePolicy getPolicy(Integer id) throws InsurancePolicyException;
	
	public List<InsurancePolicy> getAllPolicy() throws InsurancePolicyException;
	
	
}
