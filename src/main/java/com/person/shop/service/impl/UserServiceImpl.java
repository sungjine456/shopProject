package com.person.shop.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.person.shop.domain.User;
import com.person.shop.repository.UserRepository;
import com.person.shop.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired private UserRepository userRepository;
	
	public void save(User user){
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public User findUserByEmail(String email){
		return userRepository.findUserByEmail(email);
	}
	
	/**
	 * 중복되면         : true
	 * 중복되지 않으면 : false
	 * @param email
	 * @return
	 */
	public boolean checkForDuplicateEmail(String email){
		return (userRepository.findUserByEmail(email) != null) ? true : false;
	}
}
