package com.example.junitrestapiapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.junitrestapiapplication.model.Book;
import com.example.junitrestapiapplication.repository.BookJpaRepository;
import com.example.junitrestapiapplication.repository.BookRepository;

@Service
public class BookService implements BookRepository {

	@Autowired
	private BookJpaRepository bookJpaRepository;

	@Override
	public List<Book> getBooks() {
		List<Book> bookList = bookJpaRepository.findAll();
		return bookList;

	}

	@Override
	public Book getBookById(Long bookId) {
		Book book = bookJpaRepository.findById(bookId).get();
		if (book == null) {
			System.out.println("No such book found");
			return null;
		}
		return book;

	}

	@Override
	public List<Book> addBook(Book book) {
		bookJpaRepository.save(book);
		List<Book> bookList = bookJpaRepository.findAll();
		return bookList;

	}

	@Override
	public List<Book> updateBook(Long bookId, Book book) {
		Book oldBook = bookJpaRepository.findById(bookId).orElse(null);
		if (oldBook != null) {
			if (book.getName() != null && !book.getName().isEmpty()) {
				oldBook.setName(book.getName());
			}
			if (book.getRating() != null && !book.getRating().isEmpty()) {
				oldBook.setRating(book.getRating());
			}
			if (book.getSummary() != null && !book.getSummary().isEmpty()) {
				oldBook.setSummary(book.getSummary());
			}
			bookJpaRepository.save(oldBook);
		}
		List<Book> bookList = bookJpaRepository.findAll();
		return bookList;
	}

	@Override
	public void deleteBook(Long bookId) {
		bookJpaRepository.deleteById(bookId);

	}

}
