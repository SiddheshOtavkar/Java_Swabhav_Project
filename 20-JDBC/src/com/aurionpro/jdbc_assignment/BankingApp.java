package com.aurionpro.jdbc_assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🏦 Welcome to JDBC Bank");

        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Account Balance");
            System.out.println("6. Delete Account");
            System.out.println("7. View My Transactions");
            System.out.println("8. Exit");

            int choice = 0;

            try {
                System.out.print("Choose an option (1-8): ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 8) {
                    System.out.println("❗ Invalid choice. Please enter a number between 1 and 8.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("❗ Invalid input. Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            try (Connection con = DatabaseUtil.getConnection()) {
                switch (choice) {
                    case 1 -> AccountHelper.createAccount(con, sc);
                    case 2 -> AccountHelper.deposit(con, sc);
                    case 3 -> AccountHelper.withdraw(con, sc);
                    case 4 -> TransactionHelper.transferMoney(con, sc);
                    case 5 -> AccountHelper.checkBalance(con, sc);
                    case 6 -> AccountHelper.deleteAccount(con, sc);
                    case 7 -> TransactionHelper.viewTransactions(con, sc);
                    case 8 -> {
                        System.out.println("👋 Thank you for using JDBC Bank. Goodbye!");
                        sc.close();
                        return;
                    }
                }
            } catch (SQLException e) {
                System.out.println("❗ Database error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❗ Unexpected error: " + e.getMessage());
            }
        }
    }
}
