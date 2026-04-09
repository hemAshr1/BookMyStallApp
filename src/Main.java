import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, RoomDetails> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register room type with details
    public void addRoomType(String roomType, int beds, int sizeSqFt, double price, int availableCount) {
        inventory.put(roomType, new RoomDetails(beds, sizeSqFt, price, availableCount));
    }

    // Search and display room details
    public void searchRoom(String roomType) {
        RoomDetails details = inventory.get(roomType);
        if (details != null) {
            System.out.println("Hotel Room Inventory Status\n");
            System.out.println(roomType + ":");
            System.out.println("Beds: " + details.beds);
            System.out.println("Size: " + details.sizeSqFt + " sqft");
            System.out.println("Price per night: " + details.price);
            System.out.println("Available Rooms: " + details.availableCount);
            System.out.println();
        } else {
            System.out.println("Room type '" + roomType + "' not found in inventory.");
        }
    }

    // Inner class to hold room details
    private static class RoomDetails {
        int beds;
        int sizeSqFt;
        double price;
        int availableCount;

        RoomDetails(int beds, int sizeSqFt, double price, int availableCount) {
            this.beds = beds;
            this.sizeSqFt = sizeSqFt;
            this.price = price;
            this.availableCount = availableCount;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types with details
        inventory.addRoomType("Single Room", 1, 250, 1500.0, 5);
        inventory.addRoomType("Double Room", 2, 400, 2500.0, 3);
        inventory.addRoomType("Suite Room", 3, 750, 5000.0, 2);

        // Demo search (hardcoded for UC4)
        inventory.searchRoom("Single Room");
        inventory.searchRoom("Double Room");
        inventory.searchRoom("Suite Room");
    }
}