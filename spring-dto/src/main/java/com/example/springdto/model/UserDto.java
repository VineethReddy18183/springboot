package com.example.springdto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private Location location;
}
