import java.util.*;
import java.util.stream.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        HashMap<String, Integer> capacityMap = new HashMap<>();
        HashMap<String, String> typeMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieIDs = new String[n];

        // -------- INPUT --------
        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter Bogie ID: ");
            String id = sc.nextLine();

            if (capacityMap.containsKey(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--;
                continue;
            }

            bogieIDs[i] = id;

            System.out.print("Enter Bogie Type (Passenger/Goods): ");
            String type = sc.nextLine();

            System.out.print("Enter Capacity: ");
            int capacity = sc.nextInt();
            sc.nextLine();

            typeMap.put(id, type);
            capacityMap.put(id, capacity);
        }

        // -------- SORT USING STREAM --------
        System.out.println("\nPassenger Bogies Sorted by Capacity:");

        capacityMap.entrySet()
                .stream()
                .filter(entry -> typeMap.get(entry.getKey()).equalsIgnoreCase("Passenger"))
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue())
                );

        // -------- SEARCH --------
        System.out.print("\nEnter Bogie ID to search: ");
        String searchID = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (bogieIDs[i].equalsIgnoreCase(searchID)) {
                System.out.println("Bogie ID FOUND at position: " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bogie ID NOT FOUND!");
        }

        sc.close();
    }
}