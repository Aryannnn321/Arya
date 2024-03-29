package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.exceotion.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
	}
	@Autowired
	IBookService bookService;
	@Override
	public void run(String... args) throws Exception {
		   Scanner s=new Scanner(System.in);
	        String name =s.next();
	        IBookService bookService=new BookServiceImpl();
	        List<Book> booksByCategory;
	      
	            booksByCategory=bookService.getByCategory(name);
	            for (Book book:booksByCategory){
	                System.out.println(book);
	            }
	      
	        
	        List<Book> booksByAuthor;
	       
	            booksByAuthor=bookService.getByAuthorStartswitch(name);
	            for (Book book:booksByAuthor){
	                System.out.println(book);
	            }
	       
        
	}

}
