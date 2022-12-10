package com.masai.service;

import java.util.List;

import com.masai.module.User;

public interface AdminService {

	public List<User> getAllUsers();

	

	public boolean deleteUser(String email);
}
