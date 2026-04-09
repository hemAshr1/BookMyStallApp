import java.util.*;

class AddOnService {
    String serviceName;
    double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }
}

class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    // Attach services to a reservation
    public void addServices(String reservationId, List<AddOnService> services) {
        reservationServices.put(reservationId, services);
    }

    // Display add-on selection details
    public void displayAddOnDetails(String reservationId) {
        List<AddOnService> services = reservationServices.get(reservationId);
        if (services != null && !services.isEmpty()) {
            double totalCost = 0;
            for (AddOnService s : services) {
                totalCost += s.cost;
            }
            System.out.println("Add-On Service Selection");
            System.out.println("Reservation ID: " + reservationId);
            System.out.println("Total Add-On Cost: " + totalCost);
        } else {
            System.out.println("No add-on services selected for Reservation ID: " + reservationId);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // Initialize manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create sample services
        List<AddOnService> servicesForSingle = new ArrayList<>();
        servicesForSingle.add(new AddOnService("Breakfast", 500.0));
        servicesForSingle.add(new AddOnService("Airport Pickup", 1000.0));

        // Attach services to reservation
        manager.addServices("Single-1", servicesForSingle);

        // Display details for reservation
        manager.displayAddOnDetails("Single-1");

    }
}