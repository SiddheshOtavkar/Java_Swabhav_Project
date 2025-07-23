package com.aurionpro.model;

public class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance;

	public BankAccount() {
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount >= 0) {
			balance += amount;
			System.out.println("Total balance after deposit is: " + balance);
		} else {
			System.out.println("Invalid amount!!!");
		}
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Cannot withdraw, because of insufficient balance.");
		} else if (amount < 0) {
			System.out.println("Invalid amount");
		} else {
			balance -= amount;
			System.out.println("Total balance after withdrawal is: " + balance);
		}
	}

	public void balanceCheck() {
		System.out.println("Total Balance is: " + balance);
	}

	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", holderName=" + holderName + ", balance=" + balance
				+ "]";
	}
}
