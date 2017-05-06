package com.person.shop.service.impl;

import java.time.LocalDateTime;

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
		LocalDateTime date = LocalDateTime.now();
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRegDate(date);
		user.setUpDate(date);
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
	
	public User leave(String email){
		User user = userRepository.findUserByEmail(email);
		user.setUseYn('N');
		user.setUpDate(LocalDateTime.now());
		
		return userRepository.save(user);
	}
	
	public User update(User user){
		user.setUpDate(LocalDateTime.now());
		
		return userRepository.save(user);
	}
}
