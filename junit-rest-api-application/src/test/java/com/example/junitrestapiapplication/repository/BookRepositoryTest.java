package com.example.junitrestapiapplication.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.junitrestapiapplication.model.Book;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	private BookJpaRepository bookJpaRepository;

	@Autowired
	private BookRepository bookRepository;

	Book book;
	List<Book> bookList = new ArrayList<>();

	@BeforeEach
	void setUp() {

		book = new Book(1L, "Atomic Habits", "Build daily habits", "10");
		bookJpaRepository.save(book);
		bookList.add(book);
		book = new Book(2L, "CS Fundamentals", "Learn computer science", "9");
		bookJpaRepository.save(book);
		bookList.add(book);
	}

	@AfterEach
	void tearDown() {
		bookJpaRepository.deleteAll();
		bookList.clear();
	}

	// Test case Success
	@Test
	void getBooks_success() {
		List<Book> books = bookJpaRepository.findAll();
		assertEquals(2, books.size());
	}

}
