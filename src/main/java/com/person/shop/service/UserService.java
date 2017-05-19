package com.person.shop.service;

import com.person.shop.domain.User;
import com.person.shop.pojo.CheckMessage;

public interface UserService {
	boolean save(User user);
	User findUserByEmail(String email);
	CheckMessage checkForDuplicateEmail(String email);
	User leave(String email);
	User update(User user);
	String translatePassword(String email);
}
