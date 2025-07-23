package Banking_Application;

import java.io.*;
import java.util.*;

public class AddCustomers {
    static int maxCustId = 0;
    public static void createNewCustomer() {
        Scanner s = new Scanner(System.in);

        CustomerDetails.loadCustomersFromFile("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt");
        
        System.out.print("Enter your Name: ");
        String name = s.nextLine();
        
        String password;
        while (true) {
            System.out.print("Enter the Password: ");
            password = s.nextLine();

            if(checkComplexity(password)) {
                break;
            } else {
                System.out.println("Password must contain at least 2 uppercase, 2 lowercase, 2 digits and minimum 6 characters.");
            }
        }

        System.out.print("Retype the password: ");
        String retypePassword = s.nextLine();

        if(!password.equals(retypePassword)) {
            System.out.print("Password does not match");
            s.close();
            return;
        }

        String encryptedPassword = encrypt(password);
        PasswordHistory.pwdHistory(Authenticate.getCustID(), encryptedPassword);

        int maxAccountNo = 0;

        for(Customer c : CustomerDetails.custDetails.values()) {
            maxCustId = Math.max(maxCustId, c.CustId);
            maxAccountNo = Math.max(maxAccountNo, c.AccountNo);
        }

        CustomerDetails.custDetails.put(maxCustId + 1, new Customer(maxCustId + 1, maxAccountNo + 1, name, 10000, encryptedPassword));
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt", true));
            bw.newLine();
            bw.write((maxCustId + 1) + " " + (maxAccountNo + 1) + " " + name + " " + 10000 + " " + encryptedPassword);
            
            System.err.println("Customer added successfully");
            bw.close();
        } catch (IOException e) {
            System.out.println("File Not Found!");
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
        return maxCustId + 1;
    }

    public static boolean checkComplexity(String password) {
        int lc = 0;
        int uc = 0;
        int digit = 0;
    
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(Character.isLowerCase(ch)) lc++;
            else if(Character.isUpperCase(ch)) uc++;
            else if(Character.isDigit(ch)) digit++;
        }

        if(lc >= 2 && uc >= 2 && digit >= 2 && password.length() >= 6) {
            return true;
        }
        return false;
    }
}