package com.person.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.shop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByIdx(long idx);
	User findUserByEmail(String email);
}
