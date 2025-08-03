
// Brute Force Solution
// TC - O(n)
// SC - O(n)

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] amount = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        Map<Integer, Integer> hash = new HashMap<>();
        
        int i = 0;
        while(n != 0) {
            if(n >= amount[i]) {
                n -= amount[i];
                hash.put(amount[i], hash.getOrDefault(amount[i], 0) + 1);
            } else {
                i++;
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue());
            System.out.println();
        }
        s.close();
    }
}


// Optimal Solution 
// TC - O(1)
// SC - O(n)


public class MinimumNumberOfCurrencyNotes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] amount = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        int[] count = new int[9];
        
        for(int i = 0; i < 9; i++) {
            if(n >= amount[i]) {
                count[i] = n / amount[i];
                n %= amount[i];
            }
        }
        
        for(int i = 0; i < 9; i++) {
          if(count[i] != 0) {
              System.out.print(amount[i] + " - " + count[i]);
              System.out.println();
          }
        }
        s.close();
    }
}