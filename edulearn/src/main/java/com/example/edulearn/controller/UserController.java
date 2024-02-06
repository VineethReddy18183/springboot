package com.example.edulearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.edulearn.model.Course;
import com.example.edulearn.model.Users;
import com.example.edulearn.service.UserJpaService;

@RestController
public class UserController {
	@Autowired
	UserJpaService userJpaService;
	
	@GetMapping("/users")
	
	public ArrayList<Users> getUsers()
	{
		return userJpaService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	
	public Users getUserById(@PathVariable("userId") int id)
	{
		return userJpaService.getUserById(id);
	}
	
	@PostMapping("/users")
	
	public Users addUser(@RequestBody Users user)
	{
		return userJpaService.addUser(user);
	}
	
	@PutMapping("/users/{userId}")
	public Users updateUser(@PathVariable("userId") int id,@RequestBody Users user)
	{
		return userJpaService.updateUser(id,user);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable("userId") int id)
	{
		userJpaService.deleteUser(id);
	}
	
	@GetMapping("/users/{userId}/courses")
	public List<Course> getUserCourses(@PathVariable("userId") int userId)
	{
		return getUserCourses(userId);
	}

}
