/**
 * ================================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * ================================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates basic domain modeling
 * for the Hotel Booking Management System.
 *
 * At this stage, the application:
 * - Defines an abstract Room class
 * - Creates concrete room types (Single, Double, Suite)
 * - Stores static availability using simple variables
 * - Prints room details and availability to the console
 *
 * This use case introduces inheritance, abstraction,
 * and encapsulation before data structures are added.
 *
 * @author Developer
 * @version 2.0
 */
abstract class Room {
    protected String name;
    protected int beds;
    protected double price;
    protected int sizeSqFt;

    public Room(String name, int beds, double price, int sizeSqFt) {
        this.name = name;
        this.beds = beds;
        this.price = price;
        this.sizeSqFt = sizeSqFt;
    }

    public abstract void displayDetails();
}

// Concrete room types
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 2000.0, 250);
    }

    @Override
    public void displayDetails() {
        System.out.println(name + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: "+sizeSqFt+" sqft");
        System.out.println("Price per night: " + price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 3500.0, 400);
    }

    @Override
    public void displayDetails() {
        System.out.println(name + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: "+sizeSqFt+" sqft");
        System.out.println("Price per night: " + price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 6000.0, 700);
    }

    @Override
    public void displayDetails() {
        System.out.println(name + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: "+sizeSqFt+" sqft");
        System.out.println("Price per night: " + price);
    }
}

public class Main {

    public static void main(String[] args) {
        // Initialize room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability (simple variables)
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        System.out.println("Hotel Room Initialization");
        System.out.println("");
        single.displayDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println("");

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println("");

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable);
        System.out.println("");
    }
}