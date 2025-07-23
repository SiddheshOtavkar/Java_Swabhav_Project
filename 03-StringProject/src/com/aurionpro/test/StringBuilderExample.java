package com.aurionpro.test;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("Hello");
		StringBuilder sb2 = new StringBuilder("Hello");
//		sb.append("World");
//		System.out.println(sb);
		
		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2)); // it checks the has value of both
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());

		System.out.println(sb1.toString().equals(sb2.toString())); // learned something new
	}
}
