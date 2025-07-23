package Banking_Application;

import java.io.*;
import java.util.*;

public class CustomerDetails {
    protected static LinkedHashMap<Integer, Customer> custDetails = new LinkedHashMap<>();
    public static void loadCustomersFromFile(String filePath) {        
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt"));
            
            String line;
            while((line = br.readLine()) != null) {
                String[] details = line.split(" ");
                int custId = Integer.parseInt(details[0]);
                int accountNo = Integer.parseInt(details[1]);
                String name = details[2];
                int balance = Integer.parseInt(details[3]);
                String encryptedPwd = details[4];
                
                custDetails.put(custId, new Customer(custId, accountNo, name, balance, encryptedPwd));
            }
            br.close();

            for(Customer c : custDetails.values()) {
                System.out.println(c.CustId + " " + c.Balance + " " + c.Name + " ");
            }

        } catch(IOException e) {
            System.out.println("File is not found");
        }
    }

}
