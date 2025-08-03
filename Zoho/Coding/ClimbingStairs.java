
import java.util.*;
public class ClimbingStairs {
    public static int f(int n) {
      if(n < 0) return 0;
      else if(n == 0) return 1;
      return f(n - 1) + f(n - 2);
    }
  
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      System.out.print(f(n));
    }
}
