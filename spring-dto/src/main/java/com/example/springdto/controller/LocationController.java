package com.example.springdto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdto.model.Location;
import com.example.springdto.service.LocationService;


@RestController
public class LocationController {
	@Autowired
    private LocationService locationService;
	
	@GetMapping("/locations")
	public List<Location> getLocations()
	{
		return locationService.getLocations();
	}
	
	@PostMapping("/add/location")
	public List<Location> addLocation(@RequestBody Location location)
	{
		return locationService.addLocation(location);
	}
}
