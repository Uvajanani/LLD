package LLD;

public class Place {

    public static void placeInPosition(char[][] board, String colour, int position) {
        int n = board.length;
        int m = board[0].length;
        int i = n - 1;       

        for(int ind = 0; ind < colour.length(); ind++) {
            if(position >= m) {
                position = 0;
            }
            
            for(i = n - 1; i >= 0; i--) {
                if(board[i][position] == '-') {
                    break;
                }
            }

            if(i < 0) {
                i = 0;
                position++;
            }

            if(position >= m) {
                position = 0;
            }

            if(i >= 0 && board[i][position] == '-') {
                board[i][position] = colour.charAt(ind);
                position++;
            } 
        }
    }

    public static void display(char[][] board, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void burst(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int cnt = 0;
                if(board[i][j] != '-') {
                    for(int k = 0; k < m; k++) {
                        if(board[i][j] == board[i][k]) {
                            cnt++;
                        }
                    }
                }

                if(cnt == 3) {
                    fill(board, i, board[i][j]);
                }
            }
            
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                if(board[j][i] != '-') {
                    for(int k = 0; k < m; k++) {
                        if(board[j][i] == board[k][i]) {
                            cnt++;
                        }
                    }
                }
                if(cnt == 3) {
                    fillCol(board, i, board[j][i]);
                }
            }
        }        
    }

    public static void fill(char[][] board, int i, char ch) {
        for(int ind = 0; ind < board.length; ind++) {
            if(board[i][ind] == ch) {
                board[i][ind] = '-';
            }
        }
    }

    public static void fillCol(char[][] board, int i, char ch) {
        for(int ind = 0; ind < board.length; ind++) {
            if(board[ind][i] == ch) {
                board[ind][i] = '-';
            }
        }
    }

    public static void fillingDown(char[][] board, int n, int m) {
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != '-' && board[i + 1][j] == '-') {
                    board[i + 1][j] = board[i][j];
                    board[i][j] = '-';
                }
            }
        }
    }
}
