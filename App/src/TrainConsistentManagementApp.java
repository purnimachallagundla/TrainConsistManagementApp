import java.util.*;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------------- INPUT WITH VALIDATION ----------------
        HashMap<String, Integer> bogieMap = new HashMap<>();

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            if (bogieMap.containsKey(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--;
                continue;
            }

            int capacity = 0;
            boolean valid = false;

            while (!valid) {
                try {
                    System.out.print("Enter Capacity for " + id + ": ");
                    capacity = sc.nextInt();
                    sc.nextLine();

                    if (capacity <= 0) {
                        throw new IllegalArgumentException("Capacity must be greater than 0!");
                    }

                    valid = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Input: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input: Please enter a number!");
                    sc.nextLine(); // clear buffer
                }
            }

            bogieMap.put(id, capacity);
            System.out.println("Bogie added successfully.");
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

        // ---------------- OUTPUT ----------------
        System.out.println("\nPerformance Comparison (Insertion of " + size + " elements)");
        System.out.println("HashSet Time: " + (endHash - startHash) + " ns");
        System.out.println("TreeSet Time: " + (endTree - startTree) + " ns");
        System.out.println("LinkedHashSet Time: " + (endLinked - startLinked) + " ns");

        // Display bogie data
        System.out.println("\nValid Bogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Notes
        System.out.println("\nNote:");
        System.out.println("HashSet is fastest (O(1) average)");
        System.out.println("TreeSet is slower (O(log n) duess to sorting)");
        System.out.println("LinkedHashSet maintains insertion orders");

        sc.close();
    }
}