package com.interfaces.miniproject.bankingDomain;

public class SavingsAccount implements IAccountOperations {
	public double balance = 5000;

	@Override
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited ₹" + amount);
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= 10000 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn ₹" + amount);
		} else {
			System.out.println("Withdrawal limit exceeded or insufficient balance.");
		}
	}

	@Override
	public void checkBalance() {
		System.out.println("Savings Account Balance: ₹" + balance);
	}
}
