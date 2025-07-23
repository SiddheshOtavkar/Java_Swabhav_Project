package com.aurionpro.assignment.Movie;

public class MovieModel {
	String title;
	int year;
	
	public MovieModel(String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return " [title=" + title + ", year=" + year + "]";
	}
	
}
