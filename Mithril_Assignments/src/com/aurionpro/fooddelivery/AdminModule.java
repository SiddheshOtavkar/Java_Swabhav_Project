package com.aurionpro.fooddelivery;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminModule {
	Scanner sc = new Scanner(System.in);

	public void adminMenu() {
		while (true) {
			System.out.println("\n=== Admin Menu ===");
			System.out.println("1. View Menu");
			System.out.println("2. Add Item");
			System.out.println("3. Update Item");
			System.out.println("4. Delete Item");
			System.out.println("5. Exit Admin");
			System.out.print("Choose: ");

			int choice;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number (1-5).");
				sc.nextLine(); // Clear invalid input
				continue;
			}

			switch (choice) {
			case 1:
				viewMenu();
				break;
			case 2:
				addItem();
				break;
			case 3:
				updateItem();
				break;
			case 4:
				deleteItem();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice! Choose between 1-5.");
			}
		}
	}

	private void viewMenu() {
		try (Connection con = DatabaseConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM menu_items")) {
			System.out.println("\n--- Menu ---");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " - ₹" + rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addItem() {
		try {
			System.out.print("Enter item name: ");
			sc.nextLine(); // clear buffer
			String name = sc.nextLine();
			System.out.print("Enter price: ");
			double price = sc.nextDouble();

			try (Connection con = DatabaseConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("INSERT INTO menu_items(name, price) VALUES (?, ?)")) {
				ps.setString(1, name);
				ps.setDouble(2, price);
				ps.executeUpdate();
				System.out.println("Item added!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Price must be a number.");
			sc.nextLine(); // clear buffer
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateItem() {
		viewMenu();
		try {
			System.out.print("Enter item ID to update: ");
			int id = sc.nextInt();
			sc.nextLine(); // clear buffer
			System.out.print("Enter new name: ");
			String name = sc.nextLine();
			System.out.print("Enter new price: ");
			double price = sc.nextDouble();

			try (Connection con = DatabaseConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("UPDATE menu_items SET name=?, price=? WHERE id=?")) {
				ps.setString(1, name);
				ps.setDouble(2, price);
				ps.setInt(3, id);
				int rows = ps.executeUpdate();
				if (rows > 0)
					System.out.println("Item updated!");
				else
					System.out.println("Item ID not found.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! ID and price must be numbers.");
			sc.nextLine(); // clear buffer
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteItem() {
		viewMenu();
		try {
			System.out.print("Enter item ID to delete: ");
			int id = sc.nextInt();

			try (Connection con = DatabaseConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("DELETE FROM menu_items WHERE id=?")) {
				ps.setInt(1, id);
				int rows = ps.executeUpdate();
				if (rows > 0)
					System.out.println("Item deleted!");
				else
					System.out.println("Item ID not found.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! ID must be a number.");
			sc.nextLine(); // clear buffer
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
