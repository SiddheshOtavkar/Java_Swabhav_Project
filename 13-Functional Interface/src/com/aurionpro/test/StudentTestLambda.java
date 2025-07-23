package com.aurionpro.test;

import com.aurionpro.model.IScienceStudent;
import com.aurionpro.model.IStudent;

public class StudentTestLambda {
	public static void main(String[] args) {
		
//		IStudent std2 = (msg) -> {
//			return "Student";
//		};
		
		IStudent std = msg -> msg;
		System.out.println(std.sayHello("Siddhesh"));
		
		IScienceStudent sStd = () -> System.out.println("Grade B for Science Student");
		sStd.grade();
	}
}
