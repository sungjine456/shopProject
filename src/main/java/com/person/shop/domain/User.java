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
	@Column(name = "use_yn")
	private boolean useYn = true;
	@Column(name = "create_date", nullable = false)
	private LocalDateTime createDate;
	@Column(name = "update_date", nullable = false)
	private LocalDateTime updateDate;
	
	public User(){}
	private User(Builder builder){
		this.email = builder.email;
		this.name = builder.name;
		this.password = builder.password;
		this.role = builder.role;
		this.createDate = builder.createDate;
		this.updateDate = builder.updateDate;
	}
	
	public static class Builder {
		private String email;
		private String name;
		private String password;
		private Role role;
		private LocalDateTime createDate;
		private LocalDateTime updateDate;
		
		public Builder(String email, String name, String password){
			this.email = email;
			this.name = name;
			this.password = password;
		}
		
		public Builder setRole(Role role){
			this.role = role;
			return this;
		}
		public Builder setCreateDate(LocalDateTime createDate){
			this.createDate = createDate;
			return this;
		}
		public Builder setUpdateDate(LocalDateTime updateDate){
			this.updateDate = updateDate;
			return this;
		}
		public User build(){
			return new User(this);
		}
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
