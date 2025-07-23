package Banking_Application;

public class Bank {
    public static void Deposit(int custId, int amount) {
        Customer c = CustomerDetails.custDetails.get(custId);
        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        int updatedBalance = c.Balance + amount;
        c.Balance = updatedBalance;

        UpdateBalance.updateBalance(custId, updatedBalance);
        System.out.println("Amount deposited successfully. Updated Balance: " + updatedBalance);

        TransactionHistory.transHistory(custId, "CashDeposit", amount, updatedBalance);
    }

    public static void Withdraw(int custId, int amount) {
        Customer c = CustomerDetails.custDetails.get(custId);
        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        if (c.Balance > amount) {
            if (c.Balance - amount > 1000) {
                int updatedBalance = c.Balance - amount;
                c.Balance = updatedBalance;
                UpdateBalance.updateBalance(custId, updatedBalance);
                System.out.println("Withdrawal successful. Updated Balance: " + updatedBalance);
            } else {
                System.out.println("Minimum Balance of 1000 must be maintained");
            }
        } else {
            System.out.println("Insufficient Balance");
        }

        TransactionHistory.transHistory(custId, "ATMWithdrawal", amount, c.Balance);
    }

    public static void Transfer(int custId, int amount, int toId) {
        Customer from = CustomerDetails.custDetails.get(custId);
        Customer to = CustomerDetails.custDetails.get(toId);

        if (from == null || to == null) {
            System.out.println("Customer not found");
            return;
        }

        if (from.Balance > amount + 10) {
            if (from.Balance - amount > 1000) {
                int updatedBalance = from.Balance - amount;
                from.Balance = updatedBalance;
                to.Balance += amount;
                UpdateBalance.updateBalance(custId, updatedBalance);
                UpdateBalance.updateBalance(toId, to.Balance);
            } else {
                System.out.println("Minimum Balance of 1000 must be maintained");
            }
        } else {
            System.out.println("Insufficient Balance");
        }

        TransactionHistory.transferAccountHistory(custId, "TransferTo", toId, amount, to.Balance);
        TransactionHistory.transferAccountHistory(custId, "TransferFrom", custId, amount, from.Balance);

        if(amount > 5000) {
            from.Balance -= 10;
            TransactionHistory.transHistory(custId, "Operational Fee", 10, from.Balance);
        }

    }
}