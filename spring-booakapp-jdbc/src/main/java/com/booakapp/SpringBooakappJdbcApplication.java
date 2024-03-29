package com.booakapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.module.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBooakappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBooakappJdbcApplication.class, args);
	}
	@Autowired
	IBookService bookService;
	@Override
	public void run(String... args) throws Exception {
//	List<Book> books =IBookService.getAll();
//	for(Book book:books) {
//		System.out.println(book);
//	}
	Book books=bookService.getById(100);
	System.out.println(books);
	}

}
