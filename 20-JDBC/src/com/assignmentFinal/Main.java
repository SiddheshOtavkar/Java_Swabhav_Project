package com.assignmentFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/bank_app";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    public static void main(String[] args) {
        Connection con = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            con.setAutoCommit(false);

            while (true) {
                String loginResult = Auth.loginUser(con, sc);
                if (loginResult == null) {
                    System.out.println("Login failed. Try again.\n");
                    continue;
                }

                String[] parts = loginResult.split(":");
                String uname = parts[0];
                String role = parts[1];

                if (role.equalsIgnoreCase("ADMIN"))
                    BankOperations.adminMenu(con, sc);
                else
                    BankOperations.customerMenu(con, sc, uname);

                sc.nextLine(); // clear buffer
                System.out.print("Do you want to log in again? (yes/no): ");
                String again = sc.nextLine().trim();
                if (!again.equalsIgnoreCase("yes"))
                    break;
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
