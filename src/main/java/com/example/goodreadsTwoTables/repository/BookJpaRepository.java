package com.example.goodreadsTwoTables.repository;

import com.example.goodreadsTwoTables.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {

}
