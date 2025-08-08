package com.fooddelivery.payments;

import java.util.Map;
import java.util.Scanner;

import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.customer.CustomerInformation;
import com.fooddelivery.invoice.Invoice;

public class UPI implements IPayments {

	private String upiID;
	private int pin;

	public UPI() {
		Scanner scanner = new Scanner(System.in);

		// UPI ID Validation
		while (true) {
			try {
				System.out.print("Enter the UPI ID: ");
				upiID = scanner.nextLine().trim();

				if (!upiID.matches("^[\\w.-]+@[\\w.-]+$")) {
					throw new IllegalArgumentException("❌ Invalid UPI ID format.");
				}
				break;

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		// PIN Input
		while (true) {
			try {
				System.out.print("Enter 4-digit UPI PIN: ");
				String pinInput = scanner.nextLine().trim();

				if (!pinInput.matches("\\d{4}")) {
					throw new IllegalArgumentException("❌ Invalid PIN. Must be a 4-digit number.");
				}

				pin = Integer.parseInt(pinInput);
				break;

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void payment(double amount, CustomerInformation customer, Map<FoodItem, Integer> cartItems,
			String deliveryAgent, double discountedValue) {
		Scanner scanner = new Scanner(System.in);
		final int CORRECT_PIN = 1234;

		try {
			// Simulate PIN validation
			if (pin != CORRECT_PIN) {
				throw new SecurityException("❌ Incorrect PIN. Payment failed.");
			}

			System.out.print("Confirm payment of ₹" + amount + "? (yes/no): ");
			String confirmation = scanner.nextLine().trim();

			if (!confirmation.equalsIgnoreCase("yes")) {
				throw new RuntimeException("❌ Payment cancelled by user.");
			}

			// Payment success
			System.out.println("\n✅ Payment successful via UPI: " + upiID);
			System.out.println("📄 Generating invoice...\n");
			Invoice.printInvoice(customer, cartItems, amount, deliveryAgent, discountedValue);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}