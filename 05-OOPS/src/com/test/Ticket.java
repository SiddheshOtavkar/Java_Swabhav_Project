package com.test;

public class Ticket {
	public String name;
	public TicketType type;
	public BookingStatus status;

	public Ticket(String name, TicketType type, BookingStatus status) {
		this.name = name;
		this.type = type;
		this.status = status;
	}

	public void display() {
		System.out.println("-----------------Ticket Details: ----------------------");
		System.out.println("Customer Name: " + name);
		System.out.println("Ticket Type: " + type);
		
		if(type == TicketType.REGULAR) {
			System.out.println("Ticket Price: $100");
		} else if(type == TicketType.VIP) {
			System.out.println("Ticket Price: $500");
		} else {
			System.out.println("Ticket Price: $1000");
		}
		
		System.out.println("Booking Status: " + status);
		System.out.println("-------------------------------------------------------");
	}
}
