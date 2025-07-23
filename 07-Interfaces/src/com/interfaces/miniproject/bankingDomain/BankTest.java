package com.interfaces.miniproject.bankingDomain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		IAccountOperations[] accounts = { new SavingsAccount(), new CurrentAccount(), new LoanAccount() };

		while (true) {
			/* ----------- main menu ----------- */
			System.out.println("\nChoose Account Type:");
			System.out.println("1) Savings Account");
			System.out.println("2) Current Account");
			System.out.println("3) Loan Account");
			System.out.println("0) Exit");
			System.out.print("Your choice: ");

			int choice;
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Numbers only, please.");
				scanner.nextLine();
				continue;
			}

			if (choice == 0) {
				System.out.println("Session ended.");
				break;
			}
			if (choice < 1 || choice > 3) {
				System.out.println("Invalid option. Try again.");
				continue;
			}

			IAccountOperations acc = accounts[choice - 1];
			System.out.println("Account: " + acc.getClass().getSimpleName());

			try {
				/* ============ Savings & Current ============ */
				if (!(acc instanceof LoanAccount)) {

					double depositAmt = 0;
					/* ----- deposit loop ----- */
					while (true) {
						System.out.print("Deposit amount (multiples of 100/200/500/1000): ");
						try {
							depositAmt = scanner.nextDouble();
							if (depositAmt <= 0) {
								System.out.println("Amount must be positive.");
								continue;
							}
							/* ---- denomination check for deposit ---- */
							if (depositAmt % 100 != 0) {
								System.out.println("Amount must be in 100/200/500/1000 denominations only.");
								continue;
							}
							acc.deposit(depositAmt);
							break;
						} catch (InputMismatchException e) {
							System.out.println("Numbers only, please.");
							scanner.nextLine();
						}
					}

					/* ----- withdrawal loop ----- */
					while (true) {
						System.out
								.print("Withdrawal amount (multiples of 100/200/500/1000 and ≤ " + depositAmt + "): ");
						try {
							double withdrawAmt = scanner.nextDouble();
							if (withdrawAmt <= 0) {
								System.out.println("Amount must be positive.");
								continue;
							}
							if (withdrawAmt % 100 != 0) {
								System.out.println("Amount must be in 100/200/500/1000 denominations only.");
								continue;
							}
							if (withdrawAmt > depositAmt) {
								System.out.println("Withdrawal must not exceed the deposit.");
								continue;
							}
							acc.withdraw(withdrawAmt);
							break;
						} catch (InputMismatchException e) {
							System.out.println("Numbers only, please.");
							scanner.nextLine();
						}
					}
				}
				/* ================== Loan ================== */
				else {
					while (true) {
						System.out.print("Enter loan amount to borrow (multiples of 100/200/500/1000): ");
						try {
							double loanAmt = scanner.nextDouble();
							if (loanAmt <= 0) {
								System.out.println("Amount must be positive.");
								continue;
							}
							if (loanAmt % 100 != 0) {
								System.out.println("Amount must be in 100/200/500/1000 denominations only.");
								continue;
							}
							acc.withdraw(loanAmt); // treat withdraw as borrowing
							acc.checkBalance(); // show remaining loan balance
							break;
						} catch (InputMismatchException e) {
							System.out.println("Numbers only, please.");
							scanner.nextLine();
						}
					}
				}

			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}

			scanner.nextLine(); // clear newline left by nextDouble
			System.out.println("---------------------------");
		}

		scanner.close();
	}
}
