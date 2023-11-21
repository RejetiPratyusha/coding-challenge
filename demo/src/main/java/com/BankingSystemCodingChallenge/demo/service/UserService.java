package com.BankingSystemCodingChallenge.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystemCodingChallenge.demo.model.User;
import com.BankingSystemCodingChallenge.demo.repository.UserRepository;

@Service 
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User insert(User user) {
		return userRepository.save(user);
	}

}
