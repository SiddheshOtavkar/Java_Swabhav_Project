package com.assignmentFinal;

import java.sql.*;
import java.util.*;
import java.security.*;
import java.nio.charset.StandardCharsets;

public class BankTransaction {

	private static final String URL = "jdbc:mysql://localhost:3306/bank_app";
	private static final String USER = "root";
	private static final String PASSWORD = "root123";

	private static Connection con;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			con.setAutoCommit(false);

			while (true) {
				String loginResult = loginUser(con, sc);
				if (loginResult == null) {
					System.out.println("Login failed. Try again.\n");
					continue;
				}

				String[] parts = loginResult.split(":");
				String uname = parts[0];
				String role = parts[1];

				if (role.equalsIgnoreCase("ADMIN"))
					adminMenu();
				else
					customerMenu(uname);
				sc.nextLine(); // clear leftover newline from previous input
				System.out.print("Do you want to log in again? (yes/no): ");
				String again = sc.nextLine().trim();

				if (!again.equalsIgnoreCase("yes"))
					break;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			close();
		}
	}

	public static String loginUser(Connection con, Scanner sc) {
		while (true) {
			System.out.print("Login (username): ");
			String username = sc.nextLine().trim();
			System.out.print("Enter PIN: ");
			String pin = sc.nextLine().trim();

			try {
				String sql = "SELECT password_hash, salt, role FROM users WHERE username = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, username);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					String storedHash = rs.getString("password_hash");
					byte[] salt = rs.getBytes("salt");

					String inputHash = hashPin(pin, salt);
					if (storedHash.equals(inputHash)) {
						System.out.println("✅ Login successful as " + rs.getString("role"));
						return username + ":" + rs.getString("role"); // return both username and role
					} else {
						System.out.println("❌ Incorrect PIN.");
					}
				} else {
					System.out.println("❌ User not found.");
				}
			} catch (Exception e) {
				System.out.println("Error during login: " + e.getMessage());
			}
			return null;
		}
	}

	public static String hashPin(String pin, byte[] salt) throws Exception {
	    MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(salt); // use the correct salt
	    byte[] hashed = md.digest(pin.getBytes(StandardCharsets.UTF_8)); // hash the entered pin
	    return bytesToHex(hashed);
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	private static void adminMenu() throws Exception {
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
			case "1" -> addNewUser();
			case "2" -> deleteUser();
			case "3" -> viewAllAccounts();
			case "4" -> viewAllTransactions();
			case "5" -> viewUserTransactions();
			case "6" -> {
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	private static void addNewUser() throws Exception {
		sc.nextLine(); // flush
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
		String hashed = hashPin(pin, salt);

		PreparedStatement ps = con
				.prepareStatement("INSERT INTO users(username, password_hash, salt, role) VALUES (?, ?, ?, ?)");
		ps.setString(1, username);
		ps.setString(2, hashed);
		ps.setBytes(3, salt);
		ps.setString(4, role);
		ps.executeUpdate();
		ps.close();

		// Also create account with ₹0 balance if CUSTOMER
		if (role.equals("CUSTOMER")) {
			PreparedStatement ps2 = con.prepareStatement("INSERT INTO accounts(name, balance) VALUES (?, 0)");
			ps2.setString(1, username);
			ps2.executeUpdate();
			ps2.close();
		}

		con.commit();
		System.out.println("✅ User added successfully.");
	}

	private static void deleteUser() throws SQLException {
		sc.nextLine();
		System.out.print("Enter username to delete: ");
		String user = sc.nextLine().trim();

		// Get account ID if exists
		int accId = getAccountId(user);

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

	private static void viewUserTransactions() throws SQLException {
		sc.nextLine();
		System.out.print("Enter username to view transactions: ");
		String user = sc.nextLine().trim();
		int accId = getAccountId(user);
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

	private static void customerMenu(String username) throws SQLException {
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
			case "1" -> checkBalance(username);
			case "2" -> deposit(username);
			case "3" -> withdraw(username);
			case "4" -> transferMoney(username);
			case "5" -> viewStatement(username);
			case "6" -> {
				System.out.println("✅ Logout successful.");
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static double getBalanceByUsername(String username) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT balance FROM accounts WHERE name = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getDouble("balance");
		}
		return -1;
	}

	private static void deposit(String username) throws SQLException {
		System.out.print("Enter amount to deposit: ₹");
		double amt = sc.nextDouble();
		PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE name = ?");
		ps.setDouble(1, amt);
		ps.setString(2, username);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			logTransaction(getAccountId(username), "credit", amt, "Deposit");
			con.commit();
			System.out.println("Amount deposited.");
		} else {
			con.rollback();
			System.out.println("Deposit failed.");
		}
		ps.close();
	}

	private static void withdraw(String username) throws SQLException {
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
			logTransaction(getAccountId(username), "debit", amt, "Withdrawal");
			con.commit();
			System.out.println("Amount withdrawn.");
			ps.close();
		} else {
			System.out.println("Insufficient balance.");
			con.rollback();
		}
		check.close();
	}

	private static void checkBalance(String username) throws SQLException {
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

	private static void viewStatement(String username) throws SQLException {
		int id = getAccountId(username);
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

	private static void viewAllAccounts() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM accounts");
		ResultSet rs = ps.executeQuery();
		System.out.println("ID | Name | Balance");
		while (rs.next()) {
			System.out.printf("%d | %s | ₹%.2f\n", rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
		}
		ps.close();
	}

	private static void viewAllTransactions() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM transaction ORDER BY timestamp DESC");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.printf("%d | AccID: %d | %s | ₹%.2f | %s\n", rs.getInt("id"), rs.getInt("account_id"),
					rs.getString("type"), rs.getDouble("amount"), rs.getTimestamp("timestamp"));
		}
		ps.close();
	}

	private static int getAccountId(String name) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT id FROM accounts WHERE name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getInt(1);
		return -1;
	}

	private static void logTransaction(int accId, String type, double amt, String desc) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO transaction(account_id, type, amount, description) VALUES (?,?,?,?)");
		ps.setInt(1, accId);
		ps.setString(2, type);
		ps.setDouble(3, amt);
		ps.setString(4, desc);
		ps.executeUpdate();
		ps.close();
	}

	private static void transferMoney(String fromUser) {
		try {
			// Fetch sender's account details
			PreparedStatement senderStmt = con
					.prepareStatement("SELECT id, balance, status FROM accounts WHERE name = ?");
			senderStmt.setString(1, fromUser);
			ResultSet senderRs = senderStmt.executeQuery();

			if (!senderRs.next()) {
				System.out.println("❌ Sender account not found.");
				return;
			}

			int fromId = senderRs.getInt("id");
			double senderBalance = senderRs.getDouble("balance");
			String senderStatus = senderRs.getString("status");

			if (!"active".equalsIgnoreCase(senderStatus)) {
				System.out.println("❌ Your account is inactive. Cannot transfer.");
				return;
			}

			sc.nextLine(); // clear newline
			System.out.print("Enter recipient username: ");
			String toUser = sc.nextLine().trim();

			if (toUser.equalsIgnoreCase(fromUser)) {
				System.out.println("❌ Cannot transfer to your own account.");
				return;
			}

			// Fetch recipient account
			PreparedStatement receiverStmt = con.prepareStatement("SELECT id, status FROM accounts WHERE name = ?");
			receiverStmt.setString(1, toUser);
			ResultSet receiverRs = receiverStmt.executeQuery();

			if (!receiverRs.next()) {
				System.out.println("❌ Recipient account not found.");
				return;
			}

			int toId = receiverRs.getInt("id");
			String recipientStatus = receiverRs.getString("status");

			if (!"active".equalsIgnoreCase(recipientStatus)) {
				System.out.println("❌ Recipient account is inactive.");
				return;
			}

			System.out.print("Enter amount to transfer: ₹");
			double amount;
			try {
				amount = sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("❌ Invalid amount entered.");
				sc.nextLine(); // clear buffer
				return;
			}

			if (amount <= 0) {
				System.out.println("❌ Amount must be positive.");
				return;
			}

			if (senderBalance < amount) {
				System.out.println("❌ Insufficient funds.");
				return;
			}

			// Start transaction
			con.setAutoCommit(false);

			// Debit sender
			PreparedStatement debitStmt = con
					.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
			debitStmt.setDouble(1, amount);
			debitStmt.setInt(2, fromId);

			// Credit receiver
			PreparedStatement creditStmt = con
					.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
			creditStmt.setDouble(1, amount);
			creditStmt.setInt(2, toId);

			int rows1 = debitStmt.executeUpdate();
			int rows2 = creditStmt.executeUpdate();

			if (rows1 == 1 && rows2 == 1) {
				logTransaction1(fromId, "transfer", amount, "Sent to " + toUser);
				logTransaction1(toId, "credit", amount, "Received from " + fromUser);
				con.commit();
				System.out.println("✅ ₹" + amount + " transferred successfully to " + toUser);
			} else {
				con.rollback();
				System.out.println("❌ Transfer failed.");
			}

			// Close resources
			debitStmt.close();
			creditStmt.close();
			senderStmt.close();
			receiverStmt.close();
			con.setAutoCommit(true);

		} catch (Exception e) {
			rollback("❌ Transfer failed: " + e.getMessage());
		}
	}

	// Transaction logger
	private static void logTransaction1(int accId, String type, double amount, String description) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO transaction (account_id, type, amount, description) VALUES (?, ?, ?, ?)");
		ps.setInt(1, accId);
		ps.setString(2, type);
		ps.setDouble(3, amount);
		ps.setString(4, description);
		ps.executeUpdate();
		ps.close();
	}

	// Rollback helper
	private static void rollback(String message) {
		try {
			con.rollback();
			System.out.println(message);
		} catch (SQLException e) {
			System.out.println("❌ Rollback error: " + e.getMessage());
		}
	}

	private static void updateBalance(int accountId, double amount) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
		ps.setDouble(1, amount);
		ps.setInt(2, accountId);
		ps.executeUpdate();
		ps.close();
	}

	private static void close() {
		try {
			if (con != null)
				con.close();
			if (sc != null)
				sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
