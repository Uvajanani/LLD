// Input 5
// Output
// 5 5 5 5 5 5 5 5 5  
// 5 4 4 4 4 4 4 4 5  
// 5 4 3 3 3 3 3 4 5  
// 5 4 3 2 2 2 3 4 5  
// 5 4 3 2 1 2 3 4 5  
// 5 4 3 2 2 2 3 4 5  
// 5 4 3 3 3 3 3 4 5  
// 5 4 4 4 4 4 4 4 5  
// 5 5 5 5 5 5 5 5 5  


import java.util.Scanner;
public class SpiralPattern {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      
      if(n == 1) {
        System.out.print(n);
        return;
      }
      
      int num = n - 1;
      for(int i = 0; i < 2 * n - 1; i++) {
        System.out.print(n + " ");
      }
      System.out.println();
      
      for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j <= i; j++) {
          System.out.print(n - j + " ");
        }
        
        for(int j = 0; j < 2 * num - 1; j++) {
          System.out.print(num + " ");
        }
        
        for(int j = i; j >= 0; j--) {
          System.out.print(n - j + " ");
        }
        
        num--;
        System.out.println();
      }
      
      num = 2;
      for(int i = 0; i < n - 2; i++) {
        for(int j = 0; j < n - i - 2; j++) {
          System.out.print(n - j + " ");
        }
        
        for(int j = 0; j < 2 * num - 1; j++) {
          System.out.print(num + " ");
        }
        
        for(int j = 0; j < n - i - 2; j++) {
          System.out.print(num + 1 + j + " ");
        }
        
        num++;
        System.out.println();
      }
      
      for(int i = 0; i < 2 * n - 1; i++) {
        System.out.print(n + " ");
      }
    }
}
