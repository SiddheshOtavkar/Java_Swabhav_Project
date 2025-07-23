package com.aurionpro.assignment3;

public class BankAccount {
	private double balance = 0;

	public void deposit(double amount) {
		if (amount > 0)
			balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > 0 && balance >= amount)
			balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}
