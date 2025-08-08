package com.fooddelivery.admin;

import java.util.*;

import com.fooddelivery.DeliveryPartners.DeliveryAgentManager;
import com.fooddelivery.FoodItems.FoodItem;
import com.fooddelivery.FoodItems.MenuOperations;
import com.fooddelivery.FoodItems.MenuStorage;
import com.fooddelivery.MenuDetails.IMenu;
import com.fooddelivery.MenuDetails.Indian;
import com.fooddelivery.MenuDetails.Italian;
import com.fooddelivery.MenuDetails.Japanese;
import com.fooddelivery.MenuDetails.Portuguese;
import com.fooddelivery.foodDetails.Beaverage;
import com.fooddelivery.foodDetails.Breakfast;
import com.fooddelivery.foodDetails.Meal;
import com.fooddelivery.foodDetails.Snacks;

public class AdminInterface {
    private static final Scanner sc = new Scanner(System.in);
    private static final String ADMIN_PASSWORD = "admin123";

    public static void start() {
        List<FoodItem> menu = MenuStorage.loadMenu();
        MenuOperations operations = new MenuOperations();

        System.out.println("\n🔐 ===============================");
        System.out.print("🔐 Enter Admin Password: ");
        String enteredPassword = sc.nextLine();

        if (!enteredPassword.equals(ADMIN_PASSWORD)) {
            System.out.println("❌ Incorrect password. Access denied.");
            return;
        }

        while (true) {
            try {
                System.out.println("\n📋 ====== ADMIN PANEL ======");
                System.out.println("1️⃣  Add Item");
                System.out.println("2️⃣  Remove Item");
                System.out.println("3️⃣  List Items");
                System.out.println("4️⃣  Save & Exit");
                System.out.println("5️⃣  Manage Delivery Agents");
                System.out.println("============================");
                System.out.print("👉 Enter your choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addItem(menu, operations);
                    case 2 -> removeItem(menu, operations);
                    case 3 -> operations.listItems(menu);
                    case 4 -> {
                        MenuStorage.saveMenu(menu);
                        System.out.println("✅ Menu saved successfully.");
                        System.out.println("👋 Exiting Admin Panel...");
                        return;
                    }
                    case 5 -> manageDeliveryAgents();
                    default -> System.out.println("❌ Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid numeric input.");
            }
        }
    }

    private static void addItem(List<FoodItem> menu, MenuOperations operations) {
        try {
            System.out.println("\n➕ ==== Add New Item ====");
            System.out.print("📝 Enter item name: ");
            String name = sc.nextLine();

            System.out.print("💰 Enter item price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.println("📦 Select category:");
            System.out.println("1. Snacks\n2. Beverage\n3. Meal\n4. Breakfast");
            int catChoice = Integer.parseInt(sc.nextLine());
            String category = getCategoryFromChoice(catChoice);

            System.out.println("🌍 Select cuisine:");
            System.out.println("1. Indian\n2. Italian\n3. Japanese\n4. Portuguese");
            int cuisineChoice = Integer.parseInt(sc.nextLine());
            String cuisine = getCuisineFromChoice(cuisineChoice);

            boolean alreadyExists = menu.stream().anyMatch(item ->
                item.getName().equalsIgnoreCase(name)
                    && item.getCategory().equalsIgnoreCase(category)
                    && item.getCuisine().equalsIgnoreCase(cuisine));

            if (alreadyExists) {
                System.out.println("⚠️  Item already exists in the menu.");
            } else {
                operations.addItem(menu, new FoodItem(name, price, category, cuisine));
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter correct numeric values.");
        }
    }

    private static void removeItem(List<FoodItem> menu, MenuOperations operations) {
        Map<Integer, FoodItem> indexedItems = operations.listItems(menu);
        if (indexedItems.isEmpty()) return;

        try {
            System.out.print("🗑️  Enter item number to remove: ");
            int removeIndex = Integer.parseInt(sc.nextLine());

            FoodItem itemToRemove = indexedItems.get(removeIndex);
            if (itemToRemove != null) {
                operations.removeItem(menu, itemToRemove);
            } else {
                System.out.println("❌ Invalid item number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid number.");
        }
    }

    private static String getCuisineFromChoice(int choice) {
        IMenu menu = switch (choice) {
            case 1 -> new Indian();
            case 2 -> new Italian();
            case 3 -> new Japanese();
            case 4 -> new Portuguese();
            default -> {
                System.out.println("⚠️  Invalid choice. Defaulting to 'Global'");
                yield null;
            }
        };
        return menu != null ? menu.MenuType() : "Global";
    }

    private static String getCategoryFromChoice(int choice) {
        return switch (choice) {
            case 1 -> new Snacks().foodType();
            case 2 -> new Beaverage().foodType();  // fixed spelling if needed
            case 3 -> new Meal().foodType();
            case 4 -> new Breakfast().foodType();
            default -> {
                System.out.println("⚠️  Invalid choice. Defaulting to 'General'");
                yield "General";
            }
        };
    }

    private static void manageDeliveryAgents() {
        while (true) {
            try {
                System.out.println("\n🚚 ===== Delivery Agent Manager =====");
                System.out.println("1. List Active Agents");
                System.out.println("2. Add Agent");
                System.out.println("3. Remove Agent");
                System.out.println("4. 🔙 Back");
                System.out.print("👉 Enter your choice: ");
                int manageChoice = Integer.parseInt(sc.nextLine());

                switch (manageChoice) {
                    case 1 -> DeliveryAgentManager.listAgents();
                    case 2 -> {
                        Set<String> toAdd = DeliveryAgentManager.getAvailableAgentNamesToAdd();
                        if (toAdd.isEmpty()) {
                            System.out.println("✅ All agents already active.");
                            break;
                        }
                        List<String> addList = new ArrayList<>(toAdd);
                        System.out.println("Available Agents to Add:");
                        for (int i = 0; i < addList.size(); i++) {
                            System.out.println((i + 1) + ". " + addList.get(i));
                        }
                        System.out.print("Enter number to add: ");
                        int addChoice = Integer.parseInt(sc.nextLine());
                        if (addChoice >= 1 && addChoice <= addList.size()) {
                            DeliveryAgentManager.addAgentByName(addList.get(addChoice - 1));
                        } else {
                            System.out.println("❌ Invalid choice.");
                        }
                    }
                    case 3 -> {
                        Set<String> activeAgents = DeliveryAgentManager.getActiveAgentNames();
                        if (activeAgents.isEmpty()) {
                            System.out.println("❌ No agents to remove.");
                            break;
                        }
                        List<String> removeList = new ArrayList<>(activeAgents);
                        System.out.println("Active Agents:");
                        for (int i = 0; i < removeList.size(); i++) {
                            System.out.println((i + 1) + ". " + removeList.get(i));
                        }
                        System.out.print("Enter number to remove: ");
                        int remChoice = Integer.parseInt(sc.nextLine());
                        if (remChoice >= 1 && remChoice <= removeList.size()) {
                            DeliveryAgentManager.removeAgentByName(removeList.get(remChoice - 1));
                        } else {
                            System.out.println("❌ Invalid choice.");
                        }
                    }
                    case 4 -> {
                        System.out.println("🔙 Returning to Admin Panel...");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }
}
