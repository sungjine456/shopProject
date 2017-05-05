package com.person.shop.dto;

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
			return new User(email, name, password, Role.USER);
		} else {
			throw new PasswordAndPasswordConfirmDoNotMatchException();
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
