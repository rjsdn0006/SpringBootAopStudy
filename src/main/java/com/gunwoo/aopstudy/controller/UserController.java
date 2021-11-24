package com.gunwoo.aopstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunwoo.aopstudy.aspect.TokenRequired;
import com.gunwoo.aopstudy.dto.UserDTO;
import com.gunwoo.aopstudy.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public void insertUser(@RequestBody UserDTO user) {
		userService.insertUser(user);
	}
	
	@GetMapping("")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@TokenRequired
	@GetMapping("/{userId}")
	public UserDTO getUserByUserId(@PathVariable String userId) {
		return userService.getUserByUserId(userId);
	}
	
	@PutMapping("/{userId}")
	public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
		userService.updateUserPw(userId, user);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
	}
}
