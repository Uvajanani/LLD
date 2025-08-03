// Create
//  ascending
//  a program that rearranges numbers in an array. It should sort even numbers
// sorted in descending
//  order but keep them in their original places. Odd numbers should be order, also staying in their initial positions.
// Example 1:
// Input: nums = [3, 4, 5, 1, 2]
// Output: nums = [5, 2, 3, 1, 4]
// They
// Explanation:
//  are sorted
//  In this example, we have even numbers [4, 2] located at positions [1, 4].
// odd numbers [3,
//  in ascending order and placed back in their original positions. The
// descending order
//  1,
//  while
//  5] are originally at positions [0, 2, 3], and they are arranged in maintaining their original positions.

import java.util.*;
public class RearrangeAscDesc  {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int[] arr = new int[n];
      
      for(int i = 0; i < n; i++) {
        arr[i] = s.nextInt();
      }
      
      List<Integer> evenIndices = new ArrayList<>();
      List<Integer> oddIndices = new ArrayList<>();
      List<Integer> even = new ArrayList<>();
      List<Integer> odd = new ArrayList<>();
      
      for(int i = 0; i < n; i++) {
        if(arr[i] % 2 == 0) {
          evenIndices.add(i);
          even.add(arr[i]);
        } else {
          oddIndices.add(i);
          odd.add(arr[i]);
        }
      }
      
      Collections.sort(even);
      Collections.sort(odd, Collections.reverseOrder());
      
      for(int i = 0; i < even.size(); i++) {
        arr[evenIndices.get(i)] = even.get(i);
      }
      
      for(int i = 0; i < odd.size(); i++) {
        arr[oddIndices.get(i)] = odd.get(i);
      }
      
      for(int num : arr) {
        System.out.print(num + " ");
      }
    }
}