package com.interfaces.miniproject.ecommercedomain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckoutTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IPaymentGateway[] gateways = { new CreditCard(), new UPI(), new NetBanking() };

        while (true) {
            System.out.println("\nChoose Payment Method:");
            System.out.println("1) Credit Card");
            System.out.println("2) UPI");
            System.out.println("3) Net Banking");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Numbers only, please.");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) break;
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            IPaymentGateway pg = gateways[choice - 1];
            System.out.println("Gateway: " + pg.getClass().getSimpleName());

            try {
                System.out.print("Enter amount to pay   : Rs");
                double payAmt = scanner.nextDouble();
                if (payAmt <= 0)
                    throw new IllegalArgumentException("Amount must be positive.");

                pg.pay(payAmt);
                System.out.println("Payment successful!");

                while (true) {
                    System.out.print("Refund this transaction? (yes/no): ");
                    String ans = scanner.next().trim().toLowerCase();
                    if (ans.equals("yes") || ans.equals("y")) {
                        pg.refund(payAmt);
                        break;
                    } else if (ans.equals("no") || ans.equals("n")) {
                        System.out.println("Refund skipped.");
                        break;
                    } else {
                        System.out.println("Please type yes or no.");
                    }
                }

            } catch (InputMismatchException ex) {
                System.out.println("Numbers only, please.");
                scanner.nextLine();
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.println("---------------------------");
        }

        System.out.println("All transactions complete.");
        scanner.close();
    }
}
