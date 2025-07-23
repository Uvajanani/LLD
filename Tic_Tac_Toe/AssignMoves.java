package Tic_Tac_Toe;

public class AssignMoves extends Board {
    public static void move(char ch, String cell) {
        int row = cell.charAt(0) - 'A';
        int col = cell.charAt(1) - '1';

        if(row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid cell");
            return;
        }

        if(board[row][col] != '_') {
            System.out.println("Cell already occupied! Try a different move.");
            return;
        }
        board[row][col] = ch;
    }

    public static boolean validate(char player) {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }
}
