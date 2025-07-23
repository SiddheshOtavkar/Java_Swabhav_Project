package com.aurionpro.assignments.consumer;

import java.util.List;
import java.util.function.Consumer;

public class ListPrinter {
	public static void main(String[] args) {
		// Define Consumer to print each element in the list
		Consumer<List<String>> printList = list -> {
			for (String item : list) {
				System.out.println(item);
			}
		};

		// Sample list
		List<String> items = List.of("Pen", "Notebook", "Laptop", "Mouse");

		// Apply consumer
		printList.accept(items);
	}
}
