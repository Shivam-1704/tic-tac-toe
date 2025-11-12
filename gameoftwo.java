/*
 2-player Tic Tac Toe game. Players enter their names, take turns, and at the end,
 the game announces who won or if it's a draw.
*/

import java.util.Scanner;

public class gameoftwo{

    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take player names
        System.out.print("Enter name for Player 1 (X): ");
        String player1 = sc.nextLine();
        System.out.print("Enter name for Player 2 (O): ");
        String player2 = sc.nextLine();

        initializeBoard();

        char currentPlayer = 'X';
        String currentName = player1;
        boolean gameWon = false;

        System.out.println("\n=== Welcome to Tic Tac Toe ===");
        printBoard();

        for (int turn = 0; turn < SIZE * SIZE; turn++) {
            System.out.println("\n" + currentName + "'s turn (" + currentPlayer + ")");
            
            int row, col;
            while (true) {
                System.out.print("Enter row (1-3): ");
                row = sc.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                col = sc.nextInt() - 1;

                if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("\n🎉 " + currentName + " wins the game!");
                gameWon = true;
                break;
            }

            // Switch player
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
                currentName = player2;
            } else {
                currentPlayer = 'X';
                currentName = player1;
            }
        }

        if (!gameWon) {
            System.out.println("\nIt's a draw! 🤝");
        }

        sc.close();
    }

    // Initialize empty board
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print board
    private static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check win condition
    private static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
