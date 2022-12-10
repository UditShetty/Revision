package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserNotFoundException;
import com.masai.module.User;
import com.masai.repository.UserDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub

		List<User> users = userDao.findAll();
		if (users.size() != 0)
			return users;
		else {
			throw new UserNotFoundException("No User Exist in your System");
		}
	}

	

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		Optional<User> optUser = userDao.findByEmail(email);
		if (optUser.isPresent()) {

			userDao.delete(optUser.get());
			return true;
		} else {
			throw new UserNotFoundException("User with this email does not exist");
		}

	}

}
