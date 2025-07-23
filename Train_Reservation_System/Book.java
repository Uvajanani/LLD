package Train_Reservation_System;

import java.util.*;

public class Book extends Main {
    static Map<Integer, String> travellers = new HashMap<>();
    static Queue<Integer> waitingQueue = new LinkedList<>();
    static Queue<Integer> RACQueue = new LinkedList<>();
    static List<String> childList = new ArrayList<>();
    static int travellerId = 1;

    public static void bookTickets(String name, int age, String gender, String birth, boolean hasChild) {
        if (age < 5) {
            childList.add(name + " " + age + " " + gender.toLowerCase());
            return;
        } else if (age > 60 || hasChild) {
            if (lower > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "lower");
                travellerId++;
                lower--;
                totalConfirm--;
            } else if (middle > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "middle");
                travellerId++;
                middle--;
                totalConfirm--;
            } else if (upper > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "upper");
                travellerId++;
                upper--;
                totalConfirm--;
            } else if (RAC > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "RAC");
                RACQueue.add(travellerId);
                travellerId++;
                RAC--;
            } else if (waitingList > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "Waiting List");
                waitingQueue.add(travellerId);
                travellerId++;
                waitingList--;
            } else {
                System.out.println("No tickets available");
            }
        } else {
            if (totalConfirm > 0) {
                if (birth.toLowerCase().equals("lower")) {
                    if (lower > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + birth);
                        travellerId++;
                        lower--;
                        totalConfirm--;
                    } else if (middle > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "middle");
                        travellerId++;
                        middle--;
                        totalConfirm--;
                    } else if (upper > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "upper");
                        travellerId++;
                        upper--;
                        totalConfirm--;
                    }
                } else if (birth.toLowerCase().equals("middle")) {
                    if (middle > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + birth);
                        travellerId++;
                        middle--;
                        totalConfirm--;
                    } else if (lower > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "lower");
                        travellerId++;
                        lower--;
                        totalConfirm--;
                    } else if (upper > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "upper");
                        travellerId++;
                        upper--;
                        totalConfirm--;
                    }
                } else if (birth.toLowerCase().equals("upper")) {
                    if (upper > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + birth);
                        travellerId++;
                        upper--;
                        totalConfirm--;
                    } else if (lower > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "lower");
                        travellerId++;
                        lower--;
                        totalConfirm--;
                    } else if (middle > 0) {
                        travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "middle");
                        travellerId++;
                        middle--;
                        totalConfirm--;
                    }
                }
            } else if (RAC > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "RAC");
                RACQueue.add(travellerId);
                travellerId++;
                RAC--;
            } else if (waitingList > 0) {
                travellers.put(travellerId, name + " " + age + " " + gender.toLowerCase() + " " + "Waiting List");
                waitingQueue.add(travellerId);
                travellerId++;
                waitingList--;
            } else {
                System.out.println("No tickets available");
            }
        }
    }
}
