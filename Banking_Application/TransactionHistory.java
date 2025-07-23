package Banking_Application;

import java.util.*;
public class TransactionHistory {
    static int transId = 1;
    static Map<Integer, List<String>> transaction = new HashMap<>();
    
    public static void transHistory(int custId, String type, int amount, int balance) {
        List<String> historyList = transaction.getOrDefault(custId, new ArrayList<>());
        historyList.add(transId + " " + type + " " + amount + " " + balance);
        transaction.put(custId, historyList);
        transId++;
    }

    public static void transferAccountHistory(int custId, String type, int toId, int amount, int balance) {
        List<String> historyList = transaction.getOrDefault(custId, new ArrayList<>());
        historyList.add(transId + " " + type + " " + toId + " " + amount + " " + balance);
        transaction.put(custId, historyList);
        transId++;
    }

    public static void printHistory(int custId) {
        Customer c = CustomerDetails.custDetails.get(custId);

        System.out.println("Account Statement");
        System.out.println("Name - " + c.Name);
        System.out.println("Account No - " + c.AccountNo);
        System.out.println("Customer Id - " + c.CustId);
        
        System.out.println("TransId\t TransType\t\t Amount\t  Balance");

        List<String> history = transaction.get(custId);
        if (history == null || history.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }
        
        for(int i = 0; i < history.size(); i++) {
            String[] trans = history.get(i).split(" ");
            if(trans.length == 5) {
                System.out.println(trans[0] + "\t" + trans[1] + " " + trans[2] + "\t\t" + trans[3] + "\t" + trans[4]);
            } else {
                System.out.println(trans[0] + "\t" + trans[1] + "\t\t" + trans[2] + "\t" + trans[3]);
            }
        }
    }
}
