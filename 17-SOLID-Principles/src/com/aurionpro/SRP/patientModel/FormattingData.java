package com.aurionpro.SRP.patientModel;

public class FormattingData {
	
	public void format(Patient patient) {
		System.out.println("Complete Data of Patient is: ---------------------------");
		System.out.println("Patient's Name: " + patient.getName());
		System.out.println("Patient's Age: " + patient.getAge());
		System.out.println("Patient's Email: " + patient.getEmail());
		System.out.println("---------------------------------------------------------");
	}
	
}
