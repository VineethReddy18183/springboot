package com.example.edulearn.repository;

import java.util.ArrayList;
import java.util.List;



import com.example.edulearn.model.Course;
import com.example.edulearn.model.Users;

public interface CourseRepository{
	ArrayList<Course> getCourses();
	
	Course getCourseById(int courseId);
	
	Course addCourse(Course course);
	
	Course updateCourse(int courseId,Course course);
	
	void deleteCourse(int courseId);
	
	List<Users> getCourseUsers(int id);
}
