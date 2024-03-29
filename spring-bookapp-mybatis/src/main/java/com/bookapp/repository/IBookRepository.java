package com.bookapp.repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.module.Book;

import java.util.List;

public interface IBookRepository {
    void  addBook(Book book);
   void updateBook(int bookId, double price);
   void deleteBook(int bookId);
   Book getById(int bookId) throws IdNotFoundException;
   List<Book> findAll(int bookId);
   List<Book> findByAuthor(String author ) throws BookNotFoundException;
   List<Book> findByLesserPrice(double price) throws  BookNotFoundException;
List<Book> findByAuthorCategory(String author, String category);
List<Book> findByCategory(String category);

}
