import java.util.*;

public class MagicalNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int k = s.nextInt();

        int i = 0;
        int j = n - 1;

        if(arr[0] > k) {
            System.out.println("No valid pair");
            return;
        }

        while(i < j) {
            if(arr[i] > k && arr[j] > k) {
                return;
            }

            if(arr[i] + arr[j] < k) {
                int t = i + 1;
                for(int ind = i; ind < j; ind++) {
                    System.out.println("(" + i + ", " + (t++) + ") ");
                }
                i++;
            } else {
                j--;
            }
        }
    }
}


// boolean flag = false;

        // for(int i = 0; i < n; i++) {
        //     for(int j = i + 1; j < n; j++) {
        //         if(arr[i] + arr[j] < k) {
        //             System.out.print("(" + i + ", " + j + ") ");
        //             flag = true;
        //         }
        //     }
        // }

        // if(!flag) {
        //     System.out.println("No valid pair");
        // }