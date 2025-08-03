
// Optimal Solution 1
// Calculate the binary equivalent of each hexadecimal digit and store it in a map.
// Iterate through the hexadecimal string and append the corresponding binary values using map.
// TC - O(n)
// SC - O(16) + O(n)

import java.util.*;
public class HexadecimalToBinary {    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String hex = s.next().toUpperCase();
        
        Map<Character, String> hash = new HashMap<>();
        hash.put('1', "0001");
        hash.put('2', "0010");
        hash.put('3', "0011");
        hash.put('4', "0100");
        hash.put('5', "0101");
        hash.put('6', "0110");
        hash.put('7', "0111");
        hash.put('8', "1000");
        hash.put('9', "1001");
        hash.put('A', "1010");
        hash.put('B', "1011");
        hash.put('C', "1100");
        hash.put('D', "1101");
        hash.put('E', "1110");
        hash.put('F', "1111");
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < hex.length(); i++) {
          sb.append(hash.get(hex.charAt(i)));
        }
        System.out.print(sb.toString());
        s.close();
    }
}


// Optimal Solution 2
// Convert each hexadecimal character to string and then convert it into equialvalent decimal value.
// Finally, convert the decimal value to binary and format it to 4 bits. Replace spaces with '0' at the end.
// TC - O(n)
// SC - O(n)

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String hex = s.next();
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < hex.length(); i++) {
          int value = Integer.parseInt(String.valueOf(hex.charAt(i)), 16);
          sb.append(String.format("%4s", Integer.toBinaryString(value)).replace(' ', '0'));
        }
        System.out.print(sb.toString());
        s.close();
    }
}


// Important Note

// String.valueOf(char) is used to convert a character to a string.

// int x = 10;
// String s1 = String.valueOf(x);       // "10"

// char c = 'A';
// String s2 = String.valueOf(c);       // "A"

// boolean flag = true;
// String s3 = String.valueOf(flag);    // "true"

// Object obj = null;
// String s4 = String.valueOf(obj);     // "null"


// Integer.parseInt(String, radix) is used to convert a character to its integer value in a specified base (radix).
// int decimal = Integer.parseInt("F", 16); // returns 15