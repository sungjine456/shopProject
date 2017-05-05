package com.person.shop.service;

import com.person.shop.domain.User;

public interface UserService {
	void save(User user);
	User findUserByEmail(String email);
	boolean checkForDuplicateEmail(String email);
}
