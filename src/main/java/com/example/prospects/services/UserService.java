package com.example.prospects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.prospects.model.User;
import com.example.prospects.repository.UserRepo;

@Component
public class UserService {

	@Autowired
	private UserRepo userRepo;


	public User findByUsernameOrEmail(String input) {
		User user = null;
		try {
//			user = userRepo.findByUsernameOrEmail(input);
			user = userRepo.findByUsername(input);
//			user = userRepo.findByEmail(input);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}
}
