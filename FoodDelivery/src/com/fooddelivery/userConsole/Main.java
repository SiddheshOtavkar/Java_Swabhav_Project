package com.fooddelivery.userConsole;

import java.util.Scanner;

import com.fooddelivery.admin.AdminInterface;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("==================================");
		System.out.println("🍽️  Welcome to the Food Delivery App");
		System.out.println("==================================");

		while (true) {
			try {
				System.out.println("\nPlease select your role:");
				System.out.println("1️  Admin");
				System.out.println("2️  User");
				System.out.println("3️  Exit");
				System.out.print("👉 Enter your choice (1-3): ");

				int choice = Integer.parseInt(sc.nextLine().trim());

				if (choice == 1) {

					System.out.println("\n🔐 Redirecting to Admin Panel...");
					AdminInterface.start();
				} else if (choice == 2) {
					System.out.println("\n👤 Redirecting to User Console...");
					UserInterface.start();
				} else if (choice == 3) {
					System.out.println("\n👋 Thank you for using the Food Delivery App. Goodbye!");
					break;
				} else {
					System.out.println("❌ Invalid choice. Please enter 1, 2, or 3.");
				}

			} catch (NumberFormatException e) {
				System.out.println("⚠️  Invalid input. Please enter a valid number.");
			} catch (Exception e) {
				System.out.println("❗ Unexpected error: " + e.getMessage());
			}
		}

		sc.close();

	}
}
