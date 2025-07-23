package com.aurionpro.test;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int x = 5;
//		System.out.println(++x + x++);
		System.out.println(x++ + ++x);
		int a = 3;
		int b = a-- - --a;
		System.out.println(b);
	}
}
