package com.example.springdto.service;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdto.model.Location;
import com.example.springdto.model.User;
import com.example.springdto.model.UserDto;
import com.example.springdto.repository.LocationJpaRepository;
import com.example.springdto.repository.UserJpaRepository;
import com.example.springdto.repository.UserRepository;

@Service
public class UserService implements UserRepository{
	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired 
	private LocationJpaRepository locationJpaRepository;
	
	
	public List<UserDto> getAllUsersLocation()
	{
		List<User> userList =  userJpaRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		for(User user : userList)
		{
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setLocation(user.getLocation());
			userDtoList.add(userDto);
			
		}
		return userDtoList;
	}
	
	
	public List<User> addUser(User user,Long locationId)
	{
		
		
		Location location = locationJpaRepository.findById(locationId).get();
		
		user.setLocation(location);
		
		userJpaRepository.save(user);
		return userJpaRepository.findAll();
	}
	
	
	
	

	
	
	
	
	
}

