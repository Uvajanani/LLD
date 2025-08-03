
// Brute Force Solution
// For every i run a loop from j -> i + k and find maxi
// Add the maxi to the list
// TC - O(n * k)
// SC - O(1)

import java.util.*;
public class MaximumInSubarray {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= arr.length - k; i++) {
            int maxi = 0;
            for(int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, arr[j]);
            }
            ans.add(maxi);
        }
        return ans;
    }
}


// Optimal Solution
// Use arrayDeque which adds and removes elements in both ends
// First remove the element which exceeds the window size
// Then remove the last element if it is smaller than cur element
// Add cur index to the deque
// Add the maxi which is present at the first element in the deque to ans
// TC - O(n)
// SC - O(k)


class Solution {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < arr.length; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
            
            if(i >= k - 1) {
                ans.add(arr[dq.peekFirst()]);
            }
        }
        return ans;
    }
}
