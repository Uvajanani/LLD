
import java.util.*;
public class FreqSorting {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int[] nums = new int[n];
      
      for (int i = 0; i < n; i++) {
       nums[i] = s.nextInt();
      }
      
      Map<Integer, Integer> hash = new LinkedHashMap<>();
      for(int i = 0; i < n; i++) {
        hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
      }
      
      List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(hash.entrySet());
      sortedList.sort((a, b) -> b.getValue() - a.getValue());
      
      for(Map.Entry<Integer, Integer> entry : sortedList) {
        int freq = entry.getValue();
        for(int i = 0; i < freq; i++) {
          System.out.print(entry.getKey() + " ");
        }
      }
      s.close();
    }
}
