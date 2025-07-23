package com.aurionpro.SRP.patientTest;

import java.util.Scanner;

import com.aurionpro.SRP.patientModel.EmailNotifier;
import com.aurionpro.SRP.patientModel.FormattingData;
import com.aurionpro.SRP.patientModel.Patient;
import com.aurionpro.SRP.patientModel.StorePatientData;

public class PatientTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Patient patient = new Patient("Rohan Negi", 23, "rohan123@gmail.com");
		
		StorePatientData data = new StorePatientData();
		data.storeData(patient);
		
		EmailNotifier notifier = new EmailNotifier();
		System.out.println();
		notifier.sendEmail(patient, "Your appointment is confirmed for tomorrow.");
		
		FormattingData format = new FormattingData();
		System.out.println();
		format.format(patient);

		scanner.close();
	}

}
