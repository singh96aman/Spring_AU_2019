package com.au.aulibrary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.au.aulibrary.model.Book;
import com.au.aulibrary.model.Checkout;

@Repository
public class BooksDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Book> getAllBooks() {
		return jdbcTemplate.query("select * from realtimewebapp.bookrepo", (rs, i) -> {
			return new Book(rs.getString("id"), 
					rs.getString("bookName"), 
					rs.getString("authorName"), 
					rs.getDouble("price"), 
					rs.getString("description"));
		});
	}
	
	public List<Checkout> getAllCheckoutBooks() {
		return jdbcTemplate.query("select * from realtimewebapp.checkout", (rs, i) -> {
			return new Checkout(rs.getString("id"), 
					rs.getString("bookName"));
		});
	}
	
	public Book getBookById(String bookID) {
		List<Book> books = jdbcTemplate.query("select * from realtimewebapp.bookrepo where id='"+bookID+"'", (rs, i) -> {
			return new Book(rs.getString("id"), 
					rs.getString("bookName"), 
					rs.getString("authorName"), 
					rs.getDouble("price"), 
					rs.getString("description"));
		});
		return books.get(0);	
		}
	
	public Book create(Book book) {
		jdbcTemplate.update("insert into realtimewebapp.bookrepo values ('"+book.getId()+"','"+book.getBookName()+"','"+book.getAuthorName()+"',"+book.getPrice()+",'"+book.getDescription()+"')");
		return book;
	}
	
	public String checkoutBook(Checkout checkout) {
		jdbcTemplate.update("insert into realtimewebapp.checkout values ('"+checkout.getId()+"','"+checkout.getBookName()+"')");
		return checkout.getId();
	}

}
