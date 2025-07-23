package com.aurionpro.vehicleSystem;

public class UPIPayment implements IPayment {

	@Override
	public void processPayment(double amount) {
		System.out.println("Amount paid by UPI is: " + amount);
	}

}
