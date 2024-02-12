package com.example.springbootdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootdto.model.Location;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location,Long>{

}
