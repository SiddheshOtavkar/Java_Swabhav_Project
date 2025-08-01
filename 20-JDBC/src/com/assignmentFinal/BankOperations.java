package com.assignmentFinal;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.security.SecureRandom;

public class BankOperations {

	public static void adminMenu(Connection con, Scanner sc) throws Exception {
		while (true) {
			System.out.println("\n--- Admin Menu ---");
			System.out.println("1. Add New User");
			System.out.println("2. Delete User");
			System.out.println("3. View All Accounts");
			System.out.println("4. View All Transactions");
			System.out.println("5. View User Transactions");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			String choice = sc.next();
			switch (choice) {
			case "1" -> addNewUser(con, sc);
			case "2" -> deleteUser(con, sc);
			case "3" -> viewAllAccounts(con);
			case "4" -> viewAllTransactions(con);
			case "5" -> viewUserTransactions(con, sc);
			case "6" -> {
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	public static void customerMenu(Connection con, Scanner sc, String username) throws SQLException {
		while (true) {
			System.out.println("\n--- Customer Menu ---");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Transfer Money");
			System.out.println("5. View Transaction History");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			String choice = sc.next();

			switch (choice) {
			case "1" -> checkBalance(con, username);
			case "2" -> deposit(con, sc, username);
			case "3" -> withdraw(con, sc, username);
			case "4" -> transferMoney(con, sc, username);
			case "5" -> viewStatement(con, username);
			case "6" -> {
				System.out.println("✅ Logout successful.");
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	// ------------------ Admin Functionalities ------------------

	private static void addNewUser(Connection con, Scanner sc) throws Exception {
		sc.nextLine();
		System.out.print("Enter username: ");
		String username = sc.nextLine().trim();

		System.out.print("Set PIN: ");
		String pin = sc.nextLine().trim();

		System.out.print("Role (ADMIN/CUSTOMER): ");
		String role = sc.nextLine().trim().toUpperCase();

		if (!role.equals("ADMIN") && !role.equals("CUSTOMER")) {
			System.out.println("Invalid role.");
			return;
		}

		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);
		String hashed = Auth.hashPin(pin, salt);

		PreparedStatement ps = con
				.prepareStatement("INSERT INTO users(username, password_hash, salt, role) VALUES (?, ?, ?, ?)");
		ps.setString(1, username);
		ps.setString(2, hashed);
		ps.setBytes(3, salt);
		ps.setString(4, role);
		ps.executeUpdate();
		ps.close();

		if (role.equals("CUSTOMER")) {
			PreparedStatement ps2 = con.prepareStatement("INSERT INTO accounts(name, balance) VALUES (?, 0)");
			ps2.setString(1, username);
			ps2.executeUpdate();
			ps2.close();
		}

		con.commit();
		System.out.println("✅ User added successfully.");
	}

	private static void deleteUser(Connection con, Scanner sc) throws SQLException {
		sc.nextLine();
		System.out.print("Enter username to delete: ");
		String user = sc.nextLine().trim();

		int accId = getAccountId(con, user);
		PreparedStatement deleteTx = con.prepareStatement("DELETE FROM transaction WHERE account_id = ?");
		deleteTx.setInt(1, accId);
		deleteTx.executeUpdate();

		PreparedStatement deleteAcc = con.prepareStatement("DELETE FROM accounts WHERE name = ?");
		deleteAcc.setString(1, user);
		deleteAcc.executeUpdate();

		PreparedStatement deleteUser = con.prepareStatement("DELETE FROM users WHERE username = ?");
		deleteUser.setString(1, user);
		deleteUser.executeUpdate();

		con.commit();
		System.out.println("🗑️ User and all related data deleted.");
	}

	private static void viewUserTransactions(Connection con, Scanner sc) throws SQLException {
		sc.nextLine();
		System.out.print("Enter username to view transactions: ");
		String user = sc.nextLine().trim();
		int accId = getAccountId(con, user);
		if (accId == -1) {
			System.out.println("❌ Account not found.");
			return;
		}

		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM transaction WHERE account_id = ? ORDER BY timestamp DESC");
		ps.setInt(1, accId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.printf("TxnID: %d | Type: %s | ₹%.2f | On: %s\n", rs.getInt("id"), rs.getString("type"),
					rs.getDouble("amount"), rs.getTimestamp("timestamp"));
		}
		ps.close();
	}

	private static void viewAllAccounts(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM accounts");
		ResultSet rs = ps.executeQuery();
		System.out.println("ID | Name | Balance");
		while (rs.next()) {
			System.out.printf("%d | %s | ₹%.2f\n", rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
		}
		ps.close();
	}

	private static void viewAllTransactions(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM transaction ORDER BY timestamp DESC");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.printf("%d | AccID: %d | %s | ₹%.2f | %s\n", rs.getInt("id"), rs.getInt("account_id"),
					rs.getString("type"), rs.getDouble("amount"), rs.getTimestamp("timestamp"));
		}
		ps.close();
	}

	// ------------------ Customer Functionalities ------------------

	private static void checkBalance(Connection con, String username) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT balance FROM accounts WHERE name = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("Current Balance: ₹" + rs.getDouble(1));
		} else {
			System.out.println("Account not found.");
		}
		ps.close();
	}

	private static void deposit(Connection con, Scanner sc, String username) throws SQLException {
		System.out.print("Enter amount to deposit: ₹");
		double amt = sc.nextDouble();
		PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE name = ?");
		ps.setDouble(1, amt);
		ps.setString(2, username);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			logTransaction(con, getAccountId(con, username), "credit", amt, "Deposit");
			con.commit();
			System.out.println("Amount deposited.");
		} else {
			con.rollback();
			System.out.println("Deposit failed.");
		}
		ps.close();
	}

	private static void withdraw(Connection con, Scanner sc, String username) throws SQLException {
		System.out.print("Enter amount to withdraw: ₹");
		double amt = sc.nextDouble();
		PreparedStatement check = con.prepareStatement("SELECT balance FROM accounts WHERE name = ?");
		check.setString(1, username);
		ResultSet rs = check.executeQuery();
		if (rs.next() && rs.getDouble(1) >= amt) {
			PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE name = ?");
			ps.setDouble(1, amt);
			ps.setString(2, username);
			ps.executeUpdate();
			logTransaction(con, getAccountId(con, username), "debit", amt, "Withdrawal");
			con.commit();
			System.out.println("Amount withdrawn.");
			ps.close();
		} else {
			System.out.println("Insufficient balance.");
			con.rollback();
		}
		check.close();
	}

	private static void viewStatement(Connection con, String username) throws SQLException {
		int id = getAccountId(con, username);
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM transaction WHERE account_id = ? ORDER BY timestamp DESC");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.printf("%d | %s | ₹%.2f | %s\n", rs.getInt("id"), rs.getString("type"), rs.getDouble("amount"),
					rs.getTimestamp("timestamp"));
		}
		ps.close();
	}

	private static void transferMoney(Connection con, Scanner sc, String fromUser) throws SQLException {
		sc.nextLine();
		System.out.print("Enter recipient username: ");
		String toUser = sc.nextLine().trim();

		if (toUser.equalsIgnoreCase(fromUser)) {
			System.out.println("❌ Cannot transfer to your own account.");
			return;
		}

		System.out.print("Enter amount to transfer: ₹");
		double amount;
		try {
			amount = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("❌ Invalid amount.");
			sc.nextLine();
			return;
		}

		int fromId = getAccountId(con, fromUser);
		int toId = getAccountId(con, toUser);
		if (fromId == -1 || toId == -1) {
			System.out.println("❌ Invalid accounts.");
			return;
		}

		PreparedStatement check = con.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
		check.setInt(1, fromId);
		ResultSet rs = check.executeQuery();
		if (rs.next() && rs.getDouble(1) >= amount) {
			PreparedStatement debit = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
			debit.setDouble(1, amount);
			debit.setInt(2, fromId);

			PreparedStatement credit = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
			credit.setDouble(1, amount);
			credit.setInt(2, toId);

			debit.executeUpdate();
			credit.executeUpdate();

			logTransaction(con, fromId, "transfer", amount, "Sent to " + toUser);
			logTransaction(con, toId, "credit", amount, "Received from " + fromUser);
			con.commit();
			System.out.println("✅ Transfer successful.");
			debit.close();
			credit.close();
		} else {
			con.rollback();
			System.out.println("❌ Insufficient funds.");
		}
		check.close();
	}

	private static int getAccountId(Connection con, String name) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT id FROM accounts WHERE name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getInt(1);
		return -1;
	}

	private static void logTransaction(Connection con, int accId, String type, double amt, String desc)
			throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO transaction(account_id, type, amount, description) VALUES (?,?,?,?)");
		ps.setInt(1, accId);
		ps.setString(2, type);
		ps.setDouble(3, amt);
		ps.setString(4, desc);
		ps.executeUpdate();
		ps.close();
	}
}
