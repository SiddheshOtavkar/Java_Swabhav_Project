package com.aurionpro.SRP.patientModel;

public class EmailNotifier {

	public void sendEmail(Patient patient, String message) {

		System.out.println("Sending email to: " + patient.getEmail());
		System.out.println("Message: " + message);

	}

}
