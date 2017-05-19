package com.person.shop.service.impl;

import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.person.shop.common.CommonUtils;
import com.person.shop.domain.User;
import com.person.shop.pojo.CheckMessage;
import com.person.shop.repository.UserRepository;
import com.person.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserRepository userRepository;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public boolean save(User user){
		if(user != null && user.changePassword(bCryptPasswordEncoder.encode(user.getPassword()))){
			userRepository.save(user);
			return true;
		}
		return false;
	}
	
	public User findUserByEmail(String email){
		if(CommonUtils.isEmail(email)){
			return userRepository.findUserByEmail(email);
		}
		return null;
	}
	
	/**
	 * 중복되면         : false
	 * 중복되지 않으면 : true
	 * @param email
	 * @return
	 */
	public CheckMessage checkForDuplicateEmail(String email){
		if(StringUtils.isEmpty(email)){
			return new CheckMessage(false, "이메일을 입력해주세요.");
		}
		if(CommonUtils.isEmail(email)){
			boolean emailCheck = userRepository.findUserByEmail(email) == null;
			String message = emailCheck?"가입 가능한 이메일입니다.":"이미 가입되어 있는 이메일입니다.";
			return new CheckMessage(emailCheck, message);
		}
		return new CheckMessage(false, "올바른 형식의 이메일을 확인해주세요.");
	}
	
	public User leave(String email){
		if(!CommonUtils.isEmail(email)){
			return null;
		}
		User user = userRepository.findUserByEmail(email);
		user.leave();
		
		return userRepository.save(user);
	}
	
	public User update(User user){
		if(user != null && user.update(user.getEmail(), user.getName())){
			return userRepository.save(user);
		}
		return null;
	}
	
	public String translatePassword(String email){
		if(!CommonUtils.isEmail(email)){
			return null;
		}
		User user = userRepository.findUserByEmail(email);
		
		StringBuilder random = new StringBuilder();
		IntStream.range(0, 6).forEach(i->random.append((int)(Math.random() * 10)));
		
		String translatePassword = bCryptPasswordEncoder.encode(random);
		
		user.changePassword(translatePassword);
		
		userRepository.save(user);
		
		return random.toString();
	}
}
