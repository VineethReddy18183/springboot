package com.example.junitrestapiapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.junitrestapiapplication.model.Book;

@Repository

public interface BookJpaRepository extends JpaRepository<Book, Long> {

}
