package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Product product = new Product();

		System.out.print("Enter Product ID: ");
		product.setId(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Enter Product Name: ");
		product.setName(scanner.nextLine());

		System.out.print("Enter Product Price: ");
		product.setPrice(scanner.nextDouble());

		System.out.println("\n--- Product Details ---");
		System.out.println(product);

		scanner.close();
	}
}
