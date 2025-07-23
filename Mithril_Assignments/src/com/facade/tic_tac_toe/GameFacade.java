package com.facade.tic_tac_toe;

import java.util.Scanner;

public class GameFacade {
	private final Scanner scanner;
	private final Board board;
	private final Player player1;
	private final Player player2;
	private final GameEngine engine;

	public GameFacade() {
		scanner = new Scanner(System.in);
		board = new Board();

		System.out.println("Welcome to Tic Tac Toe!");
		
		String name1 = readValidName("Player 1");
		String name2 = readValidName("Player 2");

		player1 = new Player(name1, Symbol.X);
		player2 = new Player(name2, Symbol.O);
		engine = new GameEngine(player1, player2, board);
	}

	// Validate player names (letters only)
	private String readValidName(String playerPrompt) {
		String name;
		while (true) {
			System.out.print(playerPrompt + ", enter your name: ");
			name = scanner.nextLine().trim();
			if (name.matches("[a-zA-Z]+")) {
				break;
			} else {
				System.out.println("Invalid name. Please enter only letters (no numbers or symbols).");
			}
		}
		return name;
	}

	public void startGame() {
		board.displayBoard();
		GameStatus status = GameStatus.IN_PROGRESS;

		while (status == GameStatus.IN_PROGRESS) {
			Player currentPlayer = engine.getCurrentPlayer();
			System.out.print(currentPlayer.getName() + "'s (" + currentPlayer.getSymbol() + ") turn. Enter row and column (0-2): ");
			
			int row, col;
			try {
				row = scanner.nextInt();
				col = scanner.nextInt();

				scanner.nextLine(); 
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter numeric values only.");
				scanner.nextLine(); // clear invalid input
				continue;
			}

			status = engine.playTurn(row, col);
		}

		if (status == GameStatus.WIN) {
			System.out.println("Result: " + engine.getCurrentPlayer().getName() + " wins! Congratulations!");
		} else if (status == GameStatus.DRAW) {
			System.out.println("Result: It's a draw!");
		}
	}
}
