package com.example.edulearn.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.edulearn.model.Users;
import com.example.edulearn.model.Course;
public interface UserRepository {
	
	ArrayList<Users> getUsers();
	Users getUserById(int userId);
	Users addUser(Users user);
	Users updateUser(int userId,Users user);
	void deleteUser(int userId);
	List<Course> getUserCourses(int id);
	
	

}
