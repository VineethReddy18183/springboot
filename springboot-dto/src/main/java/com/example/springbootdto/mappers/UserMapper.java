package com.example.springbootdto.mappers;

import org.mapstruct.Mapper;

import com.example.springbootdto.model.User;
import com.example.springbootdto.modeldto.UserDto;


@Mapper
public interface UserMapper {
	UserDto modelToDto(User user);
	User dtoTomodel(UserDto userDto);
}


