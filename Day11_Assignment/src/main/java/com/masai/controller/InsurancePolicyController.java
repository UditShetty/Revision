package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.InsurancePolicyException;
import com.masai.model.InsurancePolicy;
import com.masai.service.InsurancePolicyService;

@RestController
public class InsurancePolicyController {
	
	@Autowired
	private InsurancePolicyService ips;
	
	@PostMapping("/policy")
	public ResponseEntity<InsurancePolicy> addPolicy(@RequestBody InsurancePolicy ip){
		
		InsurancePolicy insurance = ips.savePolicy(ip);
		return new ResponseEntity<>(insurance,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/policy")
	public ResponseEntity<InsurancePolicy> updatePolicy(@RequestBody InsurancePolicy ip) throws InsurancePolicyException{
		
		InsurancePolicy insurance = ips.updatePolicy(ip);
		return new ResponseEntity<>(insurance,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/policy/{id}")
	public ResponseEntity<InsurancePolicy> deletePolicy(@PathVariable Integer id) throws InsurancePolicyException{
		
		InsurancePolicy insurance = ips.deletePolicy(id);
		return new ResponseEntity<>(insurance,HttpStatus.OK);
	}
	
	@GetMapping("/policy/{id}")
	public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Integer id) throws InsurancePolicyException{
		
		InsurancePolicy insurance = ips.getPolicy(id);
		return new ResponseEntity<>(insurance,HttpStatus.OK);
	}
	
	@GetMapping("/policy")
	public ResponseEntity<List<InsurancePolicy>> getAllPolicy() throws InsurancePolicyException{
		
		List<InsurancePolicy> insurance = ips.getAllPolicy();
		return new ResponseEntity<>(insurance,HttpStatus.OK);
	}
	
	
	

}
