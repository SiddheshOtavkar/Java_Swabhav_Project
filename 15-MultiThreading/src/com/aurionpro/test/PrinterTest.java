package com.aurionpro.test;

import com.aurionpro.model.PrinterModel;

public class PrinterTest {
	public static void main(String[] args) {
		PrinterModel sharedPrinter = new PrinterModel();
		
		Runnable r1 = () -> sharedPrinter.print("Report.pdf");
		Runnable r2 = () -> sharedPrinter.print("Invoice.pdf");
		
		new Thread(r1, "Siddhesh").start();
		new Thread(r2, "Aman").start();
	}
}
