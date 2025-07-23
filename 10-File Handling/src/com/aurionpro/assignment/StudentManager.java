package com.aurionpro.assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
	File file = new File("students.txt");
	Scanner scanner = new Scanner(System.in);

	public void menu() {
		while (true) {
			try {
				System.out.println("\n1. Add  2. View  3. Search  4. Delete  5. Exit");
				System.out.print("Choice: ");
				int ch = scanner.nextInt();
				scanner.nextLine(); // clear newline

				switch (ch) {
				case 1:
					addStudent();
					break;

				case 2:
					viewAllStudents();
					break;

				case 3:
					searchStudentByRoll();
					break;

				case 4:
					deleteStudentByRoll();
					break;

				case 5:
					System.out.println("Bye!");
					return; // exit menu / program

				default:
					System.out.println("Invalid choice! Enter 1-5.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Numbers only, please.");
				scanner.nextLine();
			}
		}
	}

	private boolean isDuplicateRoll(int roll) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				// Each record starts with "roll," → quick string check
				if (line.startsWith(roll + ",")) {
					return true;
				}
			}
		} catch (Exception ignored) {
			System.out.println(ignored);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return false; // no duplicate found
	}

	/* ---------- ADD STUDENT ---------- */
	public void addStudent() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			// ----- Roll -----
			int roll = 0;
			while (true) {
				System.out.print("Enter Roll No (positive & unique): ");
				if (scanner.hasNextInt()) {
					roll = scanner.nextInt();
					if (roll > 0 && !isDuplicateRoll(roll))
						break;
				} else {
					scanner.next();
				}
				System.out.println("Roll no. must be positive and not already used.");
			}
			scanner.nextLine();

			// ----- Name -----
			String name = "";
			while (true) {
				try {
					System.out.print("Enter the name of student: ");
					name = scanner.nextLine().trim();

					if (name.isEmpty()) {
						throw new IllegalArgumentException("Name cannot be empty.");
					}
					if (!name.matches("[A-Za-z ]+")) { // letters & spaces only
						throw new IllegalArgumentException("Name must contain letters only.");
					}
					break; // valid
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input: " + e.getMessage());
				}
			}

			// Marks
			int marks = -1;

			while (true) {
				try {
					System.out.print("Enter Marks (0-100): ");
					marks = scanner.nextInt();

					if (marks < 0 || marks > 100) {
						throw new IllegalArgumentException("Marks must be between 0 and 100.");
					}
					break;

				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter an integer value.");
					scanner.next();

				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

			// Save
			Student student = new Student(roll, name, marks);

			FileWriter fw = null;
			try {
				fw = new FileWriter(file, true); // append
				fw.write(student.toFileFormat());
				fw.write(System.lineSeparator());
				System.out.println("Student added.");
			} finally {
				if (fw != null) {
					fw.close();
				}
			}
		} catch (IOException e) {
			System.out.println("File error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/* ---------- VIEW ALL STUDENT ---------- */
	public void viewAllStudents() {
		Scanner fs = null;
		try {
			fs = new Scanner(file); // open the file

			if (!fs.hasNextLine()) { // empty file
				System.out.println("(No records found)");
				return;
			}

			System.out.println("\nRoll | Name | Marks");
			System.out.println("--------------------");
			while (fs.hasNextLine()) {
				System.out.println(fs.nextLine());
			}

		} catch (IOException e) {
			System.out.println("File read error: " + e.getMessage());

		} finally {
			if (fs != null) {
				fs.close();
			}
		}
	}

	/* ---------- SEARCH BY ROLL NUMBER ---------- */
	public void searchStudentByRoll() {
		int rollNumberSearch;
		while (true) {
			try {
				System.out.print("Enter the roll number to search: ");
				rollNumberSearch = scanner.nextInt();

				if (rollNumberSearch <= 0) {
					throw new IllegalArgumentException("Roll number must be positive.");
				}

				scanner.nextLine();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Please enter digits only.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}

		Scanner fs = null;
		boolean found = false;

		try {
			fs = new Scanner(file); // open file

			while (fs.hasNextLine()) {
				String line = fs.nextLine();
				if (line.startsWith(rollNumberSearch + ",")) // roll matches
				{
					System.out.println("Record: " + line);
					found = true;
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("File read error: " + e.getMessage());

		} finally {
			if (fs != null) {
				fs.close(); // always close Scanner
			}
		}

		if (!found) {
			System.out.println("Roll not found.");
		}
	}

	/* ---------- DELETE BY ROLL ---------- */
	public void deleteStudentByRoll() {
		int rollNumberDelete;
		while (true) {
			try {
				System.out.print("Enter the roll number to elete: ");
				rollNumberDelete = scanner.nextInt();

				if (rollNumberDelete <= 0) {
					throw new IllegalArgumentException("Roll number must be positive.");
				}

				scanner.nextLine();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Please enter digits only.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean deleted = false;

		Scanner fs = null;
		try {
			fs = new Scanner(file);
			while (fs.hasNextLine()) {
				String line = fs.nextLine();
				if (line.startsWith(rollNumberDelete + ",")) {
					deleted = true; // skip this line
				} else {
					sb.append(line).append(System.lineSeparator());
				}
			}
		} catch (IOException e) {
			System.out.println("File read error: " + e.getMessage());
			return;
		} finally {
			if (fs != null)
				fs.close();
		}

		if (!deleted) {
			System.out.println("Roll not found.");
			return;
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter(file, false); // overwrite mode
			fw.write(sb.toString());
			System.out.println("Record deleted.");
		} catch (IOException e) {
			System.out.println("File write error: " + e.getMessage());
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing file writer.");
			}
		}
	}

	public static void main(String[] args) {
//        new StudentManager().menu();
		StudentManager sm = new StudentManager();
		sm.menu();
	}

}
