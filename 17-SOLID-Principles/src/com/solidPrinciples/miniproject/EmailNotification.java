package com.solidPrinciples.miniproject;

public class EmailNotification implements INotification {

	@Override
	public void sendNotification(Order order) {
		System.out.println("Email sent for order: " + order.getProductType());
	}

}
