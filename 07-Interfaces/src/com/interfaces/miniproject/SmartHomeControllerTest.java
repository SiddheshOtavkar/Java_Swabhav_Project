package com.interfaces.miniproject;

import java.util.Scanner;

public class SmartHomeControllerTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		IControllable light = new Light();
		IControllable fan = new Fan();
		IControllable tv = new TV();
		IControllable speaker = new Speaker();

		while (true) {

			System.out.println("Choose a device:");
			System.out.println("1. Light");
			System.out.println("2. Fan");
			System.out.println("3. TV");
			System.out.println("4. Speaker");
			System.out.println("5. Exit");
			System.out.print("Choice: ");

			int choice;
			try {
				// read choice and validate numeric input
				choice = Integer.parseInt(scanner.nextLine().trim());

				if (choice == 5) {
					System.out.println("Exiting Smart Home Controller.");
					break;
				}
				if (choice < 1 || choice > 4) {
					throw new IllegalArgumentException("Choice must be a number from 1 to 5.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter digits only.");
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}

			// map choice to device and expected mode
			IControllable device = switch (choice) {
			case 1 -> light;
			case 2 -> fan;
			case 3 -> tv;
			case 4 -> speaker;
			default -> null; // already validated
			};

			String expectedMode = switch (choice) {
			case 1 -> "Dim";
			case 2 -> "High";
			case 3 -> "HD";
			case 4 -> "Bass";
			default -> "";
			};

			System.out.print(
					"Enter mode for " + device.getClass().getSimpleName() + " (allowed: " + expectedMode + "): ");
			String mode = scanner.nextLine().trim();

			try {
				if (!mode.equalsIgnoreCase(expectedMode)) {
					throw new IllegalArgumentException("Mode must be " + expectedMode + ".");
				}

				device.turnOn();
				device.setMode(mode);
				device.turnOff();
				System.out.println("Operation completed.\n");

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) { 
				System.out.println("Unexpected error: " + e.getMessage());
			}
		}

		scanner.close();
	}
}
