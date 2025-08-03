//              1   
//            6 2   
//         10 7 3   
//      13 11 8 4   
//   15 14 12 9 5   



import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] matrix = new int[n][n];
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= n - i - 1; j--) {
                matrix[i][j] = num;
                num += j;
            }
            num = i + 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        s.close();
    }
}
