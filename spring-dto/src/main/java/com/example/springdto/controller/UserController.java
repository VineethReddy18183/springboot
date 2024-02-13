package com.example.springdto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.springdto.model.User;
import com.example.springdto.model.UserDto;
import com.example.springdto.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/users")
	public List<UserDto> getAllUsersLocation()
	{
		return userService.getAllUsersLocation();
		
	}
	


	@PostMapping("/add/users/{locationId}")
	public List<User> addUser(@RequestBody User user,@PathVariable("locationId") Long locationId)
	{
		return userService.addUser(user,locationId);
	}
	
	
}
