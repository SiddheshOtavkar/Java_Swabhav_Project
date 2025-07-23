package com.aurionpro.vehicleSystem;

public class CreditCardPayment implements IPayment {

	@Override
	public void processPayment(double amount) {
		System.out.println("Amount paid by credit card is: " + amount);
	}

}
