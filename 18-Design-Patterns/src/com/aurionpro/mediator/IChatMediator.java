package com.aurionpro.mediator;

// Mediator

public interface IChatMediator {
	void sendMessage(String message, User user);
	
	void addUser(User user);
}
