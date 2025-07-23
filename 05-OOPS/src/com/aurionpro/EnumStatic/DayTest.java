package com.aurionpro.EnumStatic;

public class DayTest {

	public static void main(String[] args) {
		Day today = Day.MONDAY;

		System.out.println("Today is: " + today);

		switch (today) {
		case MONDAY:
			System.out.println("Start of the week.");
			break;
		case FRIDAY:
			System.out.println("Almost weekend!");
			break;
		case SUNDAY:
			System.out.println("Relax, it's Sunday.");
			break;
		}
		
		for(Day day : Day.values()) {
			System.out.println(day);
		}
	}
}
