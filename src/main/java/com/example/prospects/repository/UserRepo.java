package com.example.prospects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.prospects.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

//	@Query("SELECT u FROM user WHERE u.username = :input OR u.email = :input")
//	User findByUsernameOrEmail(String input);

	User findByUsername(String username);
	User findByEmail(String username);
}
