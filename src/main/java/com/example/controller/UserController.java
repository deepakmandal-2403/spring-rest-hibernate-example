package com.example.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public User saveOrUpdateUser(@RequestBody User user) {
		userService.saveOrUpdateUser(user);
		LOGGER.info("User save/update successfully, " + user);
		return user;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		User user = userService.getUserById(id);
		LOGGER.info("User get by id, " + user);
		return user;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> userList = userService.listUsers();
		LOGGER.info("User list:" + userList);
		return userList;
	}
}
