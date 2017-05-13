package com.person.shop.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
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
	private LocalDateTime date = LocalDateTime.now();
	
	private User testUser;
	
	@Before
	public void setup(){
		testUser = new User.Builder("email@shop.com", "name", "password").setRole(Role.USER)
				.setCreateDate(date).setUpdateDate(date).build();
	}

	@Test
	public void checkForDuplicateEmailTest() {
		when(userRepository.findUserByEmail("email@shop.com"))
			.thenReturn(testUser);
		
		assertTrue(userService.checkForDuplicateEmail("email@shop.com"));
		assertFalse(userService.checkForDuplicateEmail("anotherEmail@shop.com"));
	}
}
