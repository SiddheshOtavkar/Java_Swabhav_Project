package com.fooddelivery.customer;

public class CustomerInformation {

	public String name, address;
	private int customerId;
	private double phoneNumber;

	private static int customerIdSetter = 0;

	public CustomerInformation(String name, double phoneNumber, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		customerId = ++customerIdSetter;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerInformation [name=" + name + ", address=" + address + ", customerId=" + customerId
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
