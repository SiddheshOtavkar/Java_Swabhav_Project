package com.techlabs.day3;

public class WrapperClassExample {
	public static void main(String[] args) {
		int number1 = 10;
		Integer numberObj1 = new Integer(number1); // boxing (Primitive to Object)
		Integer numberObjAuto1 = number1; // auto-boxing (Primitive to Object)

		System.out.println("Number 1 variable is: " + number1);
		System.out.println("Number 1 Object with boxing is: " + numberObj1);
		System.out.println("Number 1 Object with auto-boxing is: " + numberObjAuto1);

		System.out.println("----------------------------------------------------");
		
		int number2 = numberObj1.intValue(); // unboxing (Object to Primitive)
		int number3 = numberObj1; // auto-unboxing (Object to Primitive)
		System.out.println("Number 2 is: " + number2);
		System.out.println("Number 3 is: " + number3);
	}
}
