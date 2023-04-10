package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// create
	@PostMapping("/api/add/user")
	public ResponseEntity addUser(@RequestBody Map<String, String> params) {
		String userId = params.get("userId");
		String userPw = params.get("userPw");
		String userName = params.get("userName");
		String address = params.get("address");
		String phone = params.get("phone");
		String tel = params.get("tel");
		
		User addUser = new User();
		addUser.setUserId(userId);
		addUser.setUserPw(userPw);
		addUser.setUserName(userName);
		addUser.setAddress(address);
		addUser.setPhone(phone);
		addUser.setTel(tel);
	
		User rUser = userService.save(addUser);
		
		return new ResponseEntity<>(rUser, HttpStatus.OK);
	}
	
	@PostMapping("/api/add/usercheck")
	public ResponseEntity userCheck(@RequestBody Map<String, String> params) {
		String userId = params.get("userId");
		String userPw = params.get("userPw");
		
		User rUser = userService.findByUserIdAndUserPw(userId, userPw);
		if(rUser == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(rUser, HttpStatus.OK);
	}
	
	@PutMapping("/api/modified/user")
	public ResponseEntity modifiedUser(@RequestBody Map<String, String> params) {
		String userId = params.get("userId");
		String userPw = params.get("userPw");
		String userName = params.get("userName");
		String address = params.get("address");
		String phone = params.get("phone");
		String tel = params.get("tel");
		
		User rUser = userService.update(userId, userPw, userName, address, phone, tel);
		
		return new ResponseEntity<>(rUser, HttpStatus.OK);
	}
	
	@GetMapping("/api/list/user")
	public ResponseEntity listUsers() {
		List<User> users = userService.findAll();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
}
