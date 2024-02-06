package com.example.edulearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edulearn.model.Course;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course,Integer>
{

}