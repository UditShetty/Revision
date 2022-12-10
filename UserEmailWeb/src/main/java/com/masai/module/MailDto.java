package com.masai.module;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class MailDto {

	@JsonIgnoreProperties(value = { "firstName", "lastName", "mobileNumber", "dateOfBirth", "password" })
	private List<User> recievers;

	private String subject;

	private String body;

	

}
