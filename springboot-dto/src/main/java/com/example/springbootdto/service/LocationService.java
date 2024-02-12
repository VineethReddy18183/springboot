package com.example.springbootdto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdto.model.Location;
import com.example.springbootdto.repository.LocationJpaRepository;
import com.example.springbootdto.repository.LocationRepository;

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
