package com.aurionpro.fooddelivery;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodOrderingApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminModule admin = new AdminModule();
		CustomerModule customer = new CustomerModule();

		while (true) {
			System.out.println("\n=== Welcome to Mini Food Ordering App ===");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.print("Choose: ");

			int choice;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number (1-3).");
				sc.nextLine(); // clear buffer
				continue;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter Admin Username: ");
				sc.nextLine(); // consume newline
				String username = sc.nextLine();
				System.out.print("Enter Password: ");
				String password = sc.nextLine();

				if (username.equals("admin") && password.equals("admin123")) {
					System.out.println("\nLogin Successful!");
					admin.adminMenu();
				} else {
					System.out.println("Invalid credentials. Access Denied.");
				}
				break;

			case 2:
				customer.placeOrder();
				break;

			case 3:
				System.out.println("Goodbye!");
				return;

			default:
				System.out.println("Invalid choice! Please choose 1-3.");
			}
		}
	}
}
