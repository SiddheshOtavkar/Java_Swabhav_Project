package com.aurionpro.assignment.Transactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionSortTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Transaction> list = new ArrayList<>();

//        list.add(new Transaction(101, 5000.0));
//        list.add(new Transaction(102, 3000.0));
//        list.add(new Transaction(103, 7000.0));
//        list.add(new Transaction(104, 3000.0)); 
//        list.add(new Transaction(105, 8000.0));

		int n;
		while (true) {
			try {
				System.out.print("How many transactions? ");
				n = scanner.nextInt();
				scanner.nextLine();
				if (n <= 0) {
					System.out.println("Enter a positive number.");
					continue;
				}
				break;
			} catch (InputMismatchException ex) {
				System.out.println("Numbers only, please.");
				scanner.nextLine();
			}
		}

		for (int i = 1; i <= n; i++) {
			int id;
			double amount;

			/* id */
			while (true) {
				try {
					System.out.print("Enter id for transaction " + i + ": ");
					id = scanner.nextInt();
					scanner.nextLine();
					if (id <= 0) {
						System.out.println("ID must be positive.");
						continue;
					}
					break;
				} catch (InputMismatchException ex) {
					System.out.println("ID must be a number.");
					scanner.nextLine();
				}
			}

			/* amount */
			while (true) {
				try {
					System.out.print("Enter amount for id " + id + ": ");
					amount = scanner.nextDouble();
					scanner.nextLine();
					if (amount <= 0) {
						System.out.println("Amount must be positive.");
						continue;
					}
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Amount must be numeric.");
					scanner.nextLine();
				}
			}

			list.add(new Transaction(id, amount));
		}

		Collections.sort(list, new TransactionAmountDescComparator());

		System.out.println("Transactions sorted by amount (desc), then ID (asc):");
		for (Transaction t : list) {
			System.out.println(t);
		}

		scanner.close();
	}
}
