package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.InsurancePolicyException;
import com.masai.model.InsurancePolicy;
import com.masai.repository.InsurancePolicyRepo;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService{

	@Autowired
	private InsurancePolicyRepo ipr;
	
	
	@Override
	public InsurancePolicy savePolicy(InsurancePolicy ip) {
		InsurancePolicy insurancePolicy = ipr.save(ip);
		return insurancePolicy;
	}

	@Override
	public InsurancePolicy deletePolicy(Integer id) throws InsurancePolicyException {
		Optional<InsurancePolicy> op = ipr.findById(id);
		if(op.isPresent()) {
			ipr.delete(op.get());
			return op.get();
		}else {
			throw new InsurancePolicyException("No Insurance Policy found with this Id : "+id);
		}
	}

	@Override
	public InsurancePolicy updatePolicy(InsurancePolicy ip) throws InsurancePolicyException {
		Optional<InsurancePolicy> opt = ipr.findById(ip.getId());
		if(opt.isPresent()) {
			InsurancePolicy in = ipr.save(ip);
			return in;
		}else {
			throw new InsurancePolicyException("No Policy found");
		}
	}

	@Override
	public InsurancePolicy getPolicy(Integer id) throws InsurancePolicyException {
		Optional<InsurancePolicy> opt = ipr.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new InsurancePolicyException("No Insurance Policy found with this Id : "+id);
		}
	}

	@Override
	public List<InsurancePolicy> getAllPolicy() throws InsurancePolicyException {
		
		List<InsurancePolicy> iList = ipr.findAll();
		if(iList.size()==0) {
			throw new InsurancePolicyException("No Policies found");
		}
		return iList;
	}

}
