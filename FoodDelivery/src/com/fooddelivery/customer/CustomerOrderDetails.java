package com.fooddelivery.customer;

import java.util.Scanner;

public class CustomerOrderDetails {

	public static CustomerInformation getCustomerDetailsFromUser() {
		Scanner scanner = new Scanner(System.in);

		// Get name
		String name;
		while (true) {
			System.out.print("Enter your name: ");
			name = scanner.nextLine().trim();
			if (!name.isEmpty())
				break;
			System.out.println("❌ Name cannot be empty.");
		}

		// Get phone number
		double phoneNumber = 0;
		while (true) {
			System.out.print("Enter your 10-digit phone number: ");
			String input = scanner.nextLine().trim();
			if (input.matches("\\d{10}")) {
				phoneNumber = Double.parseDouble(input);
				break;
			} else {
				System.out.println("❌ Invalid phone number. Please enter exactly 10 digits.");
			}
		}

		// Get address
		String address;
		while (true) {
			System.out.print("Enter your address: ");
			address = scanner.nextLine().trim();
			if (!address.isEmpty())
				break;
			System.out.println("❌ Address cannot be empty.");
		}

		// Create and return CustomerInformation object
		CustomerInformation customer = new CustomerInformation(name, phoneNumber, address);
		System.out.println("✅ Customer created: " + customer);
		return customer;
	}

}
