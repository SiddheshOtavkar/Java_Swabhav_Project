package com.aurionpro.abstractAssignment;

import java.util.Scanner;

public class HospitalStaffTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many staff members do you want to enter? ");
		int staffCount = scanner.nextInt();
		scanner.nextLine();

		HospitalStaff[] staff = new HospitalStaff[staffCount];

		for (int i = 0; i < staffCount; i++) {
			System.out.println("\nEntering details for staff #" + (i + 1));

			System.out.print("Is this staff a Doctor (D) or Nurse (N)? ");
			char type = scanner.nextLine().trim().toUpperCase().charAt(0);

			System.out.print("Staff ID: ");
			int sId = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Name: ");
			String name = scanner.nextLine();

			System.out.print("Department: ");
			String dept = scanner.nextLine();

			if (type == 'D') {
				System.out.print("Specialization: ");
				String specialization = scanner.nextLine();

				System.out.print("How many patients assigned? ");
				int pCount = scanner.nextInt();
				scanner.nextLine();

				String[] patients = new String[pCount];
				for (int j = 0; j < pCount; j++) {
					System.out.print("Patient: " + (j + 1) + ": ");
					patients[j] = scanner.nextLine();
				}

				staff[i] = new Doctor(staffCount, name, dept, specialization, patients);
			} else if (type == 'N') {
				Shift shift;
				while (true) {
					System.out.println("Choose shift: 1-MORNING  2-EVENING  3-NIGHT");
					int choice = scanner.nextInt();

					switch (choice) {
					case 1:
						shift = Shift.MORNING;
						break;

					case 2:
						shift = Shift.EVENING;
						break;

					case 3:
						shift = Shift.NIGHT;
						break;

					default:
						System.out.println("Invalid choice!!!");
						continue;
					}
					break;
				}
				staff[i] = new Nurse(sId, name, dept, shift);
			} else {
				System.out.println("Unknown type—skipping this entry.");
				i--;
			}
		}

		for (HospitalStaff member : staff) {
			System.out.println("\n--- Staff Details ---");
			System.out.println(member); 
			member.work(); 
		}

		scanner.close();
	}

}
