import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Hospita_emergency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedList<String> patients = new LinkedList<>();

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            int severityA = Integer.parseInt(a.split(",")[2]);
            int severityB = Integer.parseInt(b.split(",")[2]);
            return severityB - severityA;
        });

        int id = 101;
        int choice;

        do {
            System.out.println("\n1. Register patient");
            System.out.println("2. Call next patient");
            System.out.println("3. Search patient");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter patient name: ");
                String name = input.nextLine();

                System.out.print("Enter severity (1-5): ");
                int severity = input.nextInt();
                input.nextLine();

                if (severity < 1 || severity > 5) {
                    System.out.println("Severity must be from 1 to 5.");
                } else {
                    String patient = "P" + id + "," + name + "," + severity;
                    patients.add(patient);
                    queue.add(patient);

                    System.out.println("Patient added: P" + id + " | "
                            + name + " | Severity " + severity);
                    id++;
                }

            } else if (choice == 2) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    String patient = queue.poll();
                    String[] details = patient.split(",");

                    patients.remove(patient);

                    System.out.println("Calling " + details[0] + " | "
                            + details[1] + " | Severity " + details[2]);
                }

            } else if (choice == 3) {
                System.out.print("Enter patient ID: ");
                String searchId = input.nextLine();

                boolean found = false;

                for (String patient : patients) {
                    if (patient.startsWith(searchId + ",")) {
                        System.out.println("Patient found: " + patient);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Patient " + searchId + " not found.");
                }
            }

        } while (choice != 4);

        System.out.println("Sayonara!"); 
        System.out.println("Take Care");
    }
}
