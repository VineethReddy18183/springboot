package com.example.edulearn.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "users")
public class Users{
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "user_role")
	private String user_role;
	
	
	
/*	@ManyToMany
	@JoinTable(
		name = "user_course",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	
	@JsonIgnoreProperties("users")
	private List<Course> courses = new ArrayList<>();
	
*/	
	
	@ManyToMany
	@JoinTable(
		name = "user_authoredCourse",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	@JsonIgnoreProperties({"authoredCourseusers","enrolledCourseusers"})
	private List<Course> authoredCourses = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(
		name = "user_enrolledCourse",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	@JsonIgnoreProperties({"enrolledCourseusers","authoredCourseusers"})
	private List<Course> enrolledCourses = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(
		name = "user_favoriteCourse",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	@JsonIgnoreProperties({"enrolledCourseusers","authoredCourseusers"})
	private List<Course> favoriteCourses = new ArrayList<>();
	
	public Users()
	{
		
	}
	
	
	
	public Users(int id, String name, String userrole) {
		super();
		this.user_id = id;
		this.user_name = name;
		this.user_role = userrole;
	}
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public String getName() {
		return user_name;
	}
	public void setName(String name) {
		this.user_name = name;
	}
	public String getUserrole() {
		return user_role;
	}
	public void setUserrole(String userrole) {
		this.user_role = userrole;
	}
	

	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}



	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}



	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}



	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	
	public List<Course> getFavoriteCourses() {
		return favoriteCourses;
	}



	public void setFavoriteCourses(List<Course> favoriteCourses) {
		this.favoriteCourses = favoriteCourses;
	}
	
	
	
	
	
}