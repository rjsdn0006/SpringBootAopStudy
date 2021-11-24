package com.gunwoo.aopstudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunwoo.aopstudy.dto.UserDTO;
import com.gunwoo.aopstudy.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserDTO insertUser (UserDTO user) {
		return userRepository.insertUser(user);
	}
	
	public List<UserDTO> getAllUsers(){
		return userRepository.getAllUsers();
	}
	
	public UserDTO getUserByUserId(String userId) {
		return userRepository.getUserByUserId(userId);
	}
	public void updateUserPw(String userId, UserDTO user) {
		userRepository.updateUserPw(userId, user);
	}
	public void deleteUser(String userId) {
		userRepository.deleteUser(userId);
	}
}
