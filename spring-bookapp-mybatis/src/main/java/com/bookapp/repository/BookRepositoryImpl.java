package com.bookapp.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.module.Book;
import com.bookapp.util.Queries;

public class BookRepositoryImpl implements  IBookRepository{
	private JdbcTemplate jdbcTemplate;
	
	
    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public void addBook(Book book) {
		Object[] bookArr= {book.getTitle(),book.getAuthor(),book.getPrice(), book.getCategory()};
		jdbcTemplate.update(Queries.INSERTQUERY,bookArr);
    }

    @Override
    public void updateBook(int bookId, double price) {
    	jdbcTemplate.update(Queries.UPDATEQUERY,bookId);
    }

    @Override
    public void deleteBook(int bookId) {
    	jdbcTemplate.update(Queries.DELETEQUERY,bookId);
    }

    @Override
    public Book getById(int bookId) throws IdNotFoundException {
        return null;
    }

    public List<Book> findAll() {
    	RowMapper<Book> mapper =new BookMapper();
    	List<Book> books =	jdbcTemplate.query(Queries.SELECTQUERY,mapper);
        return null;
    }

    @Override
    public List<Book> findByAuthor(String author) throws BookNotFoundException {
    	return jdbcTemplate.query(Queries.
    			SELECTBYAUTHORQUERY,(rs,rowNum)->{
    		Book book=new  Book();
    		book.setAuthor(rs.getString("author"));
    		book.setBookId(rs.getInt("book_id"));
    		book.setCategory(rs.getString("category"));
    		book.setTitle(rs.getString("title"));
    		book.setPrice(rs.getDouble("price"));
    		return book;
    	},author);
    	
        
    }

    @Override
    public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
    	List<Book> books=jdbcTemplate.query(Queries.SELECTBYPRICEQUERY, new BookMapper(),price);
        return null;
    }

	@Override
	public List<Book> findAll(int bookId) {
		
		return null;
	}

	@Override
	public List<Book> findByAuthorCategory(String author, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
}
