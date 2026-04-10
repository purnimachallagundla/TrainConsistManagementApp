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
        System.out.println("Train: " + trainName);
        System.out.println("Total Coaches: " + coaches.size());

        for (Coach c : coaches) {
            System.out.println(c);
        }
    }
}

// Main class
public class TrainConsistentManagementApp {

    public static void main(String[] args) {

        Train train = new Train("Express 101");

        // Add coaches
        train.addCoach(new Coach("S1", "Sleeper", 72));
        train.addCoach(new Coach("S2", "Sleeper", 72));
        train.addCoach(new Coach("AC1", "AC", 50));
        train.addCoach(new Coach("GEN1", "General", 100));

        // Display summary
        train.displaySummary();
    }
}