package com.aurionpro.test;

import java.util.Scanner;

public class CountWordsInSentence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Sentence: ");
		String sentence = scanner.nextLine();

		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ') {
				count++;
			}
		}

		System.out.println("There are total " + (count + 1) + " in the sentence.");

		scanner.close();
	}
}
