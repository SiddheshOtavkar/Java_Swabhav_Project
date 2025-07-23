package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.BankAccount;

public class BankAccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of account holders: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		BankAccount[] person = new BankAccount[size];
		for (int i = 0; i < size; i++) {
			person[i] = new BankAccount();
			System.out.print("Enter name of accountholder: ");
			String name = scanner.nextLine();

			System.out.print("Enter account number: ");
			String accountNumber = scanner.nextLine();

			System.out.print("Enter the balance: ");
			double balance = scanner.nextDouble();
			scanner.nextLine();

			person[i].setBalance(balance);
			person[i].setHolderName(name);
			person[i].setAccountNumber(accountNumber);

			System.out.println();
		}

		for (BankAccount obj : person) {
			System.out.println(obj);
		}

		System.out.print("What you want to do (deposit/withdraw/checkBalance: ");
		String operation = scanner.nextLine();

		// Account operation
		System.out.print("\nEnter account number to operate on: ");
		String accNo = scanner.nextLine();

		// Search for account
		BankAccount selectedAccount = null;
		for (BankAccount acc : person) {
			if (acc.getAccountNumber().equals(accNo)) {
				selectedAccount = acc;
				break;
			}
		}

		if (selectedAccount == null) {
			System.out.println("❌ Account not found!");
			scanner.close();
			return;
		}

		switch (operation) {
		case "deposit":
			System.out.print("Enter amount to deposit: ");
			double depositAmount = scanner.nextDouble();
			selectedAccount.deposit(depositAmount);
			break;

		case "withdraw":
			System.out.print("Enter amount to withdraw: ");
			double withdrawAmount = scanner.nextDouble();
			selectedAccount.withdraw(withdrawAmount);
			break;

		case "checkbalance":
			selectedAccount.balanceCheck();
			break;

		default:
			System.out.println("Invalid operation!");
		}

		scanner.close();
	}
}
