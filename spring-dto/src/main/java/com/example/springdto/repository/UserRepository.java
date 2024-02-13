package com.example.springdto.repository;

import java.util.List;

import com.example.springdto.model.User;
import com.example.springdto.model.UserDto;

public interface UserRepository {
	
	 List<UserDto> getAllUsersLocation();
	 List<User> addUser(User user,Long locationId);

}
