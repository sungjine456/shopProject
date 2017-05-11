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
	private boolean useYn;
	@Column(name = "create_date", nullable = false)
	private LocalDateTime createDate;
	@Column(name = "update_date", nullable = false)
	private LocalDateTime updateDate;
	
	public User(){}
	public User(String email, String name, String password, Role role, LocalDateTime createDate, LocalDateTime updateDate){
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		useYn = true;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public void create(String password){
		this.password = password;
		createDate = LocalDateTime.now();
		updateDate = LocalDateTime.now();
	}
	public void leave(){
		useYn = false;
		updateDate = LocalDateTime.now();
	}
	public void update(String email, String name){
		this.email = email;
		this.name = name;
		updateDate = LocalDateTime.now();
	}
	public void changePassword(String password){
		this.password = password;
		updateDate = LocalDateTime.now();
	}

	public long getIdx() {
		return idx;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public Role getRole() {
		return role;
	}
	public boolean getUseYn() {
		return useYn;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	
	@Override
	public String toString(){
		return "idx : " + idx + ", email : " + email + ", name : " + name;
	}
}
