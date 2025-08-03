// Q15. Find a Sub string
//     Find if a String2 is substring of String1. If it is, return the index of the rst occurrence. else return -1.
// Sample Input 
// thistest123string
// 123
// Sample Output
// 8


import java.util.*;
public class Substring {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String str1 = s.next();
      String str2 = s.next();
      
      int i = 0, j = 0;
      while(i < str1.length()) {
        if(str1.charAt(i) == str2.charAt(j)) {
          int start = i;
          while(i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
          }
          
          if(j == str2.length()) {
            System.out.print(start);
            return;
          } else {
            j = 0;
          }
        }
        i++;
      }
      System.out.print("-1");
      s.close();
    }
}