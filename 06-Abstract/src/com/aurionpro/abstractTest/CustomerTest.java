package com.aurionpro.abstractTest;

public class CustomerTest {

	public static void main(String[] args) {
		CommericalCustomer cc = new CommericalCustomer();
		cc.calculateBill(6.0);
		
		cc.display();
		
		ResidentalCustomer rc = new ResidentalCustomer();
		rc.calculateBill(7.0);
		
		rc.display();
	}

}
