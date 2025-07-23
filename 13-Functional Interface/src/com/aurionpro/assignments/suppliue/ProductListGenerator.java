package com.aurionpro.assignments.suppliue;

import java.util.List;
import java.util.function.Supplier;

public class ProductListGenerator {
	public static void main(String[] args) {
		 // Supplier that returns a list of 5 default product names
        Supplier<List<String>> productSupplier = () -> List.of(
            "Pen", "Notebook", "Mouse", "Keyboard", "Charger"
        );

        // Get the product list and print each product
        List<String> products = productSupplier.get();
        System.out.println("Product List:");
        for (String product : products) {
            System.out.println("- " + product);
        }
	}
}
