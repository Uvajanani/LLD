import java.util.*;

public class PalindromicTrail {
    public static boolean palindrome(String str) {
        int n = str.length();
        for(int i = 0; i <= n / 2; i++) {
            if(str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder str = new StringBuilder();
    public static String palindromicTrail(List<String> ans, StringBuilder str, char[][] arr, int i, int j, int n, int m) {
        if(i >= n || j >= m) return "";
       
        str.append(arr[i][j]).append(palindromicTrail(ans, str, arr, i, j + 1, n, m)).append(palindromicTrail(ans, str, arr, i + 1, j, n, m)); 
    
        if(!ans.contains(str.toString())) {
           ans.add(str.toString());       
        }

        str.deleteCharAt(str.length() - 1);
        return "";
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.next().charAt(0);
            }
        }

        List<String> ans = new ArrayList<>();
        palindromicTrail(ans, str, arr, 0, 0, n, m);

        for(int i = 0; i < ans.size(); i++) {
            if(palindrome(ans.get(i)) && ans.get(i).length() == n + m - 1) {
                System.out.println(ans.get(i) + " ");
            }
        }
    }

}
