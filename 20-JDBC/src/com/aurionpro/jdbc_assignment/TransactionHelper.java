package com.aurionpro.jdbc_assignment;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TransactionHelper {

	public static void logTransaction(Connection con, int accountId, String type, double amount) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO transactions (account_id, type, amount, timestamp) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");
		stmt.setInt(1, accountId);
		stmt.setString(2, type);
		stmt.setDouble(3, amount);
		stmt.executeUpdate();
	}

	public static void transferMoney(Connection con, Scanner sc) throws SQLException {
		System.out.print("Enter Sender Account ID: ");
		int senderId = sc.nextInt();
		System.out.print("Enter Receiver Account ID: ");
		int receiverId = sc.nextInt();

		if (!DatabaseUtil.isAccountExists(con, senderId) || !DatabaseUtil.isAccountExists(con, receiverId)) {
			System.out.println("Sender or Receiver account not found.");
			return;
		}

		if (senderId == receiverId) {
			System.out.println("Sender and receiver cannot be the same.");
			return;
		}

		double senderBalance = DatabaseUtil.getBalance(con, senderId);
		System.out.print("Enter Amount to Transfer: ₹");
		double amount = sc.nextDouble();

		if (amount <= 0 || senderBalance < amount) {
			System.out.printf("❗ Invalid amount. Available balance: ₹%.2f\n", senderBalance);
			return;
		}

		con.setAutoCommit(false);

		PreparedStatement withdraw = con.prepareStatement("UPDATE account SET balance = balance - ? WHERE id = ?");
		withdraw.setDouble(1, amount);
		withdraw.setInt(2, senderId);
		withdraw.executeUpdate();

		PreparedStatement deposit = con.prepareStatement("UPDATE account SET balance = balance + ? WHERE id = ?");
		deposit.setDouble(1, amount);
		deposit.setInt(2, receiverId);
		deposit.executeUpdate();

		logTransaction(con, senderId, "TRANSFER_OUT", amount);
		logTransaction(con, receiverId, "TRANSFER_IN", amount);

		con.commit();
		con.setAutoCommit(true);
		System.out.printf("₹%.2f transferred from Account %d to Account %d.\n", amount, senderId, receiverId);
	}

	public static void viewTransactions(Connection con, Scanner sc) throws SQLException {
		System.out.print("Enter your Account ID to view transactions: ");
		int id = sc.nextInt();

		if (!DatabaseUtil.isAccountExists(con, id)) {
			System.out.println("Account not found or terminated.");
			return;
		}

		PreparedStatement stmt = con
				.prepareStatement("SELECT * FROM transactions WHERE account_id = ? ORDER BY timestamp DESC");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		System.out.println("\n📄 Transaction History:");

		SimpleDateFormat formatter = new SimpleDateFormat("d'%s' MMMM yyyy, h:mm a");

		while (rs.next()) {
			Timestamp timestamp = rs.getTimestamp("timestamp");
			LocalDateTime dateTime = timestamp.toLocalDateTime();
			int day = dateTime.getDayOfMonth();
			String suffix = getDaySuffix(day);

			String formattedDate = new SimpleDateFormat("d'" + suffix + "' MMMM yyyy, h:mm a").format(timestamp);

			String type = rs.getString("type");
			double amount = rs.getDouble("amount");

			System.out.printf("  • [%s] %s of ₹%.2f\n", formattedDate, type, amount);
		}
	}
	
	private static String getDaySuffix(int day) {
		if (day >= 11 && day <= 13) {
			return "th";
		}
		switch (day % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}

}
