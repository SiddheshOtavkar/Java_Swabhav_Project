package com.fooddelivery.payments;

import java.util.Map;

import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.customer.CustomerInformation;

public interface IPayments {

	void payment(double amount, CustomerInformation customer, Map<FoodItem, Integer> cartItems, String deliveryAgent,
			double discountedValue);
}
