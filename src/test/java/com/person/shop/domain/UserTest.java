package com.person.shop.domain;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	private LocalDateTime date = LocalDateTime.now();
	
	@Before
	public void setup(){
		user = new User.Builder("email@shop.com", "name", "password").setRole(Role.USER)
				.setCreateDate(date).setUpdateDate(date).build();
	}

	@Test
	public void updateTest() {
		assertFalse(user.update(null, null));
		assertFalse(user.update(null, ""));
		assertFalse(user.update("", null));
		assertFalse(user.update("", ""));
		assertFalse(user.update("email", "name"));
		assertFalse(user.update("email@shop", "name"));
		assertFalse(user.update("email@shop.", "name"));
		assertTrue(user.update("email2@shop.com", "name2"));
		assertEquals(user.getEmail(), "email2@shop.com");
		assertEquals(user.getName(), "name2");
	}
	
	@Test
	public void passwordChangeTest(){
		assertFalse(user.changePassword(null));
		assertFalse(user.changePassword(""));
		assertTrue(user.changePassword("123456"));
		assertEquals(user.getPassword(), "123456");
	}
}
