package com.test;

import java.util.Scanner;

public class TicketBookingSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name of the customer: ");
		String name = scanner.nextLine();

		System.out.println("Choose ticket type: ");
		int i = 1;
		for (TicketType t : TicketType.values()) {
			System.out.println((i++) + ". " + t);
		}

		System.out.print("Enter your choice: (1,2,3): ");
		int choice = scanner.nextInt();
		scanner.nextLine();

		TicketType type;
		switch (choice) {
		case 1:
			type = TicketType.REGULAR;
			break;

		case 2:
			type = TicketType.VIP;
			break;

		case 3:
			type = TicketType.PREMIUM;
			break;

		default:
			type = TicketType.REGULAR;
			break;
		}

		System.out.print("Do you want to confirm the ticket: (yes/no): ");
		String decision = scanner.nextLine().trim().toLowerCase();

		BookingStatus status;
		switch (decision) {
		case "yes":
			status = BookingStatus.CONFIRMED;
			break;

		case "no":
			status = BookingStatus.CANCELLED;
			break;

		default:
			status = BookingStatus.PENDING;
			break;
		}
		
		Ticket ticket = new Ticket(name, type, status);
		ticket.display();

		scanner.close();
	}
}
