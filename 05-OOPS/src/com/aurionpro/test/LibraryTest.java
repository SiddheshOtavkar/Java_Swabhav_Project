package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.model.Book;

public class LibraryTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of books: ");
		int count = scanner.nextInt();
		scanner.nextLine();

		Book[] books = new Book[count];

		for (int i = 0; i < count; i++) {
			System.out.println("\nEnter details for Book " + (i + 1) + ":");

			System.out.print("Title: ");
			String title = scanner.nextLine();

			System.out.print("Author: ");
			String author = scanner.nextLine();

			books[i] = new Book();
			books[i].setTitle(title);
			books[i].setAuthor(author);
		}

		System.out.println("\n--- Initial Book Status ---");
		for (Book book : books) {
			System.out.println(book);
			System.out.println();
		}

		for (int i = 0; i < count; i++) {
			System.out.print("Is Book " + (i + 1) + " issued? (yes/no): ");
			String response = scanner.next();
			books[i].setIssued(response.equalsIgnoreCase("yes"));
		}

		System.out.println("\n--- Updated Book Status ---");
		for (Book book : books) {
			System.out.println(book);
			System.out.println();
		}

		scanner.close();
	}
}
