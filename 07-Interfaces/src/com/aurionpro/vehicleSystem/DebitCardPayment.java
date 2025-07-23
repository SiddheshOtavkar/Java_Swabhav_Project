package com.aurionpro.vehicleSystem;

public class DebitCardPayment implements IPayment {

	@Override
	public void processPayment(double amount) {
		System.out.println("Amount paid by debit card is: " + amount);
	}
	
}
