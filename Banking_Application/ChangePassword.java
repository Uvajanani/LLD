package Banking_Application;

import java.io.*;
import java.util.*;

public class ChangePassword {
    public static void changePwd() {
        Scanner s = new Scanner(System.in);
        int custId = Authenticate.getCustID();

        String newPassword;
        while (true) {
            System.out.print("Enter the new Password: ");
            newPassword = s.nextLine();

            if(AddCustomers.checkComplexity(newPassword)) {
                break;
            } else if(PasswordHistory.checkPresence(custId, newPassword)) {
                System.out.println("Password should not be same as the past 3 passwords");
            } else {
                System.out.println("Password must contain at least 2 uppercase, 2 lowercase, 2 digits and minimum 6 characters.");
            }
        }

        System.out.println("Retype the new password");
        String retypeNewPassword = s.next();

        if(!newPassword.equals(retypeNewPassword)) {
            System.out.print("Password does not match");
            return;
        }

        String encryptedPassword = encrypt(newPassword);
        PasswordHistory.pwdHistory(custId, encryptedPassword);

        List<String> updatedLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(" ");
                int customerId = Integer.parseInt(details[0]);
                
                if(customerId == custId) {
                    String updatedLine = details[0] + " " + details[1] + " " + details[2] + " " + details[3] + " " + encryptedPassword;
                    updatedLines.add(updatedLine);
                } else {
                    updatedLines.add(line);
                }            
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt"));
            for(String str : updatedLines) {
                bw.write(str);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File is not found");
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
}
