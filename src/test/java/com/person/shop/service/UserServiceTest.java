package com.person.shop.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.person.shop.ShopProjectApplication;
import com.person.shop.domain.Role;
import com.person.shop.domain.User;
import com.person.shop.repository.UserRepository;
import com.person.shop.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShopProjectApplication.class)
public class UserServiceTest {
	
	@Mock private UserRepository userRepository;
	@InjectMocks private UserServiceImpl userService;

	@Test
	public void checkForDuplicateEmailTest() {
		when(userRepository.findUserByEmail("email"))
			.thenReturn(new User("email", "name", "pass", Role.USER));
		
		assertTrue(userService.checkForDuplicateEmail("email"));
		assertFalse(userService.checkForDuplicateEmail("anotherEmail"));
	}
}
