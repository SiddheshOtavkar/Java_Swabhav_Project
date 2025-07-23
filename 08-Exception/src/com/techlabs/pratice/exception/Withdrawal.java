package com.techlabs.pratice.exception;

import java.util.Scanner;

public class Withdrawal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int balance = 10000;

		try {
			System.out.print("How many amount you want to withdraw? ");
			int amount = scanner.nextInt();

			if (amount > balance) {
				throw new ArithmeticException("Insufficient Balance");
			} else {
				balance -= amount;
				System.out.println("Balance after withdrawal is: " + balance);
			}

		} catch (Exception e) {
			System.out.println("Transaction failed: " + e);
		}

		finally {
			System.out.println("Transaction session ended.");
			scanner.close();
		}
	}

}
