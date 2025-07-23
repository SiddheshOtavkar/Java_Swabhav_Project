package com.aurionpro.test;

import java.util.Scanner;

public class RideBillGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int totalBill = 0;

        System.out.print("Enter your height: ");
        int height = scanner.nextInt();

        if (height >= 120) {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            if (age >= 45 && age <= 55) {
                totalBill = 0;
            } else if (age < 12) {
                totalBill = 5;
            } else if (age <= 18) {
                totalBill = 7;
            } else {
                totalBill = 12;
            }

            System.out.print("Do you want a photo (yes/no)? ");
            String reply = scanner.next();

            if (reply.equalsIgnoreCase("yes")) {
                totalBill += 3;
            }

            System.out.println("Total Bill is in $: " + totalBill + "$");
        } else {
            System.out.println("Sorry, you can't ride!!!");
        }

        scanner.close();
	}
}
