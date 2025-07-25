//package com.aurionpro.prototype;
//
//public class Demo2 {
//	public static void main(String[] args) throws CloneNotSupportedException {
//		// shallow cloning
//		BookShop obj1 = new BookShop();
//		obj1.setShopName("Novelty");
//		obj1.loadData();
//
//		BookShop obj2 = (BookShop) obj1.clone();
//
//		obj1.getBooks().remove(2);
//		System.out.println(obj1);
//		System.out.println();
//
//		obj2.setShopName("A1");
////		obj2.loadData(); --> now no need to load data again from database
//		System.out.println(obj2);
//	}
//}
//
////🔄 Shallow Clone:
////1 object (books list) is shared by 2 references (bs1 and bs2)
//
////🧬 Deep Clone:
////2 objects, and each has its own separate books list
