package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public String createNewUser(User user) {

		if (userDao.insertUser(user) > 0)
			return "User Created Successfully";
		else {
			return "Failed to Create new user";
		}

	}
	
	public User loginUser(User user) {
		return userDao.getUserWithPassword(user);
		
	}

}
