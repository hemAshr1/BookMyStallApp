import java.io.*;
import java.util.HashMap;
import java.util.Map;

class RoomInventory implements Serializable {
    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
    }

    public void addRoomType(String roomType, int availableCount) {
        availability.put(roomType, availableCount);
    }

    public Map<String, Integer> getAvailability() {
        return availability;
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : availability.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {

    private static final String FILE_NAME = "inventory.dat";

    public static void main(String[] args) {
        RoomInventory inventory = null;

        System.out.println("System Recovery");

        // Try to load persisted inventory
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            inventory = (RoomInventory) ois.readObject();
            System.out.println("Inventory data loaded successfully.");
        } catch (Exception e) {
            System.out.println("No valid inventory data found. Starting fresh.");
            inventory = new RoomInventory();
            inventory.addRoomType("Single", 5);
            inventory.addRoomType("Double", 3);
            inventory.addRoomType("Suite", 2);
        }

        // Display inventory
        inventory.displayInventory();

        // Save inventory back to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
            System.out.println("\nInventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory data.");
        }

    }
}