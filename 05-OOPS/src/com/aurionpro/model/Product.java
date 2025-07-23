package com.aurionpro.model;

public class Product {
	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Invalid price. Must be greater than 0.");
		}
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Product ID   : " + id + "\nProduct Name : " + name + "\nProduct Price: ₹" + price;
	}
}
