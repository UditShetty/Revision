package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.module.Mail;
import com.masai.service.MailService;

@RestController
@RequestMapping("/masaimail")
public class MailController {

	@Autowired
	private MailService mailService;

	@GetMapping("/inbox")
	public ResponseEntity<List<Mail>> inbox() {

		List<Mail> inboxList = mailService.inbox();
		return new ResponseEntity<>(inboxList, HttpStatus.ACCEPTED);

	}



	@GetMapping("/sent")
	public ResponseEntity<List<Mail>> sent() {

		List<Mail> sentList = mailService.sentBox();
		return new ResponseEntity<>(sentList, HttpStatus.ACCEPTED);

	}


	@GetMapping("/starred")
	public ResponseEntity<List<Mail>> starred() {

		List<Mail> starredMails = mailService.getStarredMails();
		return new ResponseEntity<List<Mail>>(starredMails, HttpStatus.OK);

	}


	@GetMapping("/delete")
	public ResponseEntity<List<Mail>> delete() {

		List<Mail> trashMails = mailService.getDeletedMails();
		return new ResponseEntity<List<Mail>>(trashMails, HttpStatus.OK);

	}

	@GetMapping("/allMail")
	public ResponseEntity<List<Mail>> allMail() {

		List<Mail> allMailList = mailService.getAllMail();
		return new ResponseEntity<>(allMailList, HttpStatus.ACCEPTED);

	}

}
