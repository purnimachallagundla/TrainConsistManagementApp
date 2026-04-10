import java.util.*;
import java.util.stream.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        // Map Bogie ID -> Type
        HashMap<String, String> typeMap = new HashMap<>();

        // Map Bogie ID -> Capacity
        HashMap<String, Integer> capacityMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            if (typeMap.containsKey(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--;
                continue;
            }

            System.out.print("Enter Bogie Type (Passenger/Goods): ");
            String type = sc.nextLine();

            System.out.print("Enter Capacity (Seats) for " + id + ": ");
            int capacity = sc.nextInt();
            sc.nextLine();

            typeMap.put(id, type);
            capacityMap.put(id, capacity);
        }

        // Group bogies by type
        Map<String, List<String>> groupedBogies =
                typeMap.entrySet()
                        .stream()
                        .collect(Collectors.groupingBy(
                                entry -> entry.getValue(),
                                Collectors.mapping(entry -> entry.getKey(),
                                        Collectors.toList())
                        ));

        // Display grouped bogies
        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<String>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Calculate total seats
        int totalSeats = 0;
        for (int seats : capacityMap.values()) {
            totalSeats += seats;
        }

        // Display bogie details
        System.out.println("\nBogie Details (ID -> Seats):");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display total seats
        System.out.println("\nTotal Seats in Train: " + totalSeats);

        sc.close();
    }
}