package Banking_Application;

public class Customer {
    int CustId, AccountNo;
    String Name, EncryptedPwd;
    int Balance;

    Customer(int CustId, int AccountNo, String Name, int Balance, String EncryptedPwd) {
        this.CustId = CustId;
        this.AccountNo = AccountNo;
        this.Name = Name;
        this.Balance = Balance;
        this.EncryptedPwd = EncryptedPwd;
    }
}

