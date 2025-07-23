package com.assignment_day2;

import java.util.Random;
import java.util.Scanner;

public class RandomWord {
	public static void main(String[] args) {
		String[] words = { "javascript", "java", "python", "ruby", "php" };

		// Random selection
		Random random = new Random();
		String word = words[random.nextInt(words.length)];

		// Create blanks as letters
		char[] blanks = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			blanks[i] = '_';
		}

		int lives = 5;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Word-Guess game");

		while (lives > 0) {
			// Show current blanks
			System.out.print("Word: ");
			for (char blank : blanks) {
				System.out.print(blank + " ");
			}

			// Ask the user to guess a letter
			System.out.print("\nGuess a letter: ");
			char guess = scanner.next().toLowerCase().charAt(0);

			boolean found = false; // checking flag
			
			// Check and fill guessed letters
			for (int i = 0; i < word.length(); i++) {
				if(word.charAt(i) == guess) {
					blanks[i] = guess;
					found = true;
				}
			}
			
			if(found) {
				System.out.println("Correct");
			} else {
				lives--;
				System.out.println("Wrong!! One lives lost: " + lives);
			}
			
			// Check win
			if(String.valueOf(blanks).equals(word)) {
				System.out.println("You won! The word is: " + word);
			    break;
			}
			
			// Game over condition
			if(lives == 0) {
				System.err.println("Game word!!, The word was: " + word);
			}
		}
		scanner.close();
	}
}
