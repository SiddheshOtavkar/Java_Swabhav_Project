package com.aurionpro.polymorphism;

public class Bill {

	public static void generateBill(String item, int qty) {
		int price = 100;
		int bill = price * qty;
		System.out.println("Total bill of Item: " + item + " is: " + bill);
	}

	public static void generateBill(String item, int qty, double discount) {
		int price = 100;
		double bill = (price * qty) - discount;
		System.out.println("Total bill with discount is: " + bill);
	}

	public static void generateBill(String item, int qty, double discount, double tax) {
		int price = 100;
		double bill = ((price * qty) - discount) + tax;
		System.out.println("Total bill with discount is: " + bill);
	}

	public static void main(String[] args) {
		generateBill("Car", 5);
		generateBill("Bat", 15, 5.67);
		generateBill("Chair", 50, 4.5, 30.87);
	}

}
