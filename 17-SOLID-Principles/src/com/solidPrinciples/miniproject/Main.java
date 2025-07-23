package com.solidPrinciples.miniproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /* 1️⃣ PRODUCT TYPE ---------------------------------- */
        int productOpt = 0;
        while (true) {
            try {
                System.out.println("Select product type:");
                System.out.println("  1) ELECTRONICS");
                System.out.println("  2) OTHER");
                System.out.print("Enter option (1 or 2): ");
                productOpt = sc.nextInt();
                sc.nextLine(); // clear newline

                if (productOpt == 1 || productOpt == 2) {
                    break;
                }
                System.out.println("Invalid option. Please enter 1 or 2.\n");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number.\n");
            }
        }

        String productType = (productOpt == 1) ? "ELECTRONICS" : "OTHER";

        /* 2️⃣ AMOUNT ---------------------------------- */
        double amount = 0;
        while (true) {
            try {
                System.out.print("Enter order amount: ");
                amount = sc.nextDouble();
                sc.nextLine();

                if (amount > 0) {
                    break;
                }
                System.out.println("Amount must be greater than 0.\n");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a valid number.\n");
            }
        }

        /* 3️⃣ PAYMENT METHOD -------------------------- */
        int payOpt = 0;
        while (true) {
            try {
                System.out.println("Select payment method:");
                System.out.println("  1) CREDIT CARD");
                System.out.println("  2) PAYPAL");
                System.out.print("Enter option (1 or 2): ");
                payOpt = sc.nextInt();
                sc.nextLine();

                if (payOpt == 1 || payOpt == 2) {
                    break;
                }
                System.out.println("Invalid option. Please enter 1 or 2.\n");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number.\n");
            }
        }

        IPaymentProcessor payment = (payOpt == 1)
                ? new CreditCardProcessor()
                : new PayPalProcessor();

        /* 4️⃣ NOTIFICATION METHOD --------------------- */
        int notifyOpt = 0;
        while (true) {
            try {
                System.out.println("Select notification method:");
                System.out.println("  1) EMAIL");
                System.out.println("  2) SMS");
                System.out.print("Enter option (1 or 2): ");
                notifyOpt = sc.nextInt();
                sc.nextLine();

                if (notifyOpt == 1 || notifyOpt == 2) {
                    break;
                }
                System.out.println("Invalid option. Please enter 1 or 2.\n");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number.\n");
            }
        }

        INotification notifier = (notifyOpt == 1)
                ? new EmailNotification()
                : new SMSNotification();

        /* 5️⃣ DISCOUNT LOGIC -------------------------- */
        IDiscountStrategy discount = productType.equals("ELECTRONICS")
                ? new ElectronicsDiscount()
                : new NoDiscount();

        /* 6️⃣ PROCESS ORDER --------------------------- */
        Order order = new Order(productType, amount);
        OrderProcessor processor = new OrderProcessor(discount, payment, notifier);
        processor.process(order);

        sc.close();
    }
}
