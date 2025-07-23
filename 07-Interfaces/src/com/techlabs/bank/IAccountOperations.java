package com.techlabs.bank;

public interface IAccountOperations {
	void deposit(double amount);

	void withdraw(double amount);

	void checkBalance();
}
