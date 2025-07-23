package com.assignment_day2;

import java.util.Scanner;

public class CurrencyWithdrawal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter withdrawal amount: ");
		int amount = scanner.nextInt();

		// Validation
		if (amount > 50000) {
			System.out.println("Amount exceeds withdrawal limit of 50000");
		} else if (amount % 100 != 0) {
			System.out.println("Amount should be in multiples of 100");
		} else {
			int originalAmount = amount;

			int twoThousand = amount / 2000;
			amount = amount % 2000;

			int fiveHundred = amount / 500;
			amount = amount % 500;

			int twoHundred = amount / 200;
			amount %= 200;

			int hundred = amount / 100;

			System.out.println("Currency breakdown for amount: " + originalAmount);
            if (twoThousand > 0) {
                System.out.println("Two Thousand: " + twoThousand);
            }
            if (fiveHundred > 0) {
                System.out.println("Five Hundred: " + fiveHundred);
            }
            if (twoHundred > 0) {
                System.out.println("Two Hundred: " + twoHundred);
            }
            if (hundred > 0) {
                System.out.println("Hundred: " + hundred);
            }
		}
		scanner.close();
	}
}
