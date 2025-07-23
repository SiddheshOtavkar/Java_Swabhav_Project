package com.aurionpro.EnumStatic;

class MathUtils {
	// static method
	public static int square(int n) { // belongs to MathUtils
		return n * n;
	}
}

public class StaticExample2 {
	public static void main(String[] args) {
		int result = MathUtils.square(5);
		System.out.println(result);
	}
}
