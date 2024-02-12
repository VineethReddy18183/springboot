package com.example.springbootdto.repository;

import java.util.List;

import com.example.springbootdto.model.User;


public interface UserRepository{
	 List<User> getAllUsersLocation();
	 List<User> addUser(User user,Long locationId);
}
