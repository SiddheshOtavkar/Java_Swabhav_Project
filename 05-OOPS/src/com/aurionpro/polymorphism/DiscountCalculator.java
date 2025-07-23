package com.aurionpro.polymorphism;

public class DiscountCalculator {
	// Method 1: No coupon or membership
	public static void calculateDiscount(double price) {
		double discount = price * 0.05;
		double finalPrice = price - discount;
		System.out.println("Final Price: ₹" + finalPrice);
	}

	// Method 2: With coupon
	public static void calculateDiscount(double price, String coupon) {
		double discount = 0;

		if (coupon.equalsIgnoreCase("SAVE10")) {
			discount = price * 0.10;
		}

		double finalPrice = price - discount;
		System.out.println("Final Price: ₹" + finalPrice);
	}

	// Method 3: With coupon and membership
	public static void calculateDiscount(double price, String coupon, boolean isMember) {
		double discount = 0;

		if (coupon.equalsIgnoreCase("SAVE10")) {
			discount = price * 0.10;
		}

		if (isMember) {
			discount += price * 0.05;
		}

		double finalPrice = price - discount;
		System.out.println("Final Price: ₹" + finalPrice);
	}

	public static void main(String[] args) {
		System.out.println("No Coupon:");
		DiscountCalculator.calculateDiscount(1000); // 5% off

		System.out.println("\nWith SAVE10 Coupon:");
		DiscountCalculator.calculateDiscount(1000, "SAVE10"); // 10% off

		System.out.println("\nWith Coupon and Member:");
		DiscountCalculator.calculateDiscount(1000, "SAVE10", true); // 15% off
	}
}
