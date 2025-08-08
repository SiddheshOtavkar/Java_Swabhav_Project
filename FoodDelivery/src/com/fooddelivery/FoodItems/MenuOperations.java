package com.fooddelivery.FoodItems;

import java.util.*;

import com.fooddelivery.exceptions.InvalidMenuChoiceException;


public class MenuOperations {

	public void addItem(List<FoodItem> menu, FoodItem item) {
		menu.add(item);
		System.out.println("✅ Item added!");
	}

	public void removeItem(List<FoodItem> menu, FoodItem item) {
		boolean removed = menu.remove(item);
		if (removed) {
			System.out.println("✅ Item removed!");
		} else {
			System.out.println("❌ Item not found!");
		}
	}

	public Map<Integer, FoodItem> listItems(List<FoodItem> menu) {
		Map<Integer, FoodItem> indexedItems = new LinkedHashMap<>();
		if (menu.isEmpty()) {
			System.out.println("📭 No items in the menu.");
			return indexedItems;
		}

		Scanner sc = new Scanner(System.in);

		// Step 1: Get unique categories
		Set<String> categories = new LinkedHashSet<>();
		for (FoodItem item : menu) {
			categories.add(item.getCategory());
		}

		// Step 2: Show category options
		System.out.println("\n🔍 What category would you like to view?");
		int index = 1;
		Map<Integer, String> optionMap = new LinkedHashMap<>();
		for (String category : categories) {
			System.out.println(index + ". " + category);
			optionMap.put(index++, category);
		}
		System.out.println(index + ". View All");
		optionMap.put(index, "ALL");

		// Step 3: Get user input with validation
		int choice = -1;
		try {
			System.out.print("Enter your choice: ");
			if (!sc.hasNextInt()) {
				throw new InvalidMenuChoiceException("❌ Invalid input. Please enter a number.");
			}
			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			if (!optionMap.containsKey(choice)) {
				throw new InvalidMenuChoiceException("❌ Choice out of range.");
			}
		} catch (InvalidMenuChoiceException e) {
			System.out.println(e.getMessage());
			return indexedItems;
		} catch (InputMismatchException e) {
			System.out.println("❌ Invalid input. Please enter numeric value.");
			sc.nextLine(); // clear input
			return indexedItems;
		}

		String selectedCategory = optionMap.getOrDefault(choice, "ALL");

		// Step 4: Prepare grouped output
		int globalIndex = 1;
		System.out.println("\n📋 Menu:");

		Map<String, Map<String, List<FoodItem>>> groupedMenu = new LinkedHashMap<>();

		for (FoodItem item : menu) {
			if (!selectedCategory.equals("ALL") && !item.getCategory().equals(selectedCategory)) {
				continue;
			}

			groupedMenu.computeIfAbsent(item.getCategory(), k -> new LinkedHashMap<>())
					.computeIfAbsent(item.getCuisine(), k -> new ArrayList<>()).add(item);
		}

		for (Map.Entry<String, Map<String, List<FoodItem>>> categoryEntry : groupedMenu.entrySet()) {
			System.out.println("\n\u001B[1m" + categoryEntry.getKey().toUpperCase() + ":\u001B[0m");

			for (Map.Entry<String, List<FoodItem>> cuisineEntry : categoryEntry.getValue().entrySet()) {
				System.out.println("  \u001B[1mCuisine: " + cuisineEntry.getKey().toUpperCase() + "\u001B[0m");

				for (FoodItem item : cuisineEntry.getValue()) {
					System.out.println("    " + globalIndex + ". " + item);
					indexedItems.put(globalIndex++, item);
				}
			}
		}

		return indexedItems;
	}
}
