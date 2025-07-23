package com.techlabs.pratice.exception;

public class MultipleCatchDemo {
	public static void main(String[] args) {

		try {
			String[] names = new String[2];

			System.out.println("Accessing 5th element:");
			System.out.println(names[4]);

			String nullStr = null;
			System.out.println("Length: " + nullStr.length());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Array index is out of bounds.");
		} catch (NullPointerException e) {
			System.out.println("Error: Cannot access methods on a null object.");
		}

		System.out.println("Program continues after handling exceptions.");
	}
}
