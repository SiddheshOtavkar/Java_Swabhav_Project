package com.aurionpro.abstractTest;

public class CommericalCustomer extends Customer {
	public double totalPrice = 0.0;
	public double pricePerUnit = 8;

	@Override
	public void calculateBill(double unitsConsumed) {
		totalPrice = unitsConsumed * pricePerUnit;
	}

	public void display() {
		System.out.println("Total Bill of Commerical Customer: " + totalPrice);
	}
}
