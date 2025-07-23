package com.aurionpro.test.function;

import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		Function<Integer, String> toString = i -> String.valueOf(i);
		
		String result = toString.apply(123);   // "123"
        System.out.println("Converted value = " + result);
	}
}
