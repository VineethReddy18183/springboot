package com.example.goodreadsJPA.repository;

import com.example.goodreadsJPA.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {}

