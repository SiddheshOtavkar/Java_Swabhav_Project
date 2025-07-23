package com.interfaces.miniproject.bankingDomain;

public class CurrentAccount implements IAccountOperations {
	public double balance = 10000;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: ₹" + balance);
    }
}
