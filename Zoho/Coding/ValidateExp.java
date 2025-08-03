// Q25. Evaluate mathematical expression
// Check whether a given mathematical expression is valid.
// Sample Input Sample Output
// (a+b)(c+d+e) VALID
// Sample Input Sample Output
// (a+b)(c+d) VALID
// Sample Input Sample Output
// (a+b)) INVALID



import java.util.*;
public class ValidateExp  {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.next();
      Stack<Character> s = new Stack<>();
  
      if(str.charAt(0) != '(') {
        System.out.print("INVALID");
        return;
      }
        
      for(int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if(ch == '(') {
          s.push(ch);
        } else if(ch == ')') {
          if(s.isEmpty()) {
            System.out.print("INVALID");
            return;
          }
          while(!s.isEmpty() && s.peek() != '(') {
            s.pop();
          }
          if (s.isEmpty()) {
              System.out.print("INVALID");
              return;
          }
          s.pop();
        } else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
          if((s.peek() >= 'a' && s.peek() <= 'z') || (s.peek() >= 'A' && s.peek() <= 'Z')) {
            System.out.print("INVALID");
            return;
          } else {
            s.push(ch);
          }
        } else {
          s.push(ch);
        }
      }
      
      if(s.isEmpty()) {
        System.out.print("VALID");
      } else {
        System.out.print("INVALID");
      }
    }
}