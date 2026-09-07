import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HospitalSystem {
    private final Scanner scanner;
    private final PatientBST patientBST;
    private final EmergencyQueue emergencyQueue;
    private final TreatmentStack treatmentStack;
    private final Map<Integer, VisitLinkedList> visitHistories;

    public HospitalSystem() {
        scanner = new Scanner(System.in);
        patientBST = new PatientBST();
        emergencyQueue = new EmergencyQueue();
        treatmentStack = new TreatmentStack();
        visitHistories = new HashMap<>();
    }

    public void start() {
        int choice;

        do {
            printMainMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    emergencyQueueMenu();
                    break;
                case 3:
                    treatmentMenu();
                    break;
                case 4:
                    visitHistoryMenu();
                    break;
                case 5:
                    patientBST.displayInOrder();
                    break;
                case 0:
                    System.out.println("\nThank you for using the Mini Hospital System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("\n==================================================");
        System.out.println("       MINI HOSPITAL EMERGENCY MANAGEMENT");
        System.out.println("==================================================");
        System.out.println("1. Patient Management (BST)");
        System.out.println("2. Emergency Patient Queue");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("5. Display All Patients");
        System.out.println("0. Exit");
        System.out.println("==================================================");
    }

    private void patientMenu() {
        int choice;

        do {
            System.out.println("\n--------------- PATIENT MANAGEMENT ---------------");
            System.out.println("1. Register New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients (In-order)");
            System.out.println("0. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    searchPatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    patientBST.displayInOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void registerPatient() {
        int id = readInt("Patient ID: ");

        if (patientBST.search(id) != null) {
            System.out.println("A patient with this ID already exists.");
            return;
        }

        String name = readText("Patient Name: ");
        int age = readInt("Age: ");
        String contact = readText("Contact Number: ");
        String condition = readText("Medical Condition: ");

        Patient patient = new Patient(id, name, age, contact, condition);

        if (patientBST.insert(patient)) {
            visitHistories.put(id, new VisitLinkedList());
            System.out.println("Patient registered successfully.");
        }
    }

    private void searchPatient() {
        int id = readInt("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("\nPatient found:");
            System.out.println(patient);
        }
    }

    private void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");

        if (patientBST.delete(id)) {
            visitHistories.remove(id);
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void emergencyQueueMenu() {
        int choice;

        do {
            System.out.println("\n---------------- EMERGENCY QUEUE ----------------");
            System.out.println("1. Enqueue Patient");
            System.out.println("2. Dequeue / Treat Next Patient");
            System.out.println("3. Display Waiting Patients");
            System.out.println("0. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    enqueuePatient();
                    break;
                case 2:
                    treatNextPatient();
                    break;
                case 3:
                    emergencyQueue.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void enqueuePatient() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found. Register the patient first.");
            return;
        }

        emergencyQueue.enqueue(patient);
        System.out.println("Patient added to the emergency queue (FIFO).");
    }

    private void treatNextPatient() {
        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            System.out.println("No patients are waiting in the emergency queue.");
            return;
        }

        System.out.println("Now treating Patient " + patient.getPatientId()
                + " - " + patient.getName());

        String doctor = readText("Doctor Name: ");
        String treatment = readText("Treatment Given: ");
        String date = readText("Treatment Date: ");

        TreatmentRecord record = new TreatmentRecord(
                patient.getPatientId(),
                patient.getName(),
                doctor,
                treatment,
                date
        );

        treatmentStack.push(record);
        System.out.println("Treatment completed and record pushed to the stack.");
    }

    private void treatmentMenu() {
        int choice;

        do {
            System.out.println("\n--------------- TREATMENT HISTORY ---------------");
            System.out.println("1. Push Completed Treatment");
            System.out.println("2. Pop Latest Treatment");
            System.out.println("3. Display Treatment Records");
            System.out.println("0. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addTreatmentRecord();
                    break;
                case 2:
                    removeLatestTreatment();
                    break;
                case 3:
                    treatmentStack.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void addTreatmentRecord() {
        int id = readInt("Patient ID: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        String doctor = readText("Doctor Name: ");
        String treatment = readText("Treatment: ");
        String date = readText("Date: ");

        treatmentStack.push(new TreatmentRecord(
                id, patient.getName(), doctor, treatment, date
        ));

        System.out.println("Treatment record pushed successfully.");
    }

    private void removeLatestTreatment() {
        TreatmentRecord record = treatmentStack.pop();

        if (record == null) {
            System.out.println("Treatment history is empty.");
        } else {
            System.out.println("Removed latest treatment:");
            System.out.println(record);
        }
    }

    private void visitHistoryMenu() {
        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history = visitHistories.get(patientId);

        int choice;
        do {
            System.out.println("\n------------ VISIT HISTORY ------------");
            System.out.println("1. Add Visit");
            System.out.println("2. Search Visit");
            System.out.println("3. Remove Visit");
            System.out.println("4. Display Visit History");
            System.out.println("0. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addVisit(history);
                    break;
                case 2:
                    searchVisit(history);
                    break;
                case 3:
                    removeVisit(history);
                    break;
                case 4:
                    history.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void addVisit(VisitLinkedList history) {
        String visitId = readText("Visit ID: ");
        String date = readText("Visit Date: ");
        String doctor = readText("Doctor Name: ");
        String diagnosis = readText("Diagnosis: ");
        String treatment = readText("Treatment: ");

        history.addVisit(new Visit(visitId, date, doctor, diagnosis, treatment));
        System.out.println("Visit added to the linked list.");
    }

    private void searchVisit(VisitLinkedList history) {
        String visitId = readText("Enter Visit ID: ");
        Visit visit = history.searchVisit(visitId);

        if (visit == null) {
            System.out.println("Visit not found.");
        } else {
            System.out.println("Visit found:");
            System.out.println(visit);
        }
    }

    private void removeVisit(VisitLinkedList history) {
        String visitId = readText("Enter Visit ID to remove: ");

        if (history.removeVisit(visitId)) {
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    private int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}