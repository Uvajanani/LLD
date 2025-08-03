import java.util.Scanner;

public class SubstringMismatch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();

        // List<String> ans = new ArrayList<>();
        int i = 0, j = 0;
        int ind1 = 0, ind2 = 0;

        while (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);

            if (c1 != c2) {
                ind1 = i;
                ind2 = j;

                while (i < s1.length() && j < s2.length() && c1 != c2) {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(j);
                    i++;
                    j++;
                }

                System.out.print(s1.substring(ind1, i) + ", ");
                System.out.print(s2.substring(ind2, j));
                System.out.println();
            }
            i++;
            j++;
        }

        // for(i = 0; i < ans.size(); i++) {
        // System.out.print(ans.get(i) + " ");
        // }
        s.close();
    }
}
