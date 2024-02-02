package com.example.goodreadsTwoTables.repository;

import java.util.ArrayList;

import com.example.goodreadsTwoTables.model.Book;
import com.example.goodreadsTwoTables.model.Publisher;

public interface BookRepository {
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

    Book addBook(Book book);

    Book updateBook(int bookId, Book book);

    void deleteBook(int bookId);

    Publisher getBookPublisher(int bookId);
}
