import java.util.LinkedList;
import java.util.Queue;

class Reservation {
    String guestName;
    String roomType;
    int roomNumber;

    public Reservation(String guestName, String roomType, int roomNumber) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }
}

public class Main {

    public static void main(String[] args) {
        // Initialize booking request queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Add sample booking requests with sequential room IDs
        bookingQueue.add(new Reservation("Abhi", "Single", 1));
        bookingQueue.add(new Reservation("Subha", "Single", 2));
        bookingQueue.add(new Reservation("Vanmathi", "Suite", 1));

        // Display allocation processing
        System.out.println("Room Allocation Processing");
        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.poll();
            System.out.println("Booking confirmed for Guest: " + r.guestName +
                    ", Room ID: " + r.roomType + "-" + r.roomNumber);
        }
    }
}