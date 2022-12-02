package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class InsurancePolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Min(value = 11, message = "Please Enter a Policy Number of at least 11 Numbers.")
	private Integer policyNo;
	
	@Future(message = "Please Enter A valid Date.")
	private LocalDateTime expiryDate;
	
	@NotNull
	private Integer monthlyPremium;
	
	@NotNull
	private String customerName;
	@NotNull
	private String customerAddress;
	
	@Size(min = 10,max = 10,message = "Mobile Number should be of 10 Digits")
	private Integer mobileNo;
	
	@Size(min = 18,max = 60,message = "Age Should be greater than 18 And smaller than 60.")
	private Integer customerAge;
	
	@Email(message = "Please enter a valid email.")
	private String emailAddress;
	
	public InsurancePolicy() {
		// TODO Auto-generated constructor stub
	}

	public InsurancePolicy(Integer id,
			@Min(value = 11, message = "Please Enter a Policy Number of at least 11 Numbers.") Integer policyNo,
			@Future(message = "Please Enter A valid Date.") LocalDateTime expiryDate, Integer monthlyPremium,
			String customerName, String customerAddress,
			@Size(min = 10, max = 10, message = "Mobile Number should be of 10 Digits") Integer mobileNo,
			@Size(min = 18, max = 60, message = "Age Should be greater than 18 And smaller than 60.") Integer customerAge,
			@Email(message = "Please enter a valid email.") String emailAddress) {
		super();
		this.id = id;
		this.policyNo = policyNo;
		this.expiryDate = expiryDate;
		this.monthlyPremium = monthlyPremium;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.mobileNo = mobileNo;
		this.customerAge = customerAge;
		this.emailAddress = emailAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getMonthlyPremium() {
		return monthlyPremium;
	}

	public void setMonthlyPremium(Integer monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", policyNo=" + policyNo + ", expiryDate=" + expiryDate
				+ ", monthlyPremium=" + monthlyPremium + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", mobileNo=" + mobileNo + ", customerAge=" + customerAge + ", emailAddress="
				+ emailAddress + "]";
	}
	
	
	
	
	
}
