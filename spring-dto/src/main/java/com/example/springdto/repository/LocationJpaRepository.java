package com.example.springdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdto.model.Location;

public interface LocationJpaRepository extends JpaRepository<Location,Long>{

}
