package com.example.springdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdto.model.User;

public interface UserJpaRepository extends JpaRepository<User,Long>{

}
