package Train_Reservation_System;

public class PrintAvailableTickets extends Main{
    public static void printAvailable() {
        System.out.println("----- Available Tickets Summary -----");
        System.out.println("Total Confirmed Tickets Available : " + totalConfirm);
        System.out.println("Lower Birth Available : " + lower);
        System.out.println("Middle Birth Available : " + middle);
        System.out.println("Upper Birth Available : " + upper);
        System.out.println("RAC Available : " + RAC);
        System.out.println("Waiting List Available : " + waitingList);
        System.out.println("Total Available Tickets : " + totalConfirm + RAC + waitingList);
    }
}
