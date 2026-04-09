import java.util.*;

class RoomInventory {
    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    // Synchronized allocation to ensure thread safety
    public synchronized boolean allocateRoom(String guestName, String roomType) {
        int count = availability.getOrDefault(roomType, 0);
        if (count > 0) {
            int roomId = (availability.get(roomType) - count) + 1;
            availability.put(roomType, count - 1);
            System.out.println("Booking confirmed for Guest: " + guestName +
                    ", Room ID: " + roomType + "-" + roomId);
            return true;
        } else {
            System.out.println("Booking failed for Guest: " + guestName +
                    ", Room Type: " + roomType + " (No availability)");
            return false;
        }
    }

    public void displayRemainingInventory() {
        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry : availability.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class BookingTask implements Runnable {
    private RoomInventory inventory;
    private String guestName;
    private String roomType;

    public BookingTask(RoomInventory inventory, String guestName, String roomType) {
        this.inventory = inventory;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    @Override
    public void run() {
        inventory.allocateRoom(guestName, roomType);
    }
}

public class Main {

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        System.out.println("Concurrent Booking Simulation\n");

        // Create threads for concurrent booking requests
        Thread t1 = new Thread(new BookingTask(inventory, "Abhi", "Single"));
        Thread t2 = new Thread(new BookingTask(inventory, "Vanmathi", "Double"));
        Thread t3 = new Thread(new BookingTask(inventory, "Kural", "Suite"));
        Thread t4 = new Thread(new BookingTask(inventory, "Subha", "Single"));

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Error: Thread interrupted.");
        }

        // Display remaining inventory
        inventory.displayRemainingInventory();
    }
}