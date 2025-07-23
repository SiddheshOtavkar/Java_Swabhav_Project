package com.aurionpro.test;

public class StringBasic {
	public static void main(String[] args) {
//		String str1 = new String("ABC");
//		String str2 = new String("ABC");
//
//		System.out.println(str1 == str2);

		String str1 = "Hello";
		String str2 = "World";
		str1 = str1.concat(str2);
		System.out.println(str1);

		String reverse = "";
		for (int i = str1.length() - 1; i >= 0; i--) {
			reverse = reverse + str1.charAt(i);
		}
		
		System.out.println(reverse);
	}
}
