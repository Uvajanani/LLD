package Tic_Tac_Toe;

public class Board {
    static char[][] board = new char[3][3];
    public static void initializeBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    public static void displayBoard() {
        System.err.println("   1   2   3");
        System.out.println("A  " + board[0][0] + " | " + board[0][1]  + " | " + board[0][2]);
        System.out.println("B  " + board[1][0] + " | " + board[1][1]  + " | " + board[1][2]);
        System.out.println("C  " + board[2][0] + " | " + board[2][1]  + " | " + board[2][2]);
    }
}
