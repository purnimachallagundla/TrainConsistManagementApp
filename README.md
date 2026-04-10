import java.util.*;
import java.util.stream.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        HashMap<String, Integer> cargoMap = new HashMap<>();
        HashMap<String, Integer> capacityMap = new HashMap<>();
        HashMap<String, String> typeMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter Bogie ID: ");
            String id = sc.nextLine();

            // Duplicate check
            if (capacityMap.containsKey(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--;
                continue;
            }

            // -------- TYPE --------
            System.out.print("Enter Bogie Type (Passenger/Goods): ");
            String type = sc.nextLine();

            // -------- CAPACITY --------
            int capacity = 0;
            while (true) {
                try {
                    System.out.print("Enter Capacity: ");
                    capacity = sc.nextInt();
                    sc.nextLine();

                    if (capacity <= 0)
                        throw new IllegalArgumentException("Capacity must be > 0");

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter a number.");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // -------- CARGO WEIGHT --------
            int weight = 0;
            while (true) {
                try {
                    System.out.print("Enter Cargo Weight (in tons): ");
                    weight = sc.nextInt();
                    sc.nextLine();

                    if (weight <= 0)
                        throw new IllegalArgumentException("Weight must be > 0");

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter a number.");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("Finalizing entry for Bogie: " + id);
                }
            }

            // Store values
            typeMap.put(id, type);
            capacityMap.put(id, capacity);
            cargoMap.put(id, weight);

            System.out.println("Entry added successfully ✔");
        }

        // -------- DISPLAY --------
        System.out.println("\nFinal Cargo Assignments:");
        for (Map.Entry<String, Integer> entry : cargoMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " tons");
        }

        // -------- STREAM SORT --------
        System.out.println("\nPassenger Bogies Sorted by Capacity:");

        capacityMap.entrySet()
                .stream()
                .filter(entry -> typeMap.get(entry.getKey()).equalsIgnoreCase("Passenger"))
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue())
                );

        sc.close();
    }
}