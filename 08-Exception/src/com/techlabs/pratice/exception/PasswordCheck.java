package com.techlabs.pratice.exception;

//Custom exception class
class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String message) {
		super(message);
	}
}

public class PasswordCheck {

	public static void checkPassword(String password) throws InvalidPasswordException {
		if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters and contain a number.");
        }
        System.out.println("Password is valid.");
	}

	public static void main(String[] args) {
		String password = "abcde";

		try {
            checkPassword(password);
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
        }

		System.out.println("Program ended.");
	}
}
