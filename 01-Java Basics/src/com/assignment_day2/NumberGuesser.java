package com.assignment_day2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String playAgain = "yes";

		while (playAgain.equalsIgnoreCase("yes")) {
			int randomNumber = random.nextInt(100) + 1;
			System.out.println("I have generated a number between 1 and 100.");
			int attempts = 0;

			System.out.println("Guess a number between 1 to 100.");

			while (true) {
				System.out.print("Enter a guess: ");
				int guess = scanner.nextInt();
				attempts++;

				if (guess == randomNumber) {
					System.out.println("You won in " + attempts + " attempts!!");
					break;
				} else if (guess < randomNumber) {
					System.out.println("Sorry, too low.");
					
					System.out.println("Do u want to end guessing? (yes/ no)");
					String endGuess = scanner.next();
					if (endGuess.equalsIgnoreCase("yes")) {
						break;
					} else {
						continue;
					}
				} else {
					System.out.println("Sorry, too high.");
					
					System.out.println("Do u want to end guessing? (yes/ no)");
					String endGuess = scanner.next();
					if (endGuess.equalsIgnoreCase("yes")) {
						break;
					} else {
						continue;
					}
				}
			}

			System.out.print("Do you want to play again? (yes/no): ");
			playAgain = scanner.next().toLowerCase();
		}

		System.out.println("Thanks for playing!");
		scanner.close();
	}
}
