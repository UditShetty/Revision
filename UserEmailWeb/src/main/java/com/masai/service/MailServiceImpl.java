package com.masai.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.exception.NoMailFound;
import com.masai.module.Mail;
import com.masai.module.User;
import com.masai.repository.MailDao;
import com.masai.util.GetCurrentUser;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private GetCurrentUser getCurrentUser;

	@Autowired
	private MailDao mailDao;

	@Override
	public List<Mail> inbox() {

		User user = getCurrentUser.getCurrentUser();

		if (user == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			return mailDao.findByRecievers(user);
		}
	}

	@Override
	public List<Mail> sentBox() {

		User user = getCurrentUser.getCurrentUser();

		if (user == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			

			List<Mail> mailSentByUser = user.getSent();

			
			

			return mailSentByUser;

		}
	}

	

	@Override
	public List<Mail> getAllMail() {

		User user = getCurrentUser.getCurrentUser();

		if (user == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			Set<Mail> mailSet = new HashSet<>();

			
			if (user.getSent().size() > 0)
				mailSet.addAll(user.getSent());
			if (user.getStarred().size() > 0)
				mailSet.addAll(user.getStarred());

			mailSet.addAll(inbox());

			

			List<Mail> allMail = new ArrayList<>(mailSet);

			return allMail;

		}

	}

	
	@Override
	public List<Mail> getDeletedMails() {

		User currentLogedInUser = getCurrentUser.getCurrentUser();

		if (currentLogedInUser == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			List<Mail> deletedMails = currentLogedInUser.getStarred();

			return deletedMails;

		}
	}

	@Override
	public List<Mail> getStarredMails() {

		User currentLogedInUser = getCurrentUser.getCurrentUser();
		if (currentLogedInUser == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {

			List<Mail> starredMails = currentLogedInUser.getStarred();
			try {
				starredMails.removeAll(getDeletedMails());
			} catch (NoMailFound n) {

			}
			return starredMails;

		}
	}

}
