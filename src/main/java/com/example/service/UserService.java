package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {

	public User saveOrUpdateUser(User user);

	public List<User> listUsers();
	
	public User getUserById(int id);
}
