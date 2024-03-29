package com.example.edulearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.edulearn.model.Users;
import com.example.edulearn.model.Course;
import com.example.edulearn.service.CourseJpaService;

@RestController
public class CourseController {
	@Autowired
	
	CourseJpaService courseJpaService;
	
	@GetMapping("/courses/{userId}")
	public ArrayList<Course> getCourses(@PathVariable("userId") int userId)
	{
		return courseJpaService.getCourses(userId);
	}
	
	@GetMapping("/courses/{courseId}/{userId}")
	public Course getCourseById(@PathVariable("courseId") int id)
	{
		return courseJpaService.getCourseById(id);
	}
	@PostMapping("/courses/{userId}")
    public Course postMethodName(@PathVariable("userId") int id,@RequestBody Course course) {
       return courseJpaService.addCourse(id,course);
    }
    @PutMapping("/courses/{courseId}/{userId}")
    public Course putMethodName(@PathVariable("courseId") int id,@PathVariable("userId") int userId, @RequestBody Course course) {
        
        return courseJpaService.updateCourse(id,course,userId);
    }
    @DeleteMapping("/courses/{courseId}")
    public void delete(@PathVariable("courseId") int id) {
        courseJpaService.deleteCourse(id);
        
    }
    @GetMapping("/courses/enrolledcourses/25/{courseId}/users")
    public List<Users> getusers(@PathVariable("courseId") int id) {
        return courseJpaService.getCourseEnrolledUsers(id);
    }
    
    @PostMapping("/courses/enrol/{userId}/{courseId}")
    public ArrayList<Course> enrollCourse(@PathVariable("userId") int userId,@PathVariable("courseId") int courseId)
    {
    	return courseJpaService.enrollCourse(userId, courseId);
    }
    
    @PostMapping("courses/add/fav/{userId}/{courseId}")
    public ArrayList<Course> addfavoriteCourse(@PathVariable("userId") int userId,@PathVariable("courseId") int courseId)
    {
    	return courseJpaService.addfavoriteCourse(userId, courseId);
    }
    
    @GetMapping("/author/{courseId}")
    public ArrayList<Users> getCourseAuthor(@PathVariable("courseId") int courseId)
    {
    	List<Users> courseAuthors =  courseJpaService.getCourseAuthoredUser(courseId);
    	ArrayList<Users> courseAuthorList = new ArrayList<>(courseAuthors);
    	return courseAuthorList;
    }
	
	
    
	

}
