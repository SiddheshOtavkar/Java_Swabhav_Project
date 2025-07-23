package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Book;

public class BookTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of books to be entered: ");
		int size = scanner.nextInt();

		Book[] books = new Book[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the title of book " + (i+1) + ": ");
			scanner.nextLine();
			String title = scanner.nextLine();

			System.out.print("Enter the Book ID: ");
			int id = scanner.nextInt();

			books[i] = new Book(id, title);
		}

		System.out.println("-----------------------------------------------");
		for (Book value : books) {
			value.displayTitle();
			value.displayId();
			System.out.println("-------------------------------------------");
		}

		scanner.close();
	}
}
