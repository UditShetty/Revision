package com.masai.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.masai.module.MailDto;
import com.masai.module.User;
import com.masai.repository.MailDao;
import com.masai.service.MailService;
import com.masai.service.UserService;


@RestController
@RequestMapping("masaimail")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@Autowired
	private MailDao mailDao;

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user){

		boolean response = userService.addUser(user);

		return new ResponseEntity<>("user added", HttpStatus.ACCEPTED);
	}


    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(){
		boolean response = userService.deleteUser();
		return new ResponseEntity<>("user deleted",HttpStatus.ACCEPTED);
    }
    

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@Valid @RequestBody MailDto mailDto){
    
    	userService.sentMail(mailDto);
    	
    	return new ResponseEntity<String>("Mail Sent",HttpStatus.OK);
	}
	
	
    @PostMapping("/starred/{mailId}")
	public ResponseEntity<String> starredMail(@PathVariable("mailId") int mailId){
			
				if(userService.starredMail(mailId))
					return new ResponseEntity<>("Starred successfully", HttpStatus.ACCEPTED);
				else 
					return new ResponseEntity<>("Mail Unstarred successfully", HttpStatus.ACCEPTED);	
				
	}
    
	
   
    
	@PostMapping("/delete/{mailId}")
	public ResponseEntity<String> deleteMail(@PathVariable("mailId") int mailId) {
	
		userService.deleteMail(mailId);
		return new ResponseEntity<String>("Mail Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping("/login")
	public ResponseEntity<String> login(){
		
		
		return new ResponseEntity<String>("Loggen In",HttpStatus.ACCEPTED);
	}
}
