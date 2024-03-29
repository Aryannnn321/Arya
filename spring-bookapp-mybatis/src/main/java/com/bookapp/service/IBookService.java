package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.module.Book;

public interface IBookService {
	  static List<Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	    List<Book> getByAuthorStartswitch(String author)throws BookNotFoundException;
	    List<Book> getByCategory(String category)throws BookNotFoundException;
	    List<Book> getByPriceLessThan(double price)throws BookNotFoundException;
	    List<Book> getByAuthorcontainsAndCategory(String author, String category)throws BookNotFoundException;
	    Book getById(int bookId) throws IdNotFoundException;
}
