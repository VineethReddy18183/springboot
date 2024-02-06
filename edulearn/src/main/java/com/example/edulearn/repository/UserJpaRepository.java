package com.example.edulearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edulearn.model.Users;


@Repository
public interface UserJpaRepository extends JpaRepository<Users,Integer>{
	

}
