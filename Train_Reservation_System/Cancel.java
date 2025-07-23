package Train_Reservation_System;

public class Cancel extends Book{
    public static void cancelTickets(int id) {
        if(travellers.containsKey(id)) {
            String[] cancelledTraveller = travellers.get(id).split(" ");
            travellers.remove(id);
            totalConfirm++;

            if(RACQueue.size() > 0) {
                int tID = RACQueue.poll();
                String[] details = travellers.get(tID).split(" ");
                travellers.remove(tID);
                travellers.put(tID, details[0] + " " + details[1] + " " + details[2] + " " + cancelledTraveller[3]);
                totalConfirm--;
                RAC++;

                if(waitingQueue.size() > 0) {
                    int wID = waitingQueue.poll();
                    String[] waitingDetails = travellers.get(wID).split(" ");
                    travellers.remove(wID);
                    travellers.put(wID, waitingDetails[0] + " " + waitingDetails[1] + " " + waitingDetails[2] + " " + details[3]);
                    RAC--;
                    waitingList++;
                }
            } else {
                if(cancelledTraveller[3].equals("lower")) {
                    lower++;
                } else if(cancelledTraveller[3].equals("middle")) {
                    middle++;
                } else if(cancelledTraveller[3].equals("upper")){
                    upper++;
                }
            }
        } else {
            System.out.println("ID not present! Please enter a valid ID");
        }
    }
}

