package com.fooddelivery.payments;

import java.util.*;

import com.fooddelivery.DeliveryPartners.DeliveryAgentManager;
import com.fooddelivery.DeliveryPartners.IDeliveryAgent;
import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.customer.CustomerInformation;

public class PaymentInterface {

	List<IDeliveryAgent> deliveryAgents = new ArrayList<>();

	public PaymentInterface() {

	}

	public void paymentInterface(double total, CustomerInformation customer, Map<FoodItem, Integer> cartItems, double discountedValue) {
		Scanner scanner = new Scanner(System.in);
		String deliveryAgent = DeliveryAgentManager.getRandomAgent();
		int choice = -1;

		while (true) {
		    try {
		        System.out.println("Choose the method of payment:");
		        System.out.println("1. UPI");
		        System.out.println("2. Debit Card");
		        System.out.print("Enter choice (1 or 2): ");

		        if (!scanner.hasNextInt()) {
		            throw new InputMismatchException("❌ Input must be a number.");
		        }

		        choice = scanner.nextInt();
		        scanner.nextLine(); // consume newline

		        if (choice != 1 && choice != 2) {
		            throw new IllegalArgumentException("❌ Invalid choice. Please select 1 or 2.");
		        }

		        break; // Exit loop on valid input
		    } catch (InputMismatchException | IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		        scanner.nextLine(); // Clear input buffer
		    }
		}

		IPayments paymentType;

		if (choice == 1) {
		    paymentType = new UPI();
		} else {
		    paymentType = new DebitCard();
		}

		paymentType.payment(total, customer, cartItems,deliveryAgent, discountedValue);

	}

}