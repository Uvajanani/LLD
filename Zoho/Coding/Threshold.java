// Array with threshold value
//  Given an array and a threshold value nd the o/p
// i/p {5,8,10,13,6,2}
// threshold = 3
// o/p count = 17
// explanation:
// Number          parts               counts
// 5                {3,2}                2
// 8                {3,3,2}              3
// 10               {3,3,3,1}            4
// 13               {3,3,3,3,1}          5
// 6                {3,3}                2
// 2                {2}                  1


import java.util.*;
public class Threshold  {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int[] arr = new int[n];
      
      for(int i = 0; i < n; i++) {
        arr[i] = s.nextInt();
      }
      int threshold = s.nextInt();
      
      int cnt = 0;
      for(int i = 0; i < n; i++) {
        cnt += (arr[i] / threshold) + ((arr[i] % threshold == 0) ? 0 : 1);
      }
      System.out.print(cnt);
    }
}