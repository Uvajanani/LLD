package Train_Reservation_System;

import java.util.*;

public class PrintTickets extends Book {
    public static void printTickets() {
        System.out.println("ID\tName\t\tAge\tGender\tBirth Perference");
        for(Map.Entry<Integer, String> entry : travellers.entrySet()) {
            int travellerId = entry.getKey();
            String[] details = entry.getValue().split(" ");
            System.out.println(travellerId + "\t" + details[0] + "\t\t" + details[1] + "\t" + details[2] + "\t" + details[3]);
        }

        if(childList.size() > 0) {
            System.out.println("\nChildren (below 5, no birth):");
            for(String child : childList) {
                System.out.println(child);
            }
        }

        System.out.println("\nTotal Tickets booked : " + travellers.size());
    }
}
