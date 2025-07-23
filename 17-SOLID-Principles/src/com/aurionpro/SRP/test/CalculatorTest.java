package com.aurionpro.SRP.test;

import java.util.Scanner;

import com.aurionpro.SRP.model.Addition;
import com.aurionpro.SRP.model.Calculator;
import com.aurionpro.SRP.model.Division;
import com.aurionpro.SRP.model.Multiplication;
import com.aurionpro.SRP.model.Subtraction;

public class CalculatorTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Calculator calculator = new Calculator();

		System.out.print("Enter number 1: ");
		int number1 = scanner.nextInt();

		System.out.print("Enter number 2: ");
		int number2 = scanner.nextInt();

		calculator.setNumber1(number1);
		calculator.setNumber2(number2);

		Addition addition = new Addition();
		addition.addNumber(number1, number2);

		Subtraction subtract = new Subtraction();
		subtract.subtractNumber(number1, number2);

		Multiplication multiplication = new Multiplication();
		multiplication.multiplyNumber(number1, number2);
		
		Division division = new Division();
		division.divideNumber(number1, number2);

		scanner.close();
	}

}
