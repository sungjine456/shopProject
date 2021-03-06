package com.person.shop.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.person.shop.domain.Role;
import com.person.shop.domain.User;
import com.person.shop.exception.PasswordAndPasswordConfirmDoNotMatchException;

public class CreateUserRequestDto {
	@Email
	private String email;
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	@NotEmpty
	private String passwordConfirm;
	
	public User getUser() throws PasswordAndPasswordConfirmDoNotMatchException {
		if(password.equals(passwordConfirm)){
			LocalDateTime date = LocalDateTime.now();
			return new User.Builder(email, name, password).setRole(Role.USER)
							.setCreateDate(date).setUpdateDate(date).build();
		} else {
			throw new PasswordAndPasswordConfirmDoNotMatchException();
		}
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String toString(){
		return "email : " + email + ", name : " + name + ", password : " + password
				+ ", passwordConfirm : " + passwordConfirm;
	}
}
