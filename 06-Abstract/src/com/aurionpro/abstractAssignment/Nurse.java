package com.aurionpro.abstractAssignment;

public class Nurse extends HospitalStaff {

	public Shift shift;

	public Nurse(int staffId, String name, String department, Shift shift) {
		super(staffId, name, department);
		this.shift = shift;
	}

	@Override
	public void work() {
		System.out.println(name + " is monitoring vital signs and assisting doctors in the " + shift + " shift.");
	}

	@Override
	public String toString() {
		return super.toString() + "\nShift: " + shift;
	}
}
