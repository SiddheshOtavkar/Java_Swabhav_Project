package com.aurionpro.assignment.Transactions;

public class Transaction {
	int id;
	double amount;

	public Transaction(int id, double amount) {
		this.id = id;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return " {id=" + id + ", amount=" + amount + "}";
	}
}
