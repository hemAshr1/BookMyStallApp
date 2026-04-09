import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Booking Validation");

        try {
            // Prompt for guest name
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            // Prompt for room type
            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate input (case-sensitive check)
            if (roomType.equals("Single") || roomType.equals("Double") || roomType.equals("Suite")) {
                System.out.println("Booking successful for Guest: " + guestName + ", Room Type: " + roomType);
            } else {
                System.out.println("Booking failed: Invalid room type selected.");
            }
        } catch (Exception e) {
            // Catch any unexpected runtime errors
            System.out.println("Booking failed: An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}