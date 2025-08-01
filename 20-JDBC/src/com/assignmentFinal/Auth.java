package com.assignmentFinal;

import java.sql.*;
import java.security.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Auth {

    public static String loginUser(Connection con, Scanner sc) {
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
                    return username + ":" + rs.getString("role");
                } else {
                    System.out.println("❌ Incorrect PIN.");
                }
            } else {
                System.out.println("❌ User not found.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error during login: " + e.getMessage());
        }
        return null;
    }

    public static String hashPin(String pin, byte[] salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashed = md.digest(pin.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashed);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
