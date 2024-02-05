package com.example.demo.repository;

import com.example.demo.model.*;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book,Integer>{
     ArrayList<Book> findByPublisher(Publisher publisher);
}