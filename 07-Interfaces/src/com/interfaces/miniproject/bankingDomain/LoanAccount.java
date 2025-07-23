package com.interfaces.miniproject.bankingDomain;

public class LoanAccount implements IAccountOperations {
             
    private static final double MAX_LIMIT = 100000;  
    private double balance = 0.0;

    @Override
    public void deposit(double amount) {
        System.out.println("Deposits/repayments are not allowed in this Loan Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Borrow amount must be positive.");
            balance = MAX_LIMIT - amount;
            return;
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Loan Balance: ₹" + balance);
    }
}
