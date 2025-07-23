package com.aurionpro.abstractTest;

public abstract class Customer {
	public String name;
	public double unitConsumed = 0.0;
	
	public abstract void calculateBill(double unitConsumed);
}
