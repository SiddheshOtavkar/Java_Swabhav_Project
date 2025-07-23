package com.aurionpro.test.supplier;

import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<LocalTime> cuurentTime = () -> LocalTime.now();
		System.out.println(cuurentTime.get());
	}
}
