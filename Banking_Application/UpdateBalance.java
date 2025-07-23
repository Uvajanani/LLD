package Banking_Application;

import java.io.*;
import java.util.*;

public class UpdateBalance {
    public static void updateBalance(int custId, int balance) {
        List<String> updatedLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\JANANI\\Desktop\\LLD\\Banking_Application\\bank_db.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] details = line.split(" ");
                int customerId = Integer.parseInt(details[0]);
                
                if(customerId == custId) {
                    String updatedLine = details[0] + " " + details[1] + " " + details[2] + " " + balance + " " + details[4];
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
}