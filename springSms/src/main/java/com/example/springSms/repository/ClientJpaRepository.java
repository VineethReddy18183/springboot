package com.example.springSms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSms.model.Client;

@Repository
public interface ClientJpaRepository extends JpaRepository<Client, Integer> {

}
