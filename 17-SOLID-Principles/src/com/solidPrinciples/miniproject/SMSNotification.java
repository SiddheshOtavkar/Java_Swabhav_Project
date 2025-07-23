package com.solidPrinciples.miniproject;

public class SMSNotification implements INotification {

	@Override
	public void sendNotification(Order order) {
		 System.out.println("SMS sent for order: " + order.getProductType());
	}
	
}
