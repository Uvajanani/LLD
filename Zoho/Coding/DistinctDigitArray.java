
// Optimal Solution
// Get every digit of each number and store it in a set to ensure distinct digits.
// Finally, convert the set to an array and return it.
// TC - O(n * d) where d is the number of digits across all numbers.
// SC - O(l) where l is the maximum number of distinct digits across all numbers.


import java.util.*;
public class DistinctDigitArray {
    public void digit(int n, Set<Integer> s) {
        while(n != 0) {
            s.add(n % 10);
            n /= 10;
        }    
    }
    
    public int[] common_digits(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            digit(nums[i], s);
        }
        
        int[] ans = new int[s.size()];
        int ind = 0;
        
        for(int i : s) {
            ans[ind++] = i;
        }
        return ans;
    }
}
