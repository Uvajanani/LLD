import java.util.*;

public class ModifyMaxi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        Arrays.sort(nums, Collections.reverseOrder());

        int[] ans = new int[n];
        int left = 0, right = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans[left++] = nums[i];  
            } else {
                ans[right--] = nums[i]; 
            }
        }

        System.out.println(Arrays.toString(ans));
        s.close();
    }
}



// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// for (int num : arr) maxHeap.add(num);
