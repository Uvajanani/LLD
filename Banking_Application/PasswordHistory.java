package Banking_Application;

import java.util.*;

public class PasswordHistory {
    static protected Map<Integer, LinkedList<String>> userPwdHistory = new HashMap<>();

    public static void pwdHistory(int custId, String password) {
        LinkedList<String> history = userPwdHistory.getOrDefault(custId, new LinkedList<>());

        if (history.size() == 3) {
            history.removeFirst(); 
        }

        history.add(password); 
        userPwdHistory.put(custId, history);
    }

    public static boolean checkPresence(int custId, String password) {
        LinkedList<String> history = userPwdHistory.getOrDefault(custId, new LinkedList<>());
        return history.contains(password);
    }
}
