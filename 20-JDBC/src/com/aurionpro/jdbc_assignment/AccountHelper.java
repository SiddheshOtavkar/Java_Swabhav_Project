package com.aurionpro.jdbc_assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountHelper {

	public static void createAccount(Connection con, Scanner sc) throws SQLException {
	    sc.nextLine();  // Consume leftover newline
	    System.out.print("Enter Name: ");
	    String name = sc.nextLine();
	    double balance;

	    while (true) {
	        System.out.print("Enter Initial Deposit: ₹");
	        if (sc.hasNextDouble()) {
	            balance = sc.nextDouble();
	            if (balance <= 0) {
	                System.out.println("❗ Initial deposit must be positive.");
	            } else break;
	        } else {
	            System.out.print("❗ Invalid input. Enter a valid amount: ");
	            sc.next();
	        }
	    }

	    PreparedStatement stmt = con.prepareStatement(
	        "INSERT INTO account (name, balance) VALUES (?, ?)", 
	        PreparedStatement.RETURN_GENERATED_KEYS
	    );
	    stmt.setString(1, name);
	    stmt.setDouble(2, balance);
	    stmt.executeUpdate();

	    ResultSet rs = stmt.getGeneratedKeys();
	    if (rs.next()) {
	        int generatedId = rs.getInt(1);
	        System.out.println("Account created successfully! Your Account ID is: " + generatedId);
	    } else {
	        System.out.println("Account creation failed. Please try again.");
	    }
	}

	
    public static void deleteAccount(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account ID to terminate: ");
        int id = sc.nextInt();

        if (!DatabaseUtil.isAccountExists(con, id)) {
            System.out.println("Account not found or already terminated.");
            return;
        }

        PreparedStatement deactivateAccount = con.prepareStatement(
            "UPDATE account SET is_active = FALSE WHERE id = ?"
        );
        deactivateAccount.setInt(1, id);
        deactivateAccount.executeUpdate();

        System.out.println("Account terminated successfully.");
    }

    public static void deposit(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!DatabaseUtil.isAccountExists(con, id)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Amount to Deposit: ₹");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("❗ Deposit amount must be positive.");
            return;
        }

        PreparedStatement stmt = con.prepareStatement("UPDATE account SET balance = balance + ? WHERE id = ?");
        stmt.setDouble(1, amount);
        stmt.setInt(2, id);
        stmt.executeUpdate();

        TransactionHelper.logTransaction(con, id, "DEPOSIT", amount);
        System.out.println("Amount deposited successfully.");
    }

    public static void withdraw(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!DatabaseUtil.isAccountExists(con, id)) {
            System.out.println("Account not found.");
            return;
        }

        double balance = DatabaseUtil.getBalance(con, id);
        System.out.print("Enter Amount to Withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0 || amount > balance) {
            System.out.printf("❗ Invalid amount. Available balance: ₹%.2f\n", balance);
            return;
        }

        PreparedStatement stmt = con.prepareStatement("UPDATE account SET balance = balance - ? WHERE id = ?");
        stmt.setDouble(1, amount);
        stmt.setInt(2, id);
        stmt.executeUpdate();

        TransactionHelper.logTransaction(con, id, "WITHDRAW", amount);
        System.out.println("Amount withdrawn successfully.");
    }

    public static void checkBalance(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account ID to check balance: ");
        int id = sc.nextInt();

        if (!DatabaseUtil.isAccountExists(con, id)) {
            System.out.println("Account not found.");
            return;
        }

        double balance = DatabaseUtil.getBalance(con, id);
        System.out.printf("Account ID: %d → Balance: ₹%.2f\n", id, balance);
    }
}