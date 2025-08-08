package com.fooddelivery.FoodItems;

import java.io.*;
import java.util.*;

public class MenuStorage {
	private static final String FILE_NAME = "menu.ser";

	public static void saveMenu(List<FoodItem> menu) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			out.writeObject(menu);
		} catch (IOException e) {
			System.out.println("Error saving menu: " + e.getMessage());
		}
	}

	public static List<FoodItem> loadMenu() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return (List<FoodItem>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<>(); // Return empty list if file not found
		}
	}
}
