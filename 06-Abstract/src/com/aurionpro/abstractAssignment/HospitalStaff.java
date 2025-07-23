package com.aurionpro.abstractAssignment;

public abstract class HospitalStaff {
	public int staffId;
	public String name;
	public String department;
	
	public HospitalStaff(int staffId, String name, String department) {
		this.staffId = staffId;
		this.name = name;
		this.department = department;
	}

	public abstract void work();
	
	@Override
	public String toString() {
		return "HospitalStaff [staffId=" + staffId + ", name=" + name + ", department=" + department + "]";
	}
}
