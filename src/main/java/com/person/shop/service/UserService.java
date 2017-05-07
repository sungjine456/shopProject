package com.person.shop.service;

import com.person.shop.domain.User;

public interface UserService {
	void save(User user);
	User findUserByEmail(String email);
	boolean checkForDuplicateEmail(String email);
	User leave(String email);
	User update(User user);
	String translatePassword(String email);
}
