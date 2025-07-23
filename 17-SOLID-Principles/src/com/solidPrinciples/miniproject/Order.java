package com.solidPrinciples.miniproject;

public class Order {
	private String productType;
	private double amount;

	public Order(String productType, double amount) {
		this.productType = productType;
		this.amount = amount;
	}

	public String getProductType() {
		return productType;
	}

	public double getAmount() {
		return amount;
	}
}
