package LLD;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Box Size (row * column) : ");
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println();

        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = '-';
            }
        }

        while(true) {
            System.out.print("Drop Position(column) : ");
            int position = s.nextInt();
            System.out.print("\nBall Color : ");
            String colour = s.next();

            System.out.println("Contents of the box before bursting: ");
            Place.placeInPosition(board, colour, position - 1);
            Place.display(board, n, m);
            
            System.out.println("Contents of the box after bursting: ");
            Place.burst(board);
            Place.display(board, n, m);

            System.out.println("Filling down: ");
            Place.fillingDown(board, n, m);
            Place.display(board, n, m);

            System.out.println("Do you wish to continue (Y/N)? ");
            char ch = s.next().charAt(0);
            if(ch == 'N') {
                break;
            } 
        }
    }
}
