package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Movie;

public class MovieTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of movies: ");
		int size = scanner.nextInt();
		scanner.nextLine();
		
		Movie[] movies = new Movie[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the title of movie: ");
			String title = scanner.nextLine();
			
			System.out.print("Enter the genre of movie: ");
			String genre = scanner.nextLine();
			
			movies[i] = new Movie(title, genre);
		}
		
		System.out.print("Enter genre to search: ");
		String searchGenre = scanner.nextLine();
		
		System.out.println("\nMovies of genre: " + searchGenre);
		boolean found = false;
		for(Movie movie : movies) {
			if(movie.genre.equalsIgnoreCase(searchGenre)) {
				movie.display();
				found = true;
			}
		}
		
		if(found == false) {
			System.out.println("No movies found for this genre.");
		}
		
		scanner.close();
	}
}
