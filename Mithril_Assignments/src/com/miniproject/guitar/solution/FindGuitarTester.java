package com.miniproject.guitar.solution;

import java.util.List;

public class FindGuitarTester {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		GuitarSpec whatErinLikes = new GuitarSpec("Fender", "Stratocastor", "electric", "Alder", "Alder");

		GuitarSearcher searcher = new GuitarSearcher();
		List<Guitar> matches = searcher.search(whatErinLikes, inventory.getAllGuitars());

		InventoryPrinter printer = new InventoryPrinter();
		printer.printMatches(matches);
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("V95693", 1499.95, new GuitarSpec("Fender", "Stratocastor", "electric", "Alder", "Alder"));
		inventory.addGuitar("V95123", 1199.99, new GuitarSpec("Gibson", "Les Paul", "electric", "Mahogany", "Maple"));
		inventory.addGuitar("V12345", 999.99, new GuitarSpec("Fender", "Stratocastor", "electric", "Alder", "Alder"));
	}
}

