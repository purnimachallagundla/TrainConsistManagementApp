import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieNames = new String[n];
        String[] bogieIDs = new String[n];

        // -------- INPUT --------
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Bogie Name: ");
            bogieNames[i] = sc.nextLine();

            System.out.print("Enter Bogie ID: ");
            bogieIDs[i] = sc.nextLine();
        }

        // -------- SORT --------
        Arrays.sort(bogieIDs);

        System.out.println("\nSorted Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }

        // -------- SEARCH --------
        System.out.print("\nEnter Bogie ID to search: ");
        String searchID = sc.nextLine();

        int left = 0, right = n - 1;
        boolean found = false;

        // -------- BINARY SEARCH --------
        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = bogieIDs[mid].compareToIgnoreCase(searchID);

            if (compare == 0) {
                System.out.println("Bogie ID FOUND at position: " + (mid + 1));
                found = true;
                break;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Bogie ID NOT FOUND!");
        }

        sc.close();
    }
}