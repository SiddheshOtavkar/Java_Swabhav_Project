package com.interfaces.miniproject.ecommercedomain;

public class UPI implements IPaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " via UPI");
    }
}
