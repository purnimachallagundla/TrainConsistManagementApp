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

        // Maps
        HashMap<String, String> typeMap = new HashMap<>();
        HashMap<String, Integer> weightMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        // Train ID validation
        System.out.print("Enter Train ID (Format TR-1234): ");
        String trainID = sc.nextLine();

        if (isValidTrainID(trainID)) {
            System.out.println("Valid Train ID ✔");
        } else {
            System.out.println("Invalid Train ID ✖");
        }

        // Input bogies
        System.out.print("\nEnter number of bogies: ");
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

        // Cargo Code validation
        System.out.print("\nEnter Cargo Code (Format CG-ABC123): ");
        String cargoCode = sc.nextLine();

        if (isValidCargoCode(cargoCode)) {
            System.out.println("Valid Cargo Code ✔");
        } else {
            System.out.println("Invalid Cargo Code ✖");
        }

        // Safety report
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

        sc.close();
    }
}