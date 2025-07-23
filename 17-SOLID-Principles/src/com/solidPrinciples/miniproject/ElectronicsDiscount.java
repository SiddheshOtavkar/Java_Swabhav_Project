package com.solidPrinciples.miniproject;

public class ElectronicsDiscount implements IDiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.90;
	}

}
