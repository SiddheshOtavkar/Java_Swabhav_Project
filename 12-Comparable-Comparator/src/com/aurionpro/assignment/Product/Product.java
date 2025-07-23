package com.aurionpro.assignment.Product;

public class Product {
	private String category;
	private String name;
	private double price;

	Product(String category, String name, double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return category + " - " + name + " - Rs." + price;
	}
}
