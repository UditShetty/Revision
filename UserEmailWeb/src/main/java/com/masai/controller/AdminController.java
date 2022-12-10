package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.module.User;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/mail/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = adminService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);

	}
	



	


}
