package Taxi_Booking;
import java.util.*;

public class PrintDetails extends Booking {
    PrintDetails(int customerID, char pick, char drop, int pickTime, int dropTime, int amount) {
        super(customerID, pick, drop, pickTime, dropTime, amount);
    }

    public static void printCustomerDetails() {
        System.out.println("Taxi No: \tTotal Earnings:");
        System.out.println("BookingID\tCustomerID\tFrom\tTo\tPickupTime\tDropTime\tAmount");
        System.out.println("Output:");

        for(int i : taxiBookings.keySet()) {
            List<Booking> booking = taxiBookings.get(i);
            System.out.println("Taxi - " + i);

            int totalEarning = 0;
            int bookingId = 1;

            for(Booking b : booking) {
                if(b.amount > 0) {
                    System.out.println(bookingId + "\t" + b.customerID + "\t" + b.pick + "\t" + b.drop + "\t" + b.pickTime + "\t" + b.dropTime + "\t" + b.amount);
                }
                totalEarning += b.amount;
                bookingId++;
            }
            System.out.println("Total Earnings: Rs. " + totalEarning);
        }
    }
}
