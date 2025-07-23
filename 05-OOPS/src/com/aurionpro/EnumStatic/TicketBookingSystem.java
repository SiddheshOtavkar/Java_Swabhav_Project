package com.aurionpro.EnumStatic;

import java.util.Scanner;

public class TicketBookingSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

//		System.out.println("\nChoose Ticket Type:");
//		int i = 0;
//		for (TicketType t : TicketType.values()) {
//			System.out.println(++i + ". " + t);
//		}
//
//		System.out.print("Enter choice (1-3): ");
//		int choice = scanner.nextInt();
//		scanner.nextLine();

		TicketType type = null;
		while (type == null) {
			System.out.println("\nChoose Ticket Type:");
			int i = 0;
			for (TicketType t : TicketType.values()) {
//				if(t == TicketType.PREMIUM) {
//					
//				}
				System.out.println(++i + ". " + t);
			}

			System.out.print("Enter choice (1-3): ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				type = TicketType.REGULAR;
			case 2:
				type = TicketType.VIP;
			case 3:
				type = TicketType.PREMIUM;
			default:
				System.out.println("Invalid choice — try again.");
			}
		}

//		System.out.println("\nConfirm Booking? (yes/no): ");
//		String decision = scanner.nextLine().trim().toUpperCase();

		// yes -> confirmed, no -> cancelled, maybe->pending

		BookingStatus status = BookingStatus.PENDING;
		while (status == BookingStatus.PENDING) {
			System.out.print("\nConfirm Booking? (yes / no): ");
			String decision = scanner.nextLine().trim().toLowerCase();

			switch (decision) {
			case "yes":
				status = BookingStatus.CONFIRMED;
			case "no":
				status = BookingStatus.CANCELLED;
			default:
				System.out.println("Status remains PENDING, start over.");
			}

			// If still PENDING, restart the outer loop
			if (status == BookingStatus.PENDING) {
				continue;
			}
		}

		Ticket ticket = new Ticket(name, type, status);
		ticket.display();

		scanner.close();
	}
}
