package Taxi_Booking;

import java.util.*;
public class Booking {

    int customerID;
    char pick;
    char drop;
    int pickTime;
    int dropTime;
    int amount;

    Booking(int customerID, char pick, char drop, int pickTime, int dropTime, int amount) {
        this.customerID = customerID;
        this.pick = pick;
        this.drop = drop;
        this.pickTime = pickTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    static Map<Integer, List<Booking>> taxiBookings = new HashMap<>();

    public static void initialize() {
        for(int i = 1; i <= 4; i++) {
            List<Booking> bookings = new ArrayList<>();
            bookings.add(new Booking(0, 'A', 'A', 0, 0, 0));
            taxiBookings.put(i, bookings);
        }
    }

    public static void bookTickets(int customerID, char pickup, char drop, int pickTime) {
        int pickupPos = pickup - '0';
        int dropPos = drop - '0';
        int distance = Math.abs(pickupPos - dropPos) * 15;
        int travelTime = Math.abs(pickupPos - dropPos);
        int dropTime = pickTime + travelTime;

        int minDistance = Integer.MAX_VALUE;
        int minEarning = Integer.MAX_VALUE;
        int chosenTaxiId = -1;

        for(int i : taxiBookings.keySet()) {
            List<Booking> bookings = taxiBookings.get(i);
            Booking lastBooking = bookings.get(bookings.size() - 1);
            int taxiPos = lastBooking.drop - '0';
            int freeAt = lastBooking.dropTime;
            int distToPickup = Math.abs(pickupPos - taxiPos);

            if(freeAt <= pickTime) {
                int totalEarning = 0;
                for(Booking b : bookings) {
                    totalEarning += b.amount;
                }

                if(distToPickup < minDistance || (distToPickup == minDistance && totalEarning < minEarning)) {
                    minDistance = distToPickup;
                    minEarning = totalEarning;
                    chosenTaxiId = i;
                }
            }
        }

        if(chosenTaxiId == -1) {
            System.out.println("No taxi available at this time. Booking Rejected!");
            return;
        }

        int amt = 100;
        if(distance > 5) {
            amt += (distance - 5) * 10;
        }

        Booking newBooking = new Booking(customerID, pickup, drop, pickTime, dropTime, amt);
        taxiBookings.get(chosenTaxiId).add(newBooking);

        System.out.println("Taxi can be allotted");
        System.out.println("Taxi - " + chosenTaxiId + " is allotted");
    }   
}

