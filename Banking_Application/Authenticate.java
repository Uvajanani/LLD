package Banking_Application;

import java.util.*;

public class Authenticate {
    public static boolean authenticated = false;
    static int custId;

    public static void signIn() {
        Scanner s = new Scanner(System.in);
        CustomerDetails.loadCustomersFromFile("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt");
        
        System.out.print("Enter your Customer ID: ");
        custId = s.nextInt();

        System.out.println("Enter your password: ");
        String password = s.next();

        String encryptedPassword = encrypt(password);
        Customer c = CustomerDetails.custDetails.get(custId);
        
        if(c == null) {
            System.out.println("Customer not found!");
        } else {
            if(c.EncryptedPwd.equals(encryptedPassword)) {
                authenticated = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid Credentials");
            }
        }
    }

    private static String encrypt(String password) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(Character.isUpperCase(ch)) {
                sb.append((ch == 'Z') ? 'A' : (char)(ch + 1));
            } else if(Character.isLowerCase(ch)) {
                sb.append((ch == 'z' ? 'a' : (char)(ch + 1)));
            } else if(Character.isDigit(ch)) {
                sb.append((ch == '9' ? '0' : (char)(ch + 1)));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static int getCustID() {
        return custId;
    }
}


