package com.aurionpro.test;

import java.util.Scanner;

public class MonthSwitchCase {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number from 1 - 12");
		int month = scanner.nextInt();
		
		switch(month) {
		case 1:
			System.out.println("It is January and it has 31 days");
			break;
			
		case 2:
			System.out.println("It is February and it has 28/29 days");
			break;
			
		case 3:
			System.out.println("It is March and it has 31 days");
			break;
			
		case 4:
			System.out.println("It is April and it has 30 days");
			break;
			
		case 5:
			System.out.println("It is May and it has 31 days");
			break;
			
		case 6:
			System.out.println("It is June and it has 30 days");
			break;
			
		case 7:
			System.out.println("It is July and it has 31 days");
			break;
			
		case 8:
			System.out.println("It is August and it has 31 days");
			break;
			
		case 9:
			System.out.println("It is September and it has 30 days");
			break;
			
		case 10:
			System.out.println("It is October and it has 31 days");
			break;
			
		case 11:
			System.out.println("It is November and it has 30 days");
			break;
			
		case 12:
			System.out.println("It is December and it has 31 days");
			break;
			
		default:
			System.out.println("Enter a valid number");
		}	
		scanner.close();
	}
}
