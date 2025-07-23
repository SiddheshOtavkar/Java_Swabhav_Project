package com.solidPrinciples.miniproject;

public class CreditCardProcessor implements IPaymentProcessor {

	@Override
	public void pay(double amount) {
		System.out.println("Paid amount: " + amount + " with Credit Card.");
	}

}
