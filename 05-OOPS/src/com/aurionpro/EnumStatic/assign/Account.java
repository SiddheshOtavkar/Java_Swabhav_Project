package com.aurionpro.EnumStatic.assign;

public class Account {
	private int accountNumber;
	public static String bankName;

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void show() {
		System.out.println("Acc No: " + accountNumber + ", Bank: " + bankName);
	}

	public static void main(String[] args) {
		Account.bankName = "Axis Bank";

		Account a1 = new Account(1);
		Account a2 = new Account(2);

		a1.show();
		a2.show();

		Account.bankName = "ICICI Bank";

		a1.show();
		a2.show();
	}
}
