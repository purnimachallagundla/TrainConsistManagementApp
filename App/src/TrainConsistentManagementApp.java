import java.util.*;

// Coach class
class Coach {
    String coachId;
    String type; // Sleeper / AC / General
    int capacity;

    Coach(String coachId, String type, int capacity) {
        this.coachId = coachId;
        this.type = type;
        this.capacity = capacity;
    }

    public String toString() {
        return coachId + " (" + type + ", Capacity: " + capacity + ")";
    }
}

// Train class
class Train {
    String trainName;
    ArrayList<Coach> coaches;

    Train(String trainName) {
        this.trainName = trainName;
        coaches = new ArrayList<>();
    }

    // Add coach
    void addCoach(Coach c) {
        coaches.add(c);
    }

    // Display summary
    void displaySummary() {
        System.out.println("\nTrain: " + trainName);
        System.out.println("Total Coaches: " + coaches.size());

        for (Coach c : coaches) {
            System.out.println(c);
        }
    }
}

// Main class
public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> bogieIDs = new HashSet<>();

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input Bogie IDs with uniqueness check
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            if (bogieIDs.contains(id)) {
                System.out.println("Duplicate Bogie ID not allowed!");
                i--; // retry same index
            } else {
                bogieIDs.add(id);
                System.out.println("Bogie ID added successfully.");
            }
        }

        // Create train
        Train train = new Train("Express 101");

        // Add coaches
        train.addCoach(new Coach("S1", "Sleeper", 72));
        train.addCoach(new Coach("S2", "Sleeper", 72));
        train.addCoach(new Coach("AC1", "AC", 50));
        train.addCoach(new Coach("GEN1", "General", 100));

        // Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }

        // Display summary
        train.displaySummary();

        sc.close();
    }
}