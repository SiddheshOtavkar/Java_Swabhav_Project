package com.aurionpro.test;

import java.util.Scanner;

public class LongestWordInSentence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Sentence: ");
		String sentence = scanner.nextLine();

		String[] words = sentence.split(" ");
		int longest = words[0].length();
		String result = "";

		for (int i = 1; i < words.length; i++) {
			if (words[i].length() > longest) {
				longest = words[i].length();
				result = words[i];
			}
		}
		
//		String[] words = sentence.split(" "); 
//		String longestWord = "";
//		for (String word : words) {
//			if (word.length() > longestWord.length()) {
//				longestWord = word;
//			}
//		}
		
		System.out.println("The longest word is: " + result);
		System.out.println("Length of the word: " + result.length());

		scanner.close();
	}
}
