package com.person.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="USERS")
public class User {
	@Id
	@GeneratedValue
	private long idx;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
    private Role role;
	
	public User(){}
	public User(String email, String name, String password){
		this.email = email;
		this.name = name;
		this.password = password;
		role = Role.USER;
	}

	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString(){
		return "idx : " + idx + ", email : " + email + ", name : " + name;
	}
}
