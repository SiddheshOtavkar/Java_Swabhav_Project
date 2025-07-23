package com.aurionpro.EnumStatic;

public class Ticket {
	private String customerName;
	private TicketType type;
	private BookingStatus status;

	public Ticket(String customerName, TicketType type, BookingStatus status) {
		this.customerName = customerName;
		this.type = type;
		this.status = status;
	}

	public void display() {
		System.out.println("----- Ticket Details -----");
		System.out.println("Customer Name : " + customerName);
		System.out.println("Ticket Type   : " + type);

		if (type == TicketType.REGULAR) {
			System.out.println("Ticket Price  : $1000");
		} else if (type == TicketType.VIP) {
			System.out.println("Ticket Price  : $3000");
		} else {
			System.out.println("Ticket Price  : $6000");
		}

		System.out.println("Booking Status: " + status);
		System.out.println("---------------------------");
	}
}
