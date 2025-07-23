package com.aurionpro.vehicleSystem;

import java.util.Scanner;

public class PaymentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the amount to be paid by credit card: ");
		int amount1 = scanner.nextInt();
		
		System.out.print("Enter the amount to be paid by debit card: ");
		int amount2 = scanner.nextInt();
		
		System.out.print("Enter the amount to be paid by UPI: ");
		int amount3 = scanner.nextInt();
		
		IPayment payment1 = new CreditCardPayment();
		payment1.processPayment(amount1);
		
		IPayment payment2 = new DebitCardPayment();
		payment2.processPayment(amount2);
		
		IPayment payment3 = new UPIPayment();
		payment3.processPayment(amount3);
		
		scanner.close();
	}
}
