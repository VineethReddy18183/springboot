package com.example.springbootdto.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdto.model.Location;
import com.example.springbootdto.model.User;


import com.example.springbootdto.repository.LocationJpaRepository;
import com.example.springbootdto.repository.UserJpaRepository;
import com.example.springbootdto.repository.UserRepository;

@Service
public class UserService implements UserRepository{
	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired 
	private LocationJpaRepository locationJpaRepository;
	
	
	public List<User> getAllUsersLocation()
	{
		return userJpaRepository.findAll();
	}
	
	
	public List<User> addUser(User user,Long locationId)
	{
		
		
		Location location = locationJpaRepository.findById(locationId).get();
		
		user.setLocation(location);
		
		userJpaRepository.save(user);
		return userJpaRepository.findAll();
	}
	
	
	
	

	
	
	
	
	
}
