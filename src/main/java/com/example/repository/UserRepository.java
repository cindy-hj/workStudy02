package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUserIdAndUserPw(String userId, String userPw);

}
