
// Sample Input - Sample Output
// ((abc)((de)) - (abc)((de))
// Sample Input - Sample Output
// (((ab)       - (ab)


import java.util.Scanner;
import java.util.Stack;

public class RemoveUnbalancedParanthesis {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.next();
      
      Stack<Integer> s = new Stack<>();
      boolean[] valid = new boolean[str.length()];
      
      for(int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if(ch == '(') {
          s.push(i);
        } else if(ch == ')') {
          if(!s.isEmpty()) {
            valid[s.pop()] = true;
            valid[i] = true;
          }
        } else {
          valid[i] = true;
        }
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < valid.length; i++) {
        if(valid[i]) {
          sb.append(str.charAt(i));
        }
      }
      System.out.print(sb.toString());
    }
}
