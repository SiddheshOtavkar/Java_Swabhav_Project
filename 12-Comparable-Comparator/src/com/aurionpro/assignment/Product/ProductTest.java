package com.aurionpro.assignment.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<>();

//		products.add(new Product("Electronics", "Phone", 799.99));
//		products.add(new Product("Clothing", "T-Shirt", 19.99));
//		products.add(new Product("Electronics", "Laptop", 1299.00));
//		products.add(new Product("Clothing", "Jeans", 49.50));
//		products.add(new Product("Books", "Novel", 14.95));
//		products.add(new Product("Electronics", "Earbuds", 99.90));
		
		/* how many products? */
        int n;
        while (true) {
            try {
                System.out.print("How many products do you want to enter? ");
                n = scanner.nextInt();
                scanner.nextLine();   
                if (n <= 0) {
                    System.out.println("Enter a positive number.");
                    continue;
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Numbers only, please.");
                scanner.nextLine();
            }
        }

        /* input loop */
        for (int i = 1; i <= n; i++) {

            /* category */
            String category;
            while (true) {
                System.out.print("Enter category for product " + i + ": ");
                category = scanner.nextLine().trim();
                if (category.isEmpty()) {
                    System.out.println("Category cannot be empty.");
                } else {
                    break;
                }
            }

            /* name */
            String name;
            while (true) {
                System.out.print("Enter name for product " + i + ": ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                } else {
                    break;
                }
            }

            /* price */
            double price;
            while (true) {
                try {
                    System.out.print("Enter price for \"" + name + "\": ");
                    price = scanner.nextDouble();
                    scanner.nextLine();     
                    if (price <= 0) {
                        System.out.println("Price must be positive.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Price must be numeric.");
                    scanner.nextLine();
                }
            }

            products.add(new Product(category, name, price));
        }
        
		Comparator<Product> byCategoryThenPrice =
                new CategoryAscComparator().thenComparing(new PriceAscComparator());

        Collections.sort(products, byCategoryThenPrice);

		System.out.println("Products sorted by category and price:");
		System.out.println("------------------------------------------");
		for (Product p : products) {
			System.out.println(p);
		}
		
		scanner.close();
	}
}
