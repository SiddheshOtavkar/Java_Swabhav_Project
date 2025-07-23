package com.aurionpro.EnumStatic.assign;

public class MathUtil {
	public static int add(int a, int b) {
		return a + b;
	}

	public static int subtract(int a, int b) {
		return a - b;
	}

	public static int multiply(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {
		System.out.println(MathUtil.add(5, 3)); // 8
		System.out.println(MathUtil.subtract(5, 3)); // 2
		System.out.println(MathUtil.multiply(5, 3)); // 15
	}
}
