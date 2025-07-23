package com.aurionpro.model;

public class Book {
	private String title;
	private String author;
	private boolean issued;

	public Book() {
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isIssued() {
		return issued;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	public String getStatus() {
		return issued ? "Issued" : "Available";
	}

	public String toString() {
		return "Title  : " + title + "\nAuthor : " + author + "\nStatus : " + getStatus();
	}
}
