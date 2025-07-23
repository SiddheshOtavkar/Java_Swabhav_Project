package com.aurionpro.ISP2;

public class ExamServiceTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.startExam();
		
		System.out.println("-----------------------------------------------");
		ITeacher teacher = new Teacher();
		teacher.gradeExam();
		teacher.createQuestionBank();
		
		System.out.println("-----------------------------------------------");
		IExamCell admin = new Admin();
		admin.assignTeacher();
		System.out.println("-----------------------------------------------");
		
	}
}
