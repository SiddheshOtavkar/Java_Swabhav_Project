package com.aurionpro.prototype;

public class Demo {

	public static void main(String[] args) throws CloneNotSupportedException {
		// deep copy
		BookShop bs = new BookShop();
		bs.setShopName("Novelty");
		bs.loadData();

		System.out.println();

		BookShop bs1 = bs.clone();
		
		bs.getBooks().remove(2);
		System.out.println(bs + " \n");
		
		bs1.setShopName("A1");
		System.out.println(bs1);
		
	}

}
