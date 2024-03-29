package com.bookapp.util;

import com.bookapp.model.Book;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BookDetails {
    public List<Book> showBooks(){
        return Arrays.asList(
                new Book("java", "david", "admin", 2, 100),
                new Book("css", "david", "manager", 3,900),
                new Book("html", "suhas", "admin", 7, 700),
                new Book("spring", "arya", "admin", 4, 800)
        );
    }
}
