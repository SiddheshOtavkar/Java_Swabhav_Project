package com.solidPrinciples.miniproject;

public class NoDiscount implements IDiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount;
	}

}
