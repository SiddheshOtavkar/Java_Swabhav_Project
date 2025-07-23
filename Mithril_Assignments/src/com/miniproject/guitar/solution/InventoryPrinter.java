package com.miniproject.guitar.solution;

import java.util.List;

public class InventoryPrinter {

	public void printMatches(List<Guitar> guitars) {
		if (guitars.isEmpty()) {
			System.out.println("Sorry, Erin, we have nothing for you.");
			return;
		}
		for (Guitar guitar : guitars) {
			GuitarSpec spec = guitar.getSpec();
			System.out.println("Erin, you might like this " + spec.getBuilder() + " " + spec.getModel() + " "
					+ spec.getType() + " guitar:\n   " + spec.getBackWood() + " back and sides,\n   "
					+ spec.getTopWood() + " top.\nYou can have it for only $" + guitar.getPrice() + "!\n");
		}
	}
}
