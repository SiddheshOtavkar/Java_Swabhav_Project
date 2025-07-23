package com.interfaces.miniproject.examSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExamTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IExamEvaluator[] exams = {
            new TheoryExam(),
            new PracticalExam(),
            new OnlineQuiz()
        };

        while (true) {
            System.out.println("\nChoose Exam:");
            System.out.println("1) Theory");
            System.out.println("2) Practical");
            System.out.println("3) Online Quiz");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Numbers only, please.");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) break;
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            IExamEvaluator exam = exams[choice - 1];
            String examName = exam.getClass().getSimpleName();

            while (true) {
                try {
                    System.out.print("Enter marks for " + examName + " (0-100): ");
                    int marks = scanner.nextInt();
                    if (marks < 0 || marks > 100)
                        throw new IllegalArgumentException("Marks must be between 0 and 100.");

                    exam.setMarks(marks);
                    exam.evaluateMarks();
                    exam.calculateGrade();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: numbers only.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("----------------------");
        }
        System.out.println("All evaluations complete.");
        scanner.close();
    }
}
