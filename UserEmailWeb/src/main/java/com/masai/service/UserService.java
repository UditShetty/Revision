package com.masai.service;

import com.masai.exception.UserAlreadyExistException;
import com.masai.module.Mail;
import com.masai.module.MailDto;
import com.masai.module.User;

public interface UserService {

	public boolean addUser(User user) throws UserAlreadyExistException;

	public boolean deleteUser();

	public boolean sentMail(MailDto mailDto);

	public boolean starredMail(int mailId);

	public boolean deleteMail(int mailId);
	
	public boolean isValidPassword(String password);

	
}
