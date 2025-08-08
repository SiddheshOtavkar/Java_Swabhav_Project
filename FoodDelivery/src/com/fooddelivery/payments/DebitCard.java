package com.fooddelivery.payments;

import java.util.Map;
import java.util.Scanner;

import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.customer.CustomerInformation;
import com.fooddelivery.exceptions.InvalidCardException;
import com.fooddelivery.invoice.Invoice;

public class DebitCard implements IPayments {

	private String cardNumber;
	private int cvv;
	private String expiryDate;
	private String cardHolderName;

	public DebitCard() {
		Scanner scanner = new Scanner(System.in);

		try {
			// Card Number (16 digits)
			System.out.print("Enter 16-digit Debit Card Number: ");
			cardNumber = scanner.nextLine().trim();
			if (!cardNumber.matches("\\d{16}")) {
				throw new InvalidCardException("❌ Invalid card number. Must be exactly 16 digits.");
			}

			// CVV (3 digits)
			System.out.print("Enter 3-digit CVV: ");
			String cvvInput = scanner.nextLine().trim();
			if (!cvvInput.matches("\\d{3}")) {
				throw new InvalidCardException("❌ Invalid CVV. Must be exactly 3 digits.");
			}
			cvv = Integer.parseInt(cvvInput);

			// Expiry Date (MM/YY)
			System.out.print("Enter expiry date (MM/YY): ");
			expiryDate = scanner.nextLine().trim();
			if (!expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
				throw new InvalidCardException("❌ Invalid expiry format. Use MM/YY.");
			}

			// Cardholder Name
			System.out.print("Enter Cardholder Name: ");
			cardHolderName = scanner.nextLine().trim();
			if (cardHolderName.isEmpty()) {
				throw new InvalidCardException("❌ Cardholder name cannot be empty.");
			}

		} catch (InvalidCardException e) {
			System.out.println(e.getMessage());
			System.out.println("❌ Payment initialization failed.");
		} catch (Exception e) {
			System.out.println("❌ Unexpected error occurred during card input.");
		}
	}

	@Override
	public void payment(double amount, CustomerInformation customer, Map<FoodItem, Integer> cartItems,
			String deliveryAgent, double discountedValue) {
		if (cardNumber == null || cardNumber.isEmpty()) {
			System.out.println("❌ Cannot process payment due to invalid card data.");
			return;
		}

		System.out.println(
				"\n💳 Payment of ₹" + amount + " completed using Debit Card ending with " + cardNumber.substring(12));
		System.out.println("✅ Order placed successfully!");
		System.out.println("📄 Generating invoice...\n");

		Invoice.printInvoice(customer, cartItems, amount, deliveryAgent, discountedValue);
	}

}