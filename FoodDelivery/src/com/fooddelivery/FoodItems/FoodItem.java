package com.fooddelivery.FoodItems;

import java.io.*;
import java.util.*;

public class FoodItem implements Serializable {
	private String name;
	private double price;
	private String category;
	private String cuisine;

	public FoodItem(String name, double price, String category, String cuisine) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.cuisine = cuisine;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString() {
		return "FoodItem [name=" + name + ", price=" + price + ", category=" + category + ", cuisine=" + cuisine + "]";
	}
}
