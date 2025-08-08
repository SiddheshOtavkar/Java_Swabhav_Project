package com.fooddelivery.cart;

import java.util.*;

import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.customer.CustomerInformation;
import com.fooddelivery.customer.CustomerOrderDetails;
import com.fooddelivery.payments.PaymentInterface;


public class Cart {
	private final Map<FoodItem, Integer> cartItems = new LinkedHashMap<>();

	public void addToCart(FoodItem item, int quantity) {
		if (quantity <= 0) {
			System.out.println("❌ Quantity must be greater than zero.");
			return;
		}

		cartItems.put(item, cartItems.getOrDefault(item, 0) + quantity);
		System.out.println("✅ Added " + quantity + " x " + item.getName() + " to cart.");
	}

	public boolean removeFromCart(int index) {
		List<FoodItem> items = new ArrayList<>(cartItems.keySet());

		if (index < 1 || index > items.size()) {
			System.out.println("❌ Invalid item number.");
			return false;
		}

		FoodItem toRemove = items.get(index - 1);
		cartItems.remove(toRemove);
		System.out.println("✅ Removed " + toRemove.getName() + " from cart.");
		return true;
	}

	public void updateQuantity(int index, int quantity) {
		List<FoodItem> items = new ArrayList<>(cartItems.keySet());

		if (index < 1 || index > items.size()) {
			System.out.println("❌ Invalid item number.");
			return;
		}

		if (quantity <= 0) {
			System.out.println("❌ Quantity must be greater than zero.");
			return;
		}

		FoodItem itemToUpdate = items.get(index - 1);
		cartItems.put(itemToUpdate, quantity);
		System.out.println("✅ Updated " + itemToUpdate.getName() + " quantity to " + quantity);
	}

	public double viewCart() {
		if (cartItems.isEmpty()) {
			System.out.println("🛒 Cart is empty.");
			return 0;
		}

		double total = 0;
		int index = 1;
		Map<Integer, FoodItem> indexedCartMap = new LinkedHashMap<>();

		System.out.println("\n🧾 Cart Items:");

		// Grouping by Cuisine → Category
		Map<String, Map<String, List<Map.Entry<FoodItem, Integer>>>> groupedCart = new LinkedHashMap<>();

		for (Map.Entry<FoodItem, Integer> entry : cartItems.entrySet()) {
			FoodItem item = entry.getKey();
			String cuisine = item.getCuisine();
			String category = item.getCategory();

			groupedCart.computeIfAbsent(cuisine, k -> new LinkedHashMap<>())
					.computeIfAbsent(category, k -> new ArrayList<>()).add(entry);
		}

		for (Map.Entry<String, Map<String, List<Map.Entry<FoodItem, Integer>>>> cuisineEntry : groupedCart.entrySet()) {
			System.out.println("\n\u001B[1m🍽️ Cuisine: " + cuisineEntry.getKey().toUpperCase() + "\u001B[0m");

			for (Map.Entry<String, List<Map.Entry<FoodItem, Integer>>> categoryEntry : cuisineEntry.getValue()
					.entrySet()) {
				System.out.println("  \u001B[1m" + categoryEntry.getKey().toUpperCase() + ":\u001B[0m");

				for (Map.Entry<FoodItem, Integer> entry : categoryEntry.getValue()) {
					FoodItem item = entry.getKey();
					int quantity = entry.getValue();
					double itemTotal = item.getPrice() * quantity;
					System.out.println("    " + index + ". " + item.getName() + " x " + quantity + " = ₹" + itemTotal);
					indexedCartMap.put(index++, item);
					total += itemTotal;
				}
			}
		}

		System.out.println("\n\u001B[1mTotal: ₹" + total + "\u001B[0m");

		if (total > 500) {
			System.out.println("You are eligible for discount of 15%");
			double discount = total * 0.15;
			double discountedValue = total - discount;
			System.out.println("Discounted total is ₹" + discountedValue);
		}
		return total;
	}

	public void placeOrder() {
		if (cartItems.isEmpty()) {
			System.out.println("❌ Cart is empty. Cannot place order.");
			return;
		}

		try {
			double total = viewCart();
			double discountedValue = 0;
			if (total > 500) {

				double discount = total * 0.15;
				discountedValue = total - discount;

			}
			CustomerInformation customer = CustomerOrderDetails.getCustomerDetailsFromUser();

			PaymentInterface payment = new PaymentInterface();
			payment.paymentInterface(total, customer, cartItems, discountedValue);

			System.out.println("\n✅ Order placed successfully!");
			System.out.println("🚚 Your order is on the way!");
			cartItems.clear();
		} catch (Exception e) {
			System.out.println("❌ Error occurred during order placement: " + e.getMessage());
		}
	}
}