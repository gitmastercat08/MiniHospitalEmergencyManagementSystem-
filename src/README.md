# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms

This is a Java console-based mini hospital system developed for the CIT300 individual assignment.

### Data Structures Used

1. **Binary Search Tree (BST)**
   - Stores patient records using Patient ID as the key.
   - Supports insertion, searching, deletion and in-order traversal.

2. **Queue**
   - Stores emergency patients waiting for treatment.
   - Uses FIFO (First In, First Out).
   - Supports enqueue, dequeue and display.

3. **Stack**
   - Stores completed treatment records.
   - Uses LIFO (Last In, First Out).
   - Supports push, pop and display.

4. **Singly Linked List**
   - Stores previous visits for each patient.
   - Supports adding, searching, removing and displaying visits.

## Project Structure

```text
src/
├── Patient.java
├── PatientBST.java
├── EmergencyQueue.java
├── TreatmentRecord.java
├── TreatmentStack.java
├── Visit.java
├── VisitLinkedList.java
├── HospitalSystem.java
└── Main.java
```

## How to Run

Open the `src` folder in a terminal and run:

```bash
javac *.java
java Main
```

The application is menu-driven and runs in the console.

## Suggested Test Flow

1. Register 3 or 4 patients.
2. Search for one patient.
3. Display patients using BST in-order traversal.
4. Delete a patient and display the BST again.
5. Add several patients to the emergency queue.
6. Treat the next patient to demonstrate FIFO.
7. Add completed treatments and pop one to demonstrate LIFO.
8. Add several visits for a patient.
9. Search, remove and display visits to demonstrate the singly linked list.

## Academic Note

This project is intended as a learning implementation. The student should understand every class and operation, test the program personally, and adapt naming, validation and design decisions to their own understanding before submission.
