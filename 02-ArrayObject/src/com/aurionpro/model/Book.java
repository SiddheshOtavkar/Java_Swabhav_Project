package com.aurionpro.model;

public class Book {
	int bookId;
	String title;

	public Book(int bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}

	public void displayTitle() {
		System.out.println("Title of the book is: " + title);
	}
	
	public void displayId() {
		System.out.println("Id of the book is: " + bookId);
	}
}
