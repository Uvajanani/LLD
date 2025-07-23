package Train_Reservation_System;

import java.util.*;

public class Main {
    public static int totalConfirm = 63;
    public static int RAC = 18;
    public static int waitingList = 10;
    public static int lower = 25;
    public static int middle = 28;
    public static int upper = 28;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Book Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. Print Booked Tickets");
            System.out.println("4. Print Available Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = s.nextInt();
            s.nextLine(); 

            switch (ch) {
                case 1:
                    System.out.print("Enter your name : ");
                    String name = s.nextLine();

                    System.out.print("Enter your age : ");
                    int age = s.nextInt();

                    System.out.print("Enter your gender : ");
                    String gender = s.next();

                    System.out.print("Enter the berth preference(lower/middle/upper) : ");
                    String berth = s.next();
                    boolean hasChild = false;

                    if (gender.toLowerCase().equals("female")) {
                        System.out.print("Are you travelling with a child below 5 years? (Yes/No): ");
                        String child = s.next();
                        hasChild = child.equalsIgnoreCase("yes");
                    }

                    Book.bookTickets(name, age, gender, berth, hasChild);
                    System.out.println("Ticket Booked Successfully!");
                    break;

                case 2:
                    System.out.print("Enter the ID to cancel ticket: ");
                    int id = s.nextInt();
                    Cancel.cancelTickets(id);
                    System.out.println("Ticket cancelled successfully!");
                    break;

                case 3:
                    PrintTickets.printTickets();
                    break;

                case 4:
                    PrintAvailableTickets.printAvailable();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

}
