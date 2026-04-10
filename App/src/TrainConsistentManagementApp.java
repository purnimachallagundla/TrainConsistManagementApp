import java.util.*;
import java.util.stream.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        // Map Bogie ID -> Type
        HashMap<String, String> bogieMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            if (bogieMap.containsKey(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--;
                continue;
            }

            System.out.print("Enter Bogie Type (Passenger/Goods): ");
            String type = sc.nextLine();

            bogieMap.put(id, type);
        }

        // Group bogies by type using Streams
        Map<String, List<String>> groupedBogies =
                bogieMap.entrySet()
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

        sc.close();
    }
}