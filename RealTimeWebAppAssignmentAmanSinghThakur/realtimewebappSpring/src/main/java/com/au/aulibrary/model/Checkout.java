package com.au.aulibrary.model;

public class Checkout {
	
	String id, bookName;
	
	public Checkout() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Checkout(String id, String bookName) {
		super();
		this.id = id;
		this.bookName = bookName;
	}

}
