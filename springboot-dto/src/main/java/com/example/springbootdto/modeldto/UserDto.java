package com.example.springbootdto.modeldto;

import com.example.springbootdto.model.Location;

import lombok.Data;


@Data
public class UserDto{
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private Location location;
	
	
}
