package com.aurionpro.EnumStatic.assign;

public class Shop {
	public static final double TAX_RATE = 0.18;

	public static void main(String[] args) {
		double price = 1000.0;
		double taxAmount = price * TAX_RATE;
		double totalPrice = price + taxAmount;

		System.out.println("Base Price: ₹" + price);
		System.out.println("Tax (18%): ₹" + taxAmount);
		System.out.println("Total Price (including tax): ₹" + totalPrice);
	}
}
