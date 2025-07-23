package com.aurionpro.prototype;

public class DemoNormal {
	public static void main(String[] args) {
		// with 2 objects fetching from DataBase
		
		BookShop obj1 = new BookShop();
		obj1.setShopName("Novelty");
		obj1.loadData();
		System.out.println(obj1);
		
		System.out.println();

		BookShop obj2 = new BookShop();
		obj2.setShopName("A1");
		obj2.loadData(); // again loading data from database --> It consumes time.
		System.out.println(obj2);
	}
}
