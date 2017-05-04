package com.person.shop.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.person.shop.domain.DetailUser;
import com.person.shop.domain.User;
import com.person.shop.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public DetailUser loadUserByUsername(String email) throws UsernameNotFoundException, NumberFormatException {
    	log.info(email);
    	User user = userRepository.findUserByEmail(email);
    	log.info(user.toString());
        return new DetailUser(user);
    }
}
