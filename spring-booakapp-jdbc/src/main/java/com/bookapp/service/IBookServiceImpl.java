package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.module.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class IBookServiceImpl implements IBookService
{
	@Autowired
	private IBookRepository bookRepository;
	
	public IBookServiceImpl(IBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<Book> getAll() {
		List<Book> books=bookRepository.findAll(0);
		if(books.isEmpty()) {
			throw new BookNotFoundException("no book found");
		}
		return null;
	}

	@Override
	public List<Book> getByAuthorStartswitch(String author) throws BookNotFoundException {
		List<Book> books=bookRepository.findByAuthor(author);
		if(books.isEmpty()) {
			throw new BookNotFoundException("no book found");
		}
		return books;
		
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books=bookRepository.findByCategory(category);
		if(books.isEmpty()) {
			throw new BookNotFoundException("no book found");
		}
		return books;
		
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books=bookRepository.findByLesserPrice(price);
		if(books.isEmpty()) {
			throw new BookNotFoundException("no book found");
		}
		return books;
	}

	@Override
	public List<Book> getByAuthorcontainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books=bookRepository.findByAuthorCategory(author,category);
		if(books.isEmpty()) {
			throw new BookNotFoundException("no book found");
		
		}
		return books;
		
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
	Book book=bookRepository.getById(bookId);
	if(book==null)
		throw new IdNotFoundException();
		return book;
	}
	
}
