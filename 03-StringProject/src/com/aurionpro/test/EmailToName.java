package com.aurionpro.test;

import java.util.Scanner;

public class EmailToName {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input youremail Id we will generate username from your email ID for you!!");
		System.out.print("Enter your email: ");
		String email = scanner.nextLine();
		String userName = "";

		for (int i = 0; i < email.length(); i++) {
			if(email.charAt(i) == '@') {
				break;
			} else {
				userName += email.charAt(i);
			}
		}

		System.out.print("Your UserName is: " + userName);
		
		scanner.close();
	}
}
