package com.interfaces.miniproject.ecommercedomain;

public class NetBanking implements IPaymentGateway {
	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " via NetBanking");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded ₹" + amount + " via NetBanking");
	}
}
