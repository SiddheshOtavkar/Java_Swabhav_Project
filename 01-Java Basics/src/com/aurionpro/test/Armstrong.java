package com.aurionpro.test;

public class Armstrong {
	public static void main(String[] args) {
		int number = 153;
        int originalNumber = number;
        int result = 0;

        int temp = number;
        int digits = 0;
        while (temp > 0) {
            temp = temp / 10;
            digits++;
        }

        while (number != 0) {
            int lastNumber = number % 10;
            result += Math.pow(lastNumber, digits);
            number /= 10;
        }
        
        if (result == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
	}
}
