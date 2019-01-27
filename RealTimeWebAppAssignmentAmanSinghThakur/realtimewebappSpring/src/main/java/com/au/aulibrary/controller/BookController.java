package com.au.aulibrary.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.au.aulibrary.model.Book;
import com.au.aulibrary.model.Checkout;
import com.au.aulibrary.repository.BooksDAO;

@RestController
public class BookController {
	
	@Autowired
	BooksDAO dao;

	@GetMapping(value="/books")
	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
		//books.add(new Book("1","How I sold My Ferrari to Work for Accolite","Aman Singh Thakur",100,"This book describes my adventures in Accolite"));
		//books.add(new Book("2", "A Tale of Two Cities", "William Shakespear", 200, "This book describes how long it feels to go from my office to home"));
		return dao.getAllBooks();
	}
	
	@GetMapping(value="/checkoutBooks")
	public List<Checkout> getAllCheckoutBooks() {
		List<Checkout> checkoutBooks = new ArrayList<Checkout>();
		//books.add(new Book("1","How I sold My Ferrari to Work for Accolite","Aman Singh Thakur",100,"This book describes my adventures in Accolite"));
		//books.add(new Book("2", "A Tale of Two Cities", "William Shakespear", 200, "This book describes how long it feels to go from my office to home"));
		return dao.getAllCheckoutBooks();
	}
	
	@RequestMapping(value="/books/{ID}/get", produces="application/json")
	public Book getBookById(@PathVariable(value="ID") String bookID) {
		//List<Book> books = new ArrayList<Book>();
		//books.add(new Book("1","How I sold My Ferrari to Work for Accolite","Aman Singh Thakur",100,"This book describes my adventures in Accolite"));
		
		return dao.getBookById(bookID);
	}
	
	@RequestMapping(value="/books",method = RequestMethod.POST,consumes="application/json")
	public Book create(@RequestBody Book bookToCreate) {
		return dao.create(bookToCreate);
	}
	
	@RequestMapping(value="/checkoutBook",method = RequestMethod.POST,consumes="application/json")
	public String create(@RequestBody Checkout checkout) {
		System.out.println(checkout.getId()+" "+checkout.getBookName());
		return dao.checkoutBook(checkout);
		//return "YES";
	}
}
