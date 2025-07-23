package Taxi_Booking;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Booking.initialize();
        
        System.out.println("1. Book a taxi");
        System.out.println("2. Print Taxi Details");
        System.out.println("3. Exit");
    
        int customerID = 1;
        while (true) {
            System.out.print("Enter your choice : ");
            int ch = s.nextInt();
            
            switch (ch) {
                case 1:
                    System.out.println("Customer ID : " + customerID);
                    System.out.print("Pickup Point : ");
                    char pickup = s.next().charAt(0);

                    System.out.print("\nDrop Point : ");
                    char drop = s.next().charAt(0);

                    System.out.print("\nPickup Time : ");
                    int pickTime = s.nextInt();

                    Booking.bookTickets(customerID, pickup, drop, pickTime);
                    break;
                case 2:
                    PrintDetails.printCustomerDetails();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Please enter a valid choice!");
                    break;
            }
            customerID++;
        }

    }
}
