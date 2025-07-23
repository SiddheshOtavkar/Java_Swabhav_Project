package com.solidPrinciples.miniproject;

public class PayPalProcessor implements IPaymentProcessor {

	@Override
	public void pay(double amount) {
		System.out.println("Paid amount: " + amount + " with PayPal.");
	}

}
