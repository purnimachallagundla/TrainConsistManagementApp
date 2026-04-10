import java.util.Scanner;
import java.util.TreeSet;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        // TreeSet → stores UNIQUE + SORTED bogie IDs
        TreeSet<String> bogieIDs = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            // Add and check duplicate
            if (!bogieIDs.add(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--; // retry same input
            } else {
                System.out.println("Bogie ID added successfully.");
            }
        }

        // Display sorted bogie IDs
        System.out.println("\nSorted Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }

        // First and Last (only possible in TreeSet)
        if (!bogieIDs.isEmpty()) {
            System.out.println("\nFirst Bogie ID: " + bogieIDs.first());
            System.out.println("Last Bogie ID: " + bogieIDs.last());
        }

        sc.close();
    }
}