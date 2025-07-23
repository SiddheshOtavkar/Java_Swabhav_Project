package com.assignment_day2;

import java.util.Scanner;

public class TreasureIsland {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Treasure Island !! FInd the Treasure.");

		System.out.print("Select Left or Right: ");
		String choice = scanner.nextLine().toLowerCase();

		if (choice.equals("left")) {
			System.out.print("Select Swim or Wait: ");
			String answer = scanner.nextLine().toLowerCase();

			if (answer.equals("wait")) {
				System.out.print("Select the Door: Red, Blue, Yellow or Anything Else: ");
				String choosedDoor = scanner.nextLine().toLowerCase();

				switch (choosedDoor) {
				case "red":
					System.out.println("Burned by fire. Game Over!");
					break;
				case "blue":
					System.out.println("Eaten by beasts. Game Over!");
					break;
				case "yellow":
					System.out.println("YOU WIN!");
					break;
				default:
					System.out.println("Invalid door. Game Over!");
				}
			} else {
				System.out.println("You where attacked by trout, Game Over!!!");
			}
		} else {
			System.out.println("You fell into a hole. Game Over!");
		}
	}
}
