package com.example.edulearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.edulearn.model.Course;
import com.example.edulearn.model.Users;
import com.example.edulearn.repository.CourseJpaRepository;
import com.example.edulearn.repository.UserJpaRepository;
import com.example.edulearn.repository.UserRepository;

@Service
public class UserJpaService implements UserRepository{
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	
	@Override
	public ArrayList<Users> getUsers()
	{
		List<Users> userList = userJpaRepository.findAll();
		ArrayList<Users> users = new ArrayList<>(userList);
		return users;
	}


	@Override
	public Users getUserById(int userId) {
		try
		{
			Users user = userJpaRepository.findById(userId).get();
			return user;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public Users addUser(int id,Users user) {
		
		Users existingUser = userJpaRepository.findById(id).get();
		String roleType = existingUser.getUserrole();
		
		if ("ADMIN".equals(roleType))
		{
			List<Integer> courseIds = new ArrayList<>();
			
			for(Course course:user.getCourses())
			{
				courseIds.add(course.getCourse_id());
			}
			List<Course> courses = courseJpaRepository.findAllById(courseIds);
			if(courses.size() != courseIds.size())
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			user.setCourses(courses);
			userJpaRepository.save(user);
			return user;
		}else
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}


	@Override
	public Users updateUser(int userId, Users user) {
		try {
		Users original = userJpaRepository.findById(userId).get();
		if(user.getName() != null)
		{
			original.setName(user.getName());
		}
		if(user.getUserrole() != null)
		{
			original.setUserrole(user.getUserrole());
			
		}
		if(user.getCourses() != null)
		{
			List<Integer> courseIds = new ArrayList<>();
			for(Course course:user.getCourses())
			{
				courseIds.add(course.getCourse_id());
			}
			List<Course> courses = courseJpaRepository.findAllById(courseIds);
			if(courses.size() != courseIds.size())
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			original.setCourses(courses);
		}
		userJpaRepository.save(original);
		return original;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		
	}


	@Override
	public void deleteUser(int userId) {
		try {
			userJpaRepository.deleteById(userId);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		
		
	}


	@Override
	public List<Course> getUserCourses(int id) {
		try {
			Users user = userJpaRepository.findById(id).get();
			return user.getCourses();
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	

}
