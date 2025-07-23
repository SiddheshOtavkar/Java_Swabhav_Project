package com.solidPrinciples.miniproject;

public class OrderProcessor {
	private final IDiscountStrategy discountStrategy;
	private final IPaymentProcessor paymentProcessor;
	private final INotification notifier;

	public OrderProcessor(IDiscountStrategy discountStrategy, IPaymentProcessor paymentProcessor, INotification notifier) {
		this.discountStrategy = discountStrategy;
		this.paymentProcessor = paymentProcessor;
		this.notifier = notifier;
	}

	public void process(Order order) {
		double net = discountStrategy.applyDiscount(order.getAmount());
		paymentProcessor.pay(net);
		notifier.sendNotification(order);
	}
}
