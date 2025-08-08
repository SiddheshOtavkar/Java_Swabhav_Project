package com.aurionpro.fooddelivery;

import java.sql.*;
import java.util.*;

public class CustomerModule {
	Scanner sc = new Scanner(System.in);
	Map<String, Integer> orderItems = new LinkedHashMap<>();
	double total = 0;

	public void placeOrder() {
		if (!viewMenu()) {
			System.out.println("No items available to order. Returning to main menu.");
			return;
		}

		while (true) {
			System.out.print("Enter item ID to order (0 to finish): ");
			int id;
			try {
				id = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number.");
				sc.nextLine();
				continue;
			}

			if (id == 0)
				break;

			System.out.print("Quantity: ");
			int qty;
			try {
				qty = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid quantity! Try again.");
				sc.nextLine();
				continue;
			}

			boolean itemFound = false;
			try (Connection con = DatabaseConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT * FROM menu_items WHERE id=?")) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String name = rs.getString("name");
					double price = rs.getDouble("price");
					orderItems.put(name, orderItems.getOrDefault(name, 0) + qty);
					total += price * qty;
					itemFound = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (!itemFound) {
				System.out.println("Item not found!");
				System.out.print("Do you want to try again? (y/n): ");
				sc.nextLine(); // Clear buffer
				String choice = sc.nextLine();
				if (!choice.equalsIgnoreCase("y")) {
					break;
				}
			}
		}

		if (orderItems.isEmpty()) {
			System.out.println("No items ordered. Returning to main menu.");
			return;
		}

		double discount = (total > 500) ? 50 : 0;
		total -= discount;

		int payOption = 0;
		while (true) {
			System.out.print("Choose payment method (1. Cash 2. UPI): ");
			try {
				payOption = sc.nextInt();
				if (payOption == 1 || payOption == 2)
					break;
				else
					System.out.println("Invalid choice! Choose 1 or 2.");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter 1 or 2.");
				sc.nextLine();
			}
		}

		String paymentMode = (payOption == 1) ? "Cash" : "UPI";
		String deliveryPartner = assignDeliveryPartner();
		saveOrder(paymentMode, discount, deliveryPartner);
		printInvoice(paymentMode, discount, deliveryPartner);
	}

	private boolean viewMenu() {
		boolean hasItems = false;
		try (Connection con = DatabaseConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM menu_items")) {
			System.out.println("\n--- Menu ---");
			while (rs.next()) {
				hasItems = true;
				System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " - ₹" + rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hasItems;
	}

	private String assignDeliveryPartner() {
		List<String> partners = new ArrayList<>();
		try (Connection con = DatabaseConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT name FROM delivery_partners")) {
			while (rs.next()) {
				partners.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Random rand = new Random();
		return partners.get(rand.nextInt(partners.size()));
	}

	private void saveOrder(String paymentMode, double discount, String deliveryPartner) {
		StringBuilder itemsStr = new StringBuilder();
		for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
			itemsStr.append(entry.getKey()).append(" x").append(entry.getValue()).append(", ");
		}

		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO orders(items, total, discount, payment_mode, delivery_partner) VALUES (?, ?, ?, ?, ?)")) {
			ps.setString(1, itemsStr.toString());
			ps.setDouble(2, total);
			ps.setDouble(3, discount);
			ps.setString(4, paymentMode);
			ps.setString(5, deliveryPartner);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void printInvoice(String paymentMode, double discount, String deliveryPartner) {
		System.out.println("\n===== Invoice =====");
		for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
			System.out.println(entry.getKey() + " x" + entry.getValue());
		}
		System.out.println("Discount: ₹" + discount);
		System.out.println("Total: ₹" + total);
		System.out.println("Payment Mode: " + paymentMode);
		System.out.println("Delivery Partner: " + deliveryPartner);
		System.out.println("=====================");
	}
}
