package com.fooddelivery.invoice;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.customer.CustomerInformation;

public class Invoice {

	static int orderId = 1;

	public static void printInvoice(CustomerInformation customer, Map<FoodItem, Integer> cartItems, double total,
			String deliveryAgent, double discountedValue) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter fileFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String formattedDate = now.format(formatter);
		String fileName = "Invoice_" + customer.getCustomerId() + "_" + now.format(fileFormatter) + ".txt";

		StringBuilder invoiceContent = new StringBuilder();
		invoiceContent.append("========== INVOICE ==========\n");
		invoiceContent.append("Date: ").append(formattedDate).append("\n");
		invoiceContent.append("Order Id: ").append(orderId).append("\n");
		invoiceContent.append("Customer: ").append(customer.getName()).append("\n");
		invoiceContent.append("Phone: ").append(customer.getPhoneNumber()).append("\n");
		invoiceContent.append("Address: ").append(customer.getAddress()).append("\n");
		invoiceContent.append("Customer ID: ").append(customer.getCustomerId()).append("\n");
		invoiceContent.append("Delivery Agent: ").append(deliveryAgent).append("\n");
		invoiceContent.append("-----------------------------\n");
		invoiceContent.append(String.format("%-30s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Total"));

		orderId++;

		for (Map.Entry<FoodItem, Integer> entry : cartItems.entrySet()) {
			FoodItem item = entry.getKey();
			int qty = entry.getValue();
			double price = item.getPrice();
			double itemTotal = qty * price;

			invoiceContent
					.append(String.format("%-30s %-10d ₹%-9.2f ₹%-9.2f\n", item.getName(), qty, price, itemTotal));
		}

		invoiceContent.append("-----------------------------\n");
		if (discountedValue > 0) {
			invoiceContent.append(String.format("Subtotal:          ₹%.2f\n", total));
			invoiceContent.append(String.format("Discount (15%%):   -₹%.2f\n", discountedValue));
			invoiceContent.append(String.format("Total Amount:      ₹%.2f\n", total - discountedValue));
		} else {
			invoiceContent.append(String.format("Total Amount:      ₹%.2f\n", total));
		}
		invoiceContent.append("=============================\n");

		// Print to console
		System.out.println(invoiceContent);

		// Write to file
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write(invoiceContent.toString());
			System.out.println("📝 Invoice saved to file: " + fileName);
		} catch (IOException e) {
			System.out.println("❌ Error saving invoice: " + e.getMessage());
		}
	}
}