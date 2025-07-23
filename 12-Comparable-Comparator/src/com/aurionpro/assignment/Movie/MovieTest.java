package com.aurionpro.assignment.Movie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<MovieModel> movies = new ArrayList<MovieModel>();

//		movies.add(new MovieModel("Dune", 2021));
//		movies.add(new MovieModel("No Time to Die", 2021));
//		movies.add(new MovieModel("Parasite", 2019));
//		movies.add(new MovieModel("Avengers: Endgame", 2019));
//		movies.add(new MovieModel("Inception", 2010));

		/* how many movies? */
		int n;
		while (true) {
			try {
				System.out.print("How many movies do you want to enter? ");
				n = scanner.nextInt();
				scanner.nextLine(); // flush newline
				if (n <= 0) {
					System.out.println("Enter a positive number.");
					continue;
				}
				break;
			} catch (InputMismatchException ex) {
				System.out.println("Numbers only, please.");
				scanner.nextLine();
			}
		}

		/* read each movie */
		for (int i = 1; i <= n; i++) {

			/* title */
			String title;
			while (true) {
				try {
					System.out.print("Enter the title of the movie: ");
					title = scanner.nextLine().trim();

					if (title.isEmpty()) {
						throw new IllegalArgumentException("Title cannot be empty.");
					}

					if (!title.matches(".*[A-Za-z].*")) {
						throw new IllegalArgumentException("Title must contain at least one letter.");
					}

					break;

				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input: " + e.getMessage());
				}
			}

			/* year */
			int year;
			while (true) {
				try {
					System.out.print("Enter year for \"" + title + "\": ");
					year = scanner.nextInt();
					scanner.nextLine(); // flush newline
					
					int currentYear = Calendar.getInstance().get(Calendar.YEAR);

					if (year < 1888 || year > currentYear) { // 1888 = first film
						System.out.println("Enter a realistic year (1888" + currentYear + ").");
					} else {
						break;
					}
				} catch (InputMismatchException ex) {
					System.out.println("Year must be a number.");
					scanner.nextLine();
				}
			}

			movies.add(new MovieModel(title, year));
		}

		// Sort by Year Descending first
		Collections.sort(movies, new MovieYearDescComparator());
		System.out.println("Sorted by Year (Descending):");
		for (MovieModel m : movies) {
			System.out.println(m);
		}

		// If same year, sort by Title Ascending
		Collections.sort(movies, new MovieTitleAscComparator());
		System.out.println("\nSorted by Year Desc + Title Asc:");
		for (MovieModel m : movies) {
			System.out.println(m);
		}

		scanner.close();
	}
}
