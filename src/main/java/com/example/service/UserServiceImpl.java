package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User addUser) {
		
		return userRepository.save(addUser);
	}

	@Override
	public User findByUserIdAndUserPw(String userId, String userPw) {
		
		return userRepository.findByUserIdAndUserPw(userId, userPw);
	}

	@Transactional
	@Override
	public User update(String userId, String userPw, String userName, String address, String phone, String tel) {
		
		User mUser = userRepository.findById(userId).get();
		mUser.update(userId, userPw, userName, address, phone, tel);
		
		return mUser;
	}
}
