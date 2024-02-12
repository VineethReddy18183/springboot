package com.example.springbootdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootdto.model.User;

public interface  UserJpaRepository extends JpaRepository<User,Long>{

}
