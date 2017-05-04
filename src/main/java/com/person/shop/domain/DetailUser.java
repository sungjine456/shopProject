package com.person.shop.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class DetailUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	
	private User user;

    public DetailUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getIdx() {
        return user.getIdx();
    }

    public Role getRole() {
        return user.getRole();
    }
}
