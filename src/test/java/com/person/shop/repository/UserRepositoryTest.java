package com.person.shop.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.person.shop.ShopProjectApplication;
import com.person.shop.domain.Role;
import com.person.shop.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShopProjectApplication.class)
@Sql({"classpath:init.sql"})
public class UserRepositoryTest {
	
	private LocalDateTime date = LocalDateTime.now();

	@Autowired private UserRepository userRepository;
	
	private User testUser;
	
	@Before
	public void setup(){
		testUser = new User.Builder("email1@shop.com", "name", "password").setRole(Role.USER)
				.setCreateDate(date).setUpdateDate(date).build();
	}
	
	@Test
	public void findUserByIdxTest() {
		User user = userRepository.findUserByIdx(1L);
		
		assertThat(user.getEmail(), is("email@shop.com"));
		assertThat(user.getName(), is("name"));
		assertThat(user.getPassword(), is("pass"));
	}
	
	@Test
	public void findUserByEmailTest() {
		User user = userRepository.findUserByEmail("email@shop.com");
		
		assertThat(user.getEmail(), is("email@shop.com"));
		assertThat(user.getName(), is("name"));
		assertThat(user.getPassword(), is("pass"));
	}
	
	@Test
	public void saveTest() {
		User user = userRepository.findUserByEmail("email1@shop.com");
		
		assertNull(user);
		
		userRepository.save(testUser);
		
		user = userRepository.findUserByEmail("email1@shop.com");
		
		assertNotNull(user);
		assertEquals(2, user.getIdx());
		assertEquals("email1@shop.com", user.getEmail());
		assertEquals("name", user.getName());
		assertEquals("password", user.getPassword());
		assertEquals("USER", user.getRole().name());
		
		user.update("email12@shop.com", "setName");
		userRepository.save(user);
		
		user = userRepository.findUserByEmail("email12@shop.com");
		
		assertNotNull(user);
		assertEquals(2, user.getIdx());
		assertEquals("email12@shop.com", user.getEmail());
		assertEquals("setName", user.getName());
		assertEquals("password", user.getPassword());
	}
}
