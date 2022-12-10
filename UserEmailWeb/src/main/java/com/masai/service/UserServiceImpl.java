package com.masai.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.exception.NoMailFound;
import com.masai.exception.PasswordMisMatchException;
import com.masai.exception.UserAlreadyExistException;
import com.masai.exception.UserNotFoundException;

import com.masai.module.Mail;
import com.masai.module.MailDto;
import com.masai.module.User;

import com.masai.repository.MailDao;
import com.masai.repository.UserDao;
import com.masai.util.GetCurrentUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Autowired
	private MailDao mailDao;

	@Autowired
	private GetCurrentUser getCurrentUser;

	@Autowired
	private MailService mailService;


	@Override
	public boolean addUser(User user) throws UserAlreadyExistException {

		Optional<User> optionalUser = userDao.findByEmail(user.getEmail());

		Optional<User> optionalMobile = userDao.findByMobileNumber(user.getMobileNumber());

		if (optionalMobile.isPresent()) {
			throw new UserAlreadyExistException(
					user.getMobileNumber() + " already exist please use different mobile number");
		}

		if (optionalUser.isPresent()) {
			throw new UserAlreadyExistException("Email already exist with the id " + user.getEmail());
		} else {
			User userWithEncoder = new User();

			userWithEncoder.setEmail(user.getEmail());
			

			if (!checkAge(user.getDateOfBirth())) {
				throw new IllegalArgumentException("Age should be atlease 18");
			}

			userWithEncoder.setDateOfBirth(user.getDateOfBirth());

			if (!isValidPassword(user.getPassword())) {
				throw new PasswordMisMatchException("Please follow password rules");
			}
			userWithEncoder.setPassword(passwordEncoder.encode(user.getPassword()));
			userWithEncoder.setFirstName(user.getFirstName());
			userWithEncoder.setLastName(user.getLastName());
			userWithEncoder.setMobileNumber(user.getMobileNumber());
			userDao.save(userWithEncoder);
		}

		return true;
	}

	@Override
	public boolean deleteUser() {
		User currentUser = getCurrentUser.getCurrentUser();
		if (currentUser == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			userDao.delete(currentUser);
			System.out.println("check");
			getCurrentUser.logout();

			return true;
		}

	}

	@Override
	public boolean sentMail(MailDto mailDto) {
			
		Mail mail = new Mail();
		
		User currentSender = getCurrentUser.getCurrentUser();


		if (currentSender == null) {
			throw new UserNotFoundException("User session expired, Please Login Again");
		} else {

			mail.setSender(currentSender);

			List<User> validUsers = mailDto.getRecievers().stream().filter((u1) -> this.checkIfUserExist(u1))
					.collect(Collectors.toList());

			mail.setRecievers(validUsers);
			mail.setSubject(mailDto.getSubject());
			mail.setBody(mailDto.getBody());
			mail.setTimeStamp(ZonedDateTime.now());



			mailDao.save(mail);

			Optional<User> optSender = userDao.findByEmail(mail.getSender().getEmail());

			User sender = optSender.get();

			List<Mail> sentBox = sender.getSent();

			sentBox.add(mail);

			userDao.save(sender);

			return true;

		}
	}

	@Override
	public boolean starredMail(int mailId) {

		User currentUser = getCurrentUser.getCurrentUser();
		if (currentUser == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			Optional<Mail> mailOptional = mailDao.findById(mailId);
			if (mailOptional.isPresent()) {
				if (currentUser.getStarred().contains(mailOptional.get())) {
					currentUser.getStarred().remove(mailOptional.get());
					userDao.save(currentUser);
					return false;
				} else {
					currentUser.getStarred().add(mailOptional.get());

					userDao.save(currentUser);

					return true;
				}
			} else {
				throw new NoMailFound("Mail Does not Exist");
			}
		}
	}



	@Override
	public boolean deleteMail(int mailId) {

		User currentLogenInUser = getCurrentUser.getCurrentUser();

		if (currentLogenInUser == null) {
			throw new UsernameNotFoundException("User session expired, Please Login Again");
		} else {
			Optional<Mail> mail = mailDao.findById(mailId);

			List<Mail> allMail = mailService.getAllMail();

			Mail temp = null;
			for (Mail mail1 : allMail) {
				if (mail1.getMailId() == mailId) {
					temp = mail1;
					break;
				}
			}

			if (temp != null) {

				List<Mail> inbox = mailService.inbox();
				inbox.remove(temp);

				temp.getRecievers().remove(currentLogenInUser);
				mailDao.save(temp);

				List<Mail> sentBox = currentLogenInUser.getSent();
				sentBox.remove(temp);

			

				List<Mail> starred = currentLogenInUser.getStarred();
				starred.remove(temp);

				

				userDao.save(currentLogenInUser);

			} else {
				throw new NoMailFound("Mail Not found");
			}

		}

		return true;

	}

	

	@Override
	public boolean isValidPassword(String password) {
		if (password == null) {
			return false;
		}

		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(password);

		return m.matches();
	}

	public boolean checkAge(LocalDate date) {

		LocalDate today = LocalDate.now();

		if (today.getYear() - date.getYear() >= 18) {
			return true;
		}
		return false;
	}

	public boolean checkIfUserExist(User user) {

		if (!userDao.findByEmail(user.getEmail()).isPresent()) {
			throw new UserNotFoundException("User with email " + user.getEmail() + " does not exist");
		}

		return true;
	}

	

}
