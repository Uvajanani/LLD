
// Optimal Solution
// Use even list to store even numbers and odd list to store odd numbers.
// Sort odd numbers in descending order and even numbers in ascending order.
// Put odd numbers first in the original array followed by even numbers.
// TC - O(n log n)
// SC - O(n)


import java.util.*;
public class SortInSpecificOrder {
    public void sortIt(Long arr[]) {
        List<Long> odd = new ArrayList<>();
        List<Long> even = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }
        
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);
        
        for(int i = 0; i < odd.size(); i++) {
            arr[i] = odd.get(i); 
        }
        
        for(int i = 0; i < even.size(); i++) {
            arr[i + odd.size()] = even.get(i);
        }
    }
}
