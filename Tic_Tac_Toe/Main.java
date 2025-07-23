package Tic_Tac_Toe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");

        while(true) {
            System.out.print("Player 1 (X), Enter your Name : ");
            String player1 = s.nextLine();

            System.out.print("\nPlayer 2 (O), Enter your Name : ");
            String player2 = s.nextLine();

            int turn = 0;
            Board.initializeBoard();

            System.out.println("Initial Board : ");
            Board.displayBoard();

            while (true) {
                if (turn % 2 == 0) {
                    System.out.println(player1 + " (X), Enter your move (e.g., A1, B3) : ");
                    String cell = s.next();
                    AssignMoves.move('X', cell);
                    Board.displayBoard();

                    if (AssignMoves.validate('X')) {
                        System.out.println("Congratulations ! " + player1 + " You wins!");
                        break;
                    }

                } else {
                    System.out.println(player2 + " (O), Enter your move (e.g., A1, B3) : ");
                    String cell = s.next();
                    AssignMoves.move('O', cell);
                    Board.displayBoard();

                    if (AssignMoves.validate('O')) {
                        System.out.println("Congratulations ! " + player2 + " You wins!");
                        break;
                    }
                }
                
                if(turn == 8) {
                    System.out.println("It's a draw!");
                    break;
                }
                turn++;
            }

            System.out.println("Do you want to play again? (yes/no): ");
            String play = s.next();
            if (play.equalsIgnoreCase("no")) {
                System.out.println("Thank you for playing!");
                return;
            }
        }
    }
}
