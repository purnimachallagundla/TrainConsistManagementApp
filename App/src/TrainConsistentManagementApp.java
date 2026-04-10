import java.util.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        // Maps
        HashMap<String, String> typeMap = new HashMap<>();
        HashMap<String, Integer> weightMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        // ---------------- INPUT ----------------
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

            System.out.print("Enter Weight (in tons): ");
            int weight = sc.nextInt();
            sc.nextLine();

            typeMap.put(id, type);
            weightMap.put(id, weight);
        }

        // ---------------- SAFETY CHECK ----------------
        System.out.println("\nSafety Compliance Report (Goods Bogies):");

        for (String id : typeMap.keySet()) {
            String type = typeMap.get(id);
            int weight = weightMap.get(id);

            if (type.equalsIgnoreCase("Goods")) {
                if (weight <= 100) {
                    System.out.println(id + " -> SAFE ✔ (Weight: " + weight + ")");
                } else {
                    System.out.println(id + " -> NOT SAFE ✖ (Weight: " + weight + ")");
                }
            }
        }

        // ---------------- PERFORMANCE COMPARISON ----------------
        int size = 100000;

        // HashSet
        long startHash = System.nanoTime();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }
        long endHash = System.nanoTime();

        // TreeSet
        long startTree = System.nanoTime();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        long endTree = System.nanoTime();

        // LinkedHashSet
        long startLinked = System.nanoTime();
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            linkedSet.add(i);
        }
        long endLinked = System.nanoTime();

        // Results
        System.out.println("\nPerformance Comparison (Insertion of " + size + " elements)");

        System.out.println("HashSet Time: " + (endHash - startHash) + " ns");
        System.out.println("TreeSet Time: " + (endTree - startTree) + " ns");
        System.out.println("LinkedHashSet Time: " + (endLinked - startLinked) + " ns");

        // Notes
        System.out.println("\nNote:");
        System.out.println("HashSet is fastest (no ordering)");
        System.out.println("TreeSet is slowest (sorting required)");
        System.out.println("LinkedHashSet maintains insertion order");

        sc.close();
    }
}