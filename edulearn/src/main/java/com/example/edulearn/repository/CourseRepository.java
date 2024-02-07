package com.example.edulearn.repository;

import java.util.ArrayList;
import java.util.List;



import com.example.edulearn.model.Course;
import com.example.edulearn.model.Users;

public interface CourseRepository{
	ArrayList<Course> getCourses(int userId);
	
	Course getCourseById(int courseId);
	
	Course addCourse(int id,Course course);
	
	Course updateCourse(int courseId,Course course,int userId);
	
	void deleteCourse(int courseId);
	
	List<Users> getCourseUsers(int id);
}
