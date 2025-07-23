package com.miniproject.guitar.solution;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars = new ArrayList<>();

	public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
		Guitar guitar = new Guitar(serialNumber, price, spec);
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Guitar guitar : guitars) {
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	public List<Guitar> getAllGuitars() {
		return guitars;
	}
}

