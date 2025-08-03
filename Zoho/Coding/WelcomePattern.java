
import java.util.*;
public class WelcomePattern {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String str = s.next();
      int n = str.length();
      
      int temp = n - 2;
      for(int i = 0; i <= n / 2; i++) {
        for(int j = 0; j < i; j++) {
          System.out.print(" ");
        }
        System.out.print(str.charAt(i));
        
        for(int j = 0; j < temp; j++) {
          System.out.print(" ");
        }
        
        temp -= 2;
        if(i != n / 2 ) System.out.print(str.charAt(i));
        
        for(int j = 0; j < i; j++) {
          System.out.print(" ");
        }
        System.out.println();
      } 
      
      temp = 1;
      for(int i = (n / 2) + 1; i < n; i++) {
        for(int j = 0; j < n - i - 1; j++) {
          System.out.print(" ");
        }
        System.out.print(str.charAt(i));
        
        for(int j = 0; j < temp; j++) {
          System.out.print(" ");
        }
        
        temp += 2;
        System.out.print(str.charAt(i));
        
        for(int j = 0; j < n - i - 1; j++) {
          System.out.print(" ");
        }
        System.out.println();
      }
      s.close();
    }
}