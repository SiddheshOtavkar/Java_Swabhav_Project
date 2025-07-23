package com.aurionpro.mediator;

// Concrete Colleague

public class ChatUser extends User {
	
	public ChatUser(IChatMediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String message) {
		System.out.println(name + " sends: " + message);
		mediator.sendMessage(message, this);
	}

	@Override
	public void receive(String message) {
		System.out.println(name + " receives: " + message);
	}
	
}
