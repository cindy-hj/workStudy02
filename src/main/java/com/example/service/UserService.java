package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {

	User save(User addUser);

	User findByUserIdAndUserPw(String userId, String userPw);

	User update(String userId, String userPw, String userName, String address, String phone, String tel);

	List<User> findAll();

}
