package com.aurionpro.assignments.consumer;

import java.util.List;
import java.util.function.Consumer;

class Invoice {
	private final String itemName;
	private final int quantity;
	private final int price; // price per unit

	Invoice(String itemName, int quantity, int price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	String getItemName() {
		return itemName;
	}

	int getQuantity() {
		return quantity;
	}

	int total() {
		return quantity * price;
	}
}

public class InvoiceFormatter {
	public static void main(String[] args) {
		// Consumer that prints a formatted bill line
		Consumer<Invoice> printInvoice = inv -> System.out.println(
				"Item: " + inv.getItemName() + " | Quantity: " + inv.getQuantity() + " | Total: ₹" + inv.total());

		// Three sample invoices
		List<Invoice> bills = List.of(new Invoice("Pen", 2, 10), new Invoice("Notebook", 3, 40),
				new Invoice("USB Cable", 1, 150));

		// Print each invoice
		bills.forEach(printInvoice);
	}
}
