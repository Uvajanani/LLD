package Banking_Application;

import java.util.ArrayList;
import java.util.List;

public class TopNCustomers {
    public static void topN(int n) {
        List<Customer> customers = new ArrayList<>(CustomerDetails.custDetails.values());
        customers.sort((a, b) -> Integer.compare(b.Balance, a.Balance));
        
        System.out.println("Top " + n + " Customers");
        for (int i = 0; i < Math.min(n, customers.size()); i++) {
            Customer c = customers.get(i);
            System.out.println(c.CustId + " " + c.AccountNo + " " + c.Name + " " + c.Balance);
        }
    }
}