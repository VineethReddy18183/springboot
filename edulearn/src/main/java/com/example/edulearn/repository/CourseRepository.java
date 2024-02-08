package com.example.edulearn.repository;
import com.example.edulearn.model.Users;

import java.util.ArrayList;




import com.example.edulearn.model.Course;
public interface CourseRepository{
	ArrayList<Course> getCourses(int userId);
	
	Course getCourseById(int courseId);
	
	Course addCourse(int id,Course course);
	
	Course updateCourse(int courseId,Course course,int userId);
	
	ArrayList<Course> enrollCourse(int userId,int courseId);
	
	ArrayList<Course> addfavoriteCourse(int userId,int courseId);
	
	void deleteCourse(int courseId);
	
	ArrayList<Users> getCourseEnrolledUsers(int id);
	
    ArrayList<Users> getCourseAuthoredUser(int id);
}
