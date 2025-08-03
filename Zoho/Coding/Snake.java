// Input 5
// Output
//               1  2  3  4  5
//           10  9  8  7  6   
//        11 12 13 14 15      
//     20 19 18 17 16         
//  21 22 23 24 25   


import java.util.*;
public class Snake {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int num = 1;
      
      for(int i = 0; i < n ; i++) {
        for(int j = n - i - 1; j > 0; j--) {
          System.out.print("   ");
        }
        
        if(i % 2 == 0) {
          for(int j = 0; j < n; j++) {
            System.out.printf("%3d", num);
            num++;
          }
        } else {
          int temp = 1;
          for(int j = 0; j < n; j++) {
            System.out.printf("%3d", num + n - temp);
            num++;
            temp += 2;
          }
        }
        
        for(int j = 0; j < i; j++) {
          System.out.print("   ");
        }
        System.out.println();
      }
      s.close();
    }
}