package com.aurionpro.abstractAssignment;

public class Doctor extends HospitalStaff {

	public String specialization;
	public String[] patients;

	public Doctor(int staffId, String name, String department, String specialization, String[] patients) {
		super(staffId, name, department);
		this.specialization = specialization;
		this.patients = patients;
	}

	@Override
	public void work() {
		System.out.println(name + " is diagnosing and treating patients.");
	}

	@Override
	public String toString() {
		StringBuilder patientList = new StringBuilder();
		for (String patient : patients) {
			patientList.append(patient).append(", ");
		}

		return super.toString() + "\nSpecialization: " + specialization + "\nPatients: "
				+ patientList.toString().trim();
	}
}
