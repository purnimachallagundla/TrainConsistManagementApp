import java.util.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        // Map Bogie ID -> Capacity
        HashMap<String, Integer> bogieMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            // Check duplicate
            if (bogieMap.containsKey(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--; // retry
                continue;
            }

            System.out.print("Enter Capacity for " + id + ": ");
            int capacity = sc.nextInt();
            sc.nextLine(); // consume newline

            bogieMap.put(id, capacity);
            System.out.println("Bogie added successfully.");
        }

        // Convert map to list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(bogieMap.entrySet());

        // Sort by capacity (ascending)
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });

        // Display sorted result
        System.out.println("\nBogies Sorted by Capacity:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        sc.close();
    }
}