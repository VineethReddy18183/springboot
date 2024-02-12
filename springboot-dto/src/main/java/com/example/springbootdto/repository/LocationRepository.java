package com.example.springbootdto.repository;

import java.util.List;

import com.example.springbootdto.model.Location;

public interface LocationRepository {
	 List<Location> getLocations();
	 List<Location> addLocation(Location location);
}
