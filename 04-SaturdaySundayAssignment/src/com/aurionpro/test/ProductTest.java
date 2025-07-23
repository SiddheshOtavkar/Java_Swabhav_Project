package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of products: ");
		int size = scanner.nextInt();
		scanner.nextLine();
		
		Product[] products = new Product[size];
		
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the name of product: ");
			String name = scanner.nextLine();
			
			System.out.print("Enter the price of product: ");
			double price = scanner.nextDouble();
			scanner.nextLine();
			
			products[i] = new Product(name, price);
			System.out.println();
		}
		
		for(Product product : products) {
			if(product.price < 1000) {
				product.display();
			}
		}

		scanner.close();
	}
}
