
// Optimal Solution
// First print spaces for the left side, then print stars and space
// Repeat for lower half of the diamond as well.
// TC - O(n^2)
// SC - O(1)


public class Pattern {
    void printDiamond(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = n - i - 1; j > 0; j--) {
                System.out.print(" ");
            } 
            for(int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            
            System.out.print("*");
            System.out.println();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(" ");
            } for(int j = n - i - 1; j > 0; j--) {
                System.out.print("* ");
            }
            
            System.out.print("*");
            System.out.println();
        }
    }
}
