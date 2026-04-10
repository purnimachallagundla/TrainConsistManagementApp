import java.util.*;

public class TrainConsistentManagementApp {

    // Validate Train ID (Example: TR-1234)
    public static boolean isValidTrainID(String trainID) {
        return trainID.matches("TR-\\d{4}");
    }

    // Validate Cargo Code (Example: CG-ABC123)
    public static boolean isValidCargoCode(String cargoCode) {
        return cargoCode.matches("CG-[A-Z]{3}\\d{3}");
    }

    public static void main(String[] args) {

        // Map Bogie ID -> Capacity
        HashMap<String, Integer> bogieMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        // Train ID validation
        System.out.print("Enter Train ID (Format TR-1234): ");
        String trainID = sc.nextLine();

        if (isValidTrainID(trainID)) {
            System.out.println("Valid Train ID ✔");
        } else {
            System.out.println("Invalid Train ID ✖");
        }

        System.out.print("\nEnter number of bogies: ");
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

            System.out.print("Enter Capacity (Seats) for " + id + ": ");
            int capacity = sc.nextInt();
            sc.nextLine();

            bogieMap.put(id, capacity);
        }

        // Cargo Code validation
        System.out.print("\nEnter Cargo Code (Format CG-ABC123): ");
        String cargoCode = sc.nextLine();

        if (isValidCargoCode(cargoCode)) {
            System.out.println("Valid Cargo Code ✔");
        } else {
            System.out.println("Invalid Cargo Code ✖");
        }

        // Calculate total seats
        int totalSeats = 0;
        for (int seats : bogieMap.values()) {
            totalSeats += seats;
        }

        // Display bogie details
        System.out.println("\nBogie Details (ID -> Seats):");
        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display total seats
        System.out.println("\nTotal Seats in Train: " + totalSeats);

        sc.close();
    }
}