package com.aurionpro.stringbuilderAssignment;

import java.util.Scanner;

public class FindOccurrence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the sentence: ");
		String sentence = scanner.nextLine();

		System.out.print("Enter the word to count: ");
		String word = scanner.next();

		StringBuilder sb = new StringBuilder(sentence);
		int count = 0;
		int index = sb.indexOf(word);

		while (index != -1) {
			count++;
			index = sb.indexOf(word, index + word.length()); // search next occurrence 0 + 4
		}

		System.out.println("The word '" + word + "' appears " + count + " time.");
		
		scanner.close();
	}
}
