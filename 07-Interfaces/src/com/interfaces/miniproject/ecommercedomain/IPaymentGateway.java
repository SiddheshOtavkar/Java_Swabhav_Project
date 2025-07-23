package com.interfaces.miniproject.ecommercedomain;

public interface IPaymentGateway {
	void pay(double amount);

	void refund(double amount);
}
