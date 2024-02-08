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
import com.example.edulearn.repository.CourseRepository;
import com.example.edulearn.repository.UserJpaRepository;

@Service
public class CourseJpaService implements CourseRepository
{
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	public ArrayList<Course> getCourses(int userId) {
		Users existingUser = userJpaRepository.findById(userId).get();
		String roleType = existingUser.getUserrole();
		if("STUDENT".equals(roleType))
		{
			List<Course> courseList = courseJpaRepository.findAll();
			ArrayList<Course> courses = new ArrayList<>(courseList);
			return courses;
			
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public Course getCourseById(int courseId) {
		try {
			Course course = courseJpaRepository.findById(courseId).get();
			return course;
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@Override
	public Course addCourse(int id,Course course) {
		
		Users existingUser = userJpaRepository.findById(id).get();
		String roleType = existingUser.getUserrole();
		if("AUTHOR".equals(roleType))
		{
			/*List<Integer> userIds = new ArrayList<>();
			for(Users user:course.getUsers())
			{
				userIds.add(user.getId());
			}
			
			List<Users> users = userJpaRepository.findAllById(userIds);
			
			if(userIds.size() != users.size())
			{
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			course.setUsers(users);*/
			//course.setAuthoredUser(existingUser);
			
			courseJpaRepository.save(course);
			List<Course> authoredCourses = existingUser.getAuthoredCourses();
			authoredCourses.add(course);
			
			
			userJpaRepository.save(existingUser);
			return course;
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			
		}
		
		
		
		
		
	}

	@Override
	public Course updateCourse(int courseId, Course course,int userId) {
		Users existingUser = userJpaRepository.findById(userId).get();
		String roleType = existingUser.getUserrole();
		List<Course> courseList = existingUser.getAuthoredCourses();
		List<Integer> courseIds = new ArrayList<>();
		for(Course cours : courseList)
		{
			courseIds.add(cours.getCourse_id());
		}
		if("AUTHOR".equals(roleType) && courseIds.contains(courseId))
		{
			
		
			try {
				Course original = courseJpaRepository.findById(courseId).get();
				if((course.getCourse_title()) != null)
				{
					original.setCourse_title(course.getCourse_title());
					
					
				}
				if(course.getCourse_category() != null)
				{
					original.setCourse_category(course.getCourse_category());
				}
				
				/*if(course.getUsers() != null)
				{
					List<Users> users1 = original.getUsers();
					for(Users user : users1)
					{
						user.getCourses().remove(original);
					}
					userJpaRepository.saveAll(users1);
					List<Integer> ids = new ArrayList<>();
					for(Users user : course.getUsers())
					{
						ids.add(user.getId());
					}
					List<Users> users = userJpaRepository.findAllById(ids);
					original.setUsers(users);
					for(Users user : users)
					{
						user.getCourses().add(original);
					}
					userJpaRepository.saveAll(users);
				}*/
				courseJpaRepository.save(original);
				return original;
				
			
			}
			catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@Override
	
	public ArrayList<Course>  enrollCourse(int userId,int courseId)
	
	{
		Users existingUser = userJpaRepository.findById(userId).get();
		Course enrolCourse = courseJpaRepository.findById(courseId).get();
		
		
		
		if("STUDENT".equals(existingUser.getUserrole()))
		{
			List<Course> enrolledCourses = existingUser.getEnrolledCourses();
			if(!(enrolledCourses.contains(enrolCourse)))
			{	
				enrolledCourses.add(enrolCourse);
			}
			ArrayList<Course> enrolledCourseList = new ArrayList<>(enrolledCourses);
			
			userJpaRepository.save(existingUser);
			
			
			return enrolledCourseList;
			
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@Override
	public ArrayList<Course> addfavoriteCourse(int userId,int courseId)
	{
		Users existingUser = userJpaRepository.findById(userId).get();
		Course favoriteCourse = courseJpaRepository.findById(courseId).get();
		if("STUDENT".equals(existingUser.getUserrole()))
		{
			List<Course> favoriteCourses = existingUser.getFavoriteCourses();
			if(!(favoriteCourses.contains(favoriteCourse)))
			{
				favoriteCourses.add(favoriteCourse);
			}
			ArrayList<Course> favoriteCourseList = new ArrayList<>(favoriteCourses);
			userJpaRepository.save(existingUser);
			return favoriteCourseList;
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		
	}

	@Override
	public void deleteCourse(int courseId) {
		try {
			Course course = courseJpaRepository.findById(courseId).get();
			List<Users> enrolledUsers = course.getEnrolledCourseusers();
			List<Users> authoredUsers = course.getAuthoredCourseusers();
			
			for(Users enrolledUser: enrolledUsers)
			{
				enrolledUser.getEnrolledCourses().remove(course);
				
			}
			for(Users authoredUser : authoredUsers)
			{
				authoredUser.getAuthoredCourses().remove(course);
			}
			userJpaRepository.saveAll(enrolledUsers);
			userJpaRepository.saveAll(authoredUsers);
			courseJpaRepository.deleteById(courseId);
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public ArrayList<Users> getCourseEnrolledUsers(int id) {
		try {
		Course course = courseJpaRepository.findById(id).get();
		
		List<Users> enrolled =  course.getEnrolledCourseusers();
		
		ArrayList<Users> enrolledList = new ArrayList<>(enrolled);
		
		return enrolledList;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@Override 
	public ArrayList<Users> getCourseAuthoredUser(int id)
	{
		try {
			Course course = courseJpaRepository.findById(id).get();
			List<Users> authored =  course.getAuthoredCourseusers();
			ArrayList<Users> authoredList = new ArrayList<>(authored);
			return authoredList;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
