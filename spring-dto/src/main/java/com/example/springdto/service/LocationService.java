package com.example.springdto.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdto.model.Location;
import com.example.springdto.repository.LocationJpaRepository;
import com.example.springdto.repository.LocationRepository;

@Service
public class LocationService implements LocationRepository{
	
	@Autowired 
	private LocationJpaRepository locationJpaRepository;
	
	
	public List<Location> getLocations()
	{
		return locationJpaRepository.findAll();
	}
	
	public List<Location> addLocation(Location location)
	{
		locationJpaRepository.save(location);
		return locationJpaRepository.findAll();
		
	}
	
	

}
