package com.example.junitrestapiapplication.repository;

import java.util.List;

import com.example.junitrestapiapplication.model.Book;

public interface BookRepository {
	List<Book> getBooks();

	Book getBookById(Long bookId);

	List<Book> addBook(Book book);

	List<Book> updateBook(Long bookId, Book book);

	void deleteBook(Long bookId);

}
