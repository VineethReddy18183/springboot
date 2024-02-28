package com.example.junitrestapiapplication.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.junitrestapiapplication.model.Book;
import com.example.junitrestapiapplication.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/get")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping("/get/{bookId}")
	public Book getBookById(@PathVariable("bookId") Long bookId) {
		return bookService.getBookById(bookId);

	}

	@PostMapping("/add")
	public List<Book> addBook(@RequestBody Book book) {
		return bookService.addBook(book);

	}

	@PutMapping("/update/{bookId}")
	public List<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId) {
		return bookService.updateBook(bookId, book);
	}

	@DeleteMapping("delete/{bookId}")
	public void deleteBook(@PathVariable("bookId") Long bookId) {
		bookService.deleteBook(bookId);
	}

}
