package com.fooddelivery.userConsole;

import java.util.*;

import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.FoodItems.MenuOperations;
import com.fooddelivery.FoodItems.MenuStorage;
import com.fooddelivery.cart.Cart;
import com.fooddelivery.exceptions.InvalidInputException;

public class UserInterface {
	private static final Scanner sc = new Scanner(System.in);

	public static void start() {
		List<FoodItem> menu = MenuStorage.loadMenu();
		MenuOperations operations = new MenuOperations();
		Cart cart = new Cart();

		while (true) {
			System.out.println("\n======================================");
			System.out.println("🍽️  User Menu");
			System.out.println("1️⃣  View Menu");
			System.out.println("2️⃣  Add Item to Cart");
			System.out.println("3️⃣  Remove Item from Cart");
			System.out.println("4️⃣  Update Item Quantity");
			System.out.println("5️⃣  View Cart Items");
			System.out.println("6️⃣  Place Order");
			System.out.println("7️⃣  Exit");
			System.out.println("======================================");
			System.out.print("👉 Enter your choice: ");

			int choice = -1;
			try {
				choice = sc.nextInt();
				sc.nextLine(); // consume newline
			} catch (InputMismatchException e) {
				System.out.println("❌ Please enter a valid number.");
				sc.nextLine(); // clear invalid input
				continue;
			}

			switch (choice) {
			case 1:
				operations.listItems(menu);
				break;

			case 2:
				Map<Integer, FoodItem> indexedItems = operations.listItems(menu);
				if (indexedItems.isEmpty())
					break;

				try {
					System.out.print("📦 Enter item number to add to cart: ");
					int itemIndex = sc.nextInt();

					System.out.print("🛒 Enter quantity: ");
					int quantity = sc.nextInt();

					if (quantity <= 0)
						throw new InvalidInputException("❌ Quantity must be greater than 0.");
					FoodItem selectedItem = indexedItems.get(itemIndex);
					if (selectedItem == null)
						throw new InvalidInputException("❌ Invalid item number.");

					cart.addToCart(selectedItem, quantity);
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("❌ Please enter valid numeric input.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("⚠️  Unexpected error: " + e.getMessage());
					sc.nextLine();
				}
				break;

			case 3:
				cart.viewCart();
				try {
					System.out.print("📦 Enter item number to remove from cart: ");
					int removeIndex = sc.nextInt();

					if (removeIndex < 1)
						throw new InvalidInputException("❌ Invalid item index.");
					cart.removeFromCart(removeIndex);
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("❌ Please enter a valid number.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("⚠️  Unexpected error: " + e.getMessage());
					sc.nextLine();
				}
				break;

			case 4:
				cart.viewCart();
				try {
					System.out.print("✏️ Enter item number to update: ");
					int updateIndex = sc.nextInt();

					if (updateIndex < 1)
						throw new InvalidInputException("❌ Invalid item index.");

					System.out.print("🔁 Enter new quantity: ");
					int newQty = sc.nextInt();

					if (newQty <= 0)
						throw new InvalidInputException("❌ Quantity must be greater than 0.");

					cart.updateQuantity(updateIndex, newQty);
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("❌ Please enter valid numeric input.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("⚠️  Unexpected error: " + e.getMessage());
					sc.nextLine();
				}
				break;

			case 5:
				cart.viewCart();
				break;

			case 6:
				cart.placeOrder();
				break;

			case 7:
				System.out.println("👋 Exiting User Menu. Have a delicious day!");
				return;

			default:
				System.out.println("❌ Invalid choice. Please select from 1 to 7.");
			}
		}
	}
}
