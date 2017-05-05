package com.person.shop.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

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

	@Autowired private UserRepository userRepository;
	
	@Test
	public void findUserByIdxTest() {
		User user = userRepository.findUserByIdx(1L);
		
		assertThat(user.getEmail(), is("email"));
		assertThat(user.getName(), is("name"));
		assertThat(user.getPassword(), is("admin"));
	}
	
	@Test
	public void findUserByEmailTest() {
		User user = userRepository.findUserByEmail("email");
		
		assertThat(user.getEmail(), is("email"));
		assertThat(user.getName(), is("name"));
		assertThat(user.getPassword(), is("admin"));
	}
	
	@Test
	public void saveTest() {
		User user = userRepository.findUserByEmail("email1");
		
		assertNull(user);
		
		userRepository.save(new User("email1", "name", "111", Role.USER));
		
		user = userRepository.findUserByEmail("email1");
		
		assertNotNull(user);
		assertEquals(2, user.getIdx());
		assertEquals("email1", user.getEmail());
		assertEquals("name", user.getName());
		assertEquals("111", user.getPassword());
		assertEquals("USER", user.getRole().name());
	}
}
