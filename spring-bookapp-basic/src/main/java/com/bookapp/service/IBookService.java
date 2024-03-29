package com.bookapp.service;

import com.bookapp.exceotion.BookNotFoundException;
import com.bookapp.exceotion.IdNotFoundException;
import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    List<Book> getByAuthorStartswitch(String author)throws BookNotFoundException;
    List<Book> getByCategory(String category)throws BookNotFoundException;
    List<Book> getByPriceLessThan(double price)throws BookNotFoundException;
    List<Book> getByAuthorcontainsAndCategory(String author, String category)throws BookNotFoundException;
    Book getById(int bookId) throws IdNotFoundException;
}

