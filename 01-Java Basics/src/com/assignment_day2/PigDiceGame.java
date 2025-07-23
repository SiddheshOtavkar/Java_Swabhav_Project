package com.assignment_day2;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int totalScore = 0;
		int turn = 0;

		System.out.println("Let's Play PIG!");
		System.out.println("* Try to reach 20 points in as few turns as possible.");
		System.out.println("* Roll a 1 and lose the turn's points!");
		System.out.println("* Hold to keep your turn's points.\n");

		while (totalScore < 20) {
			turn++;
			int turnScore = 0;
			System.out.println("TURN " + turn);

			while (true) {
				System.out.print("Roll or hold? (r/h): ");
				String choice = scanner.next().trim().toLowerCase();

				if (choice.equals("r")) {
					int die = random.nextInt(6) + 1;
					System.out.println("Die: " + die);

					if (die == 1) {
						System.out.println("Turn over. No score.\n");
						turnScore = 0;
						break;
					} else {
						turnScore += die;
					}
				} else if (choice.equals("h")) {
					totalScore += turnScore;
					System.out.println("Score for turn: " + turnScore);
					System.out.println("Total score: " + totalScore);
					break;
				} else {
					System.out.println("Invalid input. Enter 'r' to roll or 'h' to hold.");
				}
			}
		}

		System.out.println("You finished in " + turn + " turn(s)!");
		System.out.println("Game over!");
		scanner.close();
	}
}
