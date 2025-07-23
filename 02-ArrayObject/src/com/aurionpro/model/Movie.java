package com.aurionpro.model;

public class Movie {
	public String title;
	public String genre;

	public Movie(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}

	public void display() {
		System.out.println("Title: " + title + ", Genre: " + genre);
	}
}