package Banking_Application;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int custId = 0;

        System.out.println("Welcome to the Bank App");
        System.out.println("1. Create new Account");
        System.out.println("2. Sign in");

        System.out.println("Enter your choice: ");
        int ch1 = s.nextInt();

        switch(ch1) {
            case 1:
                AddCustomers.createNewCustomer();
                custId = AddCustomers.getCustID();
                TransactionHistory.transHistory(custId, "Opening", 10000, 10000);
                break;
        
            case 2:
                Authenticate.signIn();
                custId = Authenticate.getCustID();
                break;
            default:
                System.out.println("Invalid option");
                s.close();
                return;
        }

        if(custId == 0) {
            System.out.println("Authentication failed");
            s.close();
            return;
        }

        while(true) {
            System.out.println("---- Banking Menu ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Account Transfer");
            System.out.println("4. Top N Customers");
            System.out.println("5. Change New Password");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            System.out.println("Enter your choice: ");
            int ch2 = s.nextInt();
            int amount;

            switch(ch2) {
                case 1:
                    System.out.println("Enter the amount to deposit: ");
                    amount = s.nextInt();
                    Bank.Deposit(custId, amount);
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    amount = s.nextInt();
                    Bank.Withdraw(custId, amount);
                    break;
                case 3:
                    System.out.println("Enter the Transfer Id: ");
                    int toId = s.nextInt();
                    System.out.println("Enter the amount for transfer: ");
                    amount = s.nextInt();
                    Bank.Transfer(custId, amount, toId);
                    break;
                case 4 : 
                    System.out.println("Enter the number of top customers: ");
                    int n = s.nextInt();
                    TopNCustomers.topN(n);
                case 5: 
                    System.out.println("Authenticate with current password");
                    Authenticate.signIn();
                    custId = Authenticate.getCustID();
                    ChangePassword.changePwd();
                    break;
                case 6: 
                    System.out.println("Transaction History");
                    TransactionHistory.printHistory(custId);
                case 7:
                    System.out.println("Logged out successfully! Thank you");
                    s.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
