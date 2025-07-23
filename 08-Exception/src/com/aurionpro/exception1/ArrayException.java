package com.aurionpro.exception1;

public class ArrayException {
	public static void main(String[] args) {
		
		// ArithmeticException
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
		
        // IndexOutOfBoundsException 
        int[] arr = new int[5];
		try {
			int value = arr[6];
			System.out.println("Value is: " + value);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Array Exception: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// NullPointerException
		try {
		    String name = null;
		    int len = name.length();      
		} catch (NullPointerException e) {
		    System.out.println("Caught NullPointerException: " + e);
		}
		
		// NumberFormatException
		try {
		    String priceText = "12.99$";          // not a pure number
		    double price = Double.parseDouble(priceText); 
		} catch (NumberFormatException e) {
		    System.out.println("Caught NumberFormatException: " + e);
		}
		
	}
}
