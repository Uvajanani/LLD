// Q16. Merge two sorted arrays without duplication
// Output is a merged array without duplicates

// Sample Input 
// 5
// 1 2 3 6 9
// 4
// 2 4 5 10

// Sample Output
// 1 2 3 4 5 6 9 10



import java.util.*;
public class MergeSortedWithoutDuplicates {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int n = s.nextInt();
      int[] nums1 = new int[n];
      for(int i = 0; i < n; i++) {
        nums1[i] = s.nextInt();
      }
      
      int m = s.nextInt();
      int[] nums2 = new int[m];
      for(int i = 0; i < m; i++) {
        nums2[i] = s.nextInt();
      }
      
      List<Integer> ans = new ArrayList<>();
      int i = 0, j = 0;
      while(i < n && j < m) {
        if(nums1[i] < nums2[j]) {
          if(ans.size() == 0 || ans.get(ans.size() - 1) != nums1[i]) {
            ans.add(nums1[i]);
          }
          i++;
        } else {
            if(ans.size() == 0 || ans.get(ans.size() - 1) != nums2[j]) {
              ans.add(nums2[j]);
          }
          j++;
        }
      }
      
      for(i = 0; i < ans.size(); i++) {
        System.out.print(ans.get(i) + " ");
      }
      s.close();
    }
}