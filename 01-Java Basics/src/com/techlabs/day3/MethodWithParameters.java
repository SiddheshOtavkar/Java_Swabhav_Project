package com.techlabs.day3;

public class MethodWithParameters {
	public static int add(int number1, int number2) {
		int sum = number1 + number2;
		return sum;
//		System.out.println("Sum is: " + sum);
	}

	public static void greet(String name) {
		System.out.println("Hello " + name);
	}

	public static void details(String name, int age, double salary) {
		System.out.println("My name is " + name + " and my age is " + age + " and my salary is " + salary);
	}

	public static void main(String[] args) {
		int result = add(10, 20);
		if(result == 30) {
			System.out.println("Output is correct!!");
		} else {
			System.out.println("Incorrect Output!!");
		}
		System.out.println("Sum of 2 numbers is: " + result);
		greet("Siddhesh");
		details("Rohit", 45, 55065.01);
	}
}
