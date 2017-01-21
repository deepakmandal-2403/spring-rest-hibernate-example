package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface UserDAO {

	public User saveOrUpdateUser(User user);

	public List<User> listUsers();
	
	public User getUserById(int id);
}
