package com.example.edulearn.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import com.example.edulearn.model.Users;

@Entity
@Table(name = "course")
public class Course{
	
	@Id
	@Column(name = "course_id")
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int course_id;
	
	@Column(name = "course_title")
	private String course_title;
	
	@Column(name = "course_category")
	private String course_category;
	
	
	@JsonIgnoreProperties("courses")
	@ManyToMany(mappedBy = "courses")
	private List<Users> users;
	public Course()
	{
		
	}
	
	

	public Course(int course_id, String course_title, String course_category) {
		super();
		this.course_id = course_id;
		this.course_title = course_title;
		this.course_category = course_category;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getCourse_category() {
		return course_category;
	}

	public void setCourse_category(String course_category) {
		this.course_category = course_category;
	}
	
	public List<Users> getUsers()
	{
		return users;
	}
	
	public void setUsers(List<Users> users)
	{
		this.users = users;
	}

	
	
	
	
	
	
}

