import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if(n < 0) {
            System.out.println("Validation failed. The given number is not a non-negative number");
        }

        int ans = 0;
        for(int i = 1; i <= n / 2; i++) {
            if(i * i <= n) {
                ans = i;
            }
        }
        System.out.println(ans);

        int low = 1;
        int high = n;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(mid * mid == n) {
                System.out.println(mid);
                return;
            } else if(mid * mid < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print(high);
    }
}
