package com.aurionpro.model;

public class Product {
	public String name;
	public double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void display() {
		System.out.println("Product Name: " + name + ", Price: " + price);
	}
}
