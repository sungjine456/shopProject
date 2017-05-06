package com.person.shop.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="USERS")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "SEQ", initialValue = 1, allocationSize = 1)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
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
	@Column(name = "use_yn", nullable = false)
	private char useYn;
	@Column(name = "reg_date", nullable = false)
	private LocalDateTime regDate;
	@Column(name = "up_date", nullable = false)
	private LocalDateTime upDate;
	
	public User(){}
	public User(String email, String name, String password, Role role, LocalDateTime regDate, LocalDateTime upDate){
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		useYn = 'Y';
		this.regDate = regDate;
		this.upDate = upDate;
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
	public char getUseYn() {
		return useYn;
	}
	public void setUseYn(char useYn) {
		this.useYn = useYn;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDateTime getUpDate() {
		return upDate;
	}
	public void setUpDate(LocalDateTime upDate) {
		this.upDate = upDate;
	}
	
	@Override
	public String toString(){
		return "idx : " + idx + ", email : " + email + ", name : " + name;
	}
}
