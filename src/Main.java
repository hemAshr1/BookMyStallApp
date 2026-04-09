import java.util.*;

class RoomInventory {
    private Map<String, Integer> availability;
    private List<String> rollbackHistory;

    public RoomInventory() {
        availability = new HashMap<>();
        rollbackHistory = new ArrayList<>();
    }

    // Register room type with availability
    public void addRoomType(String roomType, int availableCount) {
        availability.put(roomType, availableCount);
    }

    // Cancel booking and restore inventory
    public void cancelBooking(String reservationId, String roomType) {
        System.out.println("Booking Cancellation");
        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        rollbackHistory.add("Released Reservation ID: " + reservationId);

        // Restore availability
        availability.put(roomType, availability.getOrDefault(roomType, 0) + 1);

        // Display rollback history
        System.out.println();
        System.out.println("Rollback History (Most Recent First):");
        for (int i = rollbackHistory.size() - 1; i >= 0; i--) {
            System.out.println(rollbackHistory.get(i));
        }

        // Display updated availability
        System.out.println();
        System.out.println("Updated " + roomType + " Room Availability: " + availability.get(roomType));
    }
}

public class Main {

    public static void main(String[] args) {
        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);

        // Cancel a booking (demo)
        inventory.cancelBooking("Single-1", "Single");
    }
}