package com.aurionpro.abstractTest;

public class ResidentalCustomer extends Customer {
	public double totalPrice = 0.0;
	public double pricePerUnit = 5.0;

	@Override
	public void calculateBill(double unitsConsumed) {
		totalPrice = unitsConsumed * pricePerUnit;
	}

	public void display() {
		System.out.println("Total Bill of Residental Customer: " + totalPrice);
	}
}
