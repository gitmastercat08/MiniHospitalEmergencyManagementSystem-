# Mini Hospital Emergency Management System

This is a Java console-based Mini Hospital Emergency Management System developed for the individual assignment. The system demonstrates the use of four important data structures to manage patient records, emergency patients, treatment history, and patient visit history.

## Data Structures Used

### 1. Binary Search Tree (BST)

The Binary Search Tree stores patient records using the Patient ID as the key.

Operations supported:

* Insert a patient
* Search for a patient
* Delete a patient
* Display patients using in-order traversal

The in-order traversal displays patient IDs in ascending order.

### 2. Queue

The Queue manages emergency patients who are waiting for treatment.

Operations supported:

* Enqueue a patient
* Dequeue the next patient
* Display waiting patients
* Handle an empty queue

The Queue follows FIFO (First In, First Out).

### 3. Stack

The Stack stores completed treatment records.

Operations supported:

* Push a treatment record
* Pop the latest treatment record
* Display treatment history
* Handle an empty stack

The Stack follows LIFO (Last In, First Out).

### 4. Singly Linked List

The Singly Linked List stores previous visits for each patient.

Each visit contains:

* Visit ID
* Visit Date
* Doctor Name
* Diagnosis
* Treatment

Operations supported:

* Add a visit
* Search for a visit
* Remove a visit
* Display visit history

## Main Features

* Patient registration and management
* Patient searching and deletion
* Emergency patient queue management
* Treatment history management
* Patient visit history management
* Empty queue and stack handling
* Menu-driven console interface

## Project Structure

```text
MiniHospitalEmergencyManagementSystem/
│
├── src/
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   ├── VisitLinkedList.java
│   ├── HospitalSystem.java
│   └── Main.java
│
├── .gitignore
└── README.md
```

## How to Run

Open a terminal in the `src` folder.

Compile the Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

The application is menu-driven and runs in the console.

## Testing

The following operations were tested:

1. Register patient records.
2. Search for a patient using Patient ID.
3. Display patients using BST in-order traversal.
4. Delete a patient and display the updated BST.
5. Add patients to the emergency queue.
6. Dequeue patients to demonstrate FIFO.
7. Add treatment records to the stack.
8. Pop treatment records to demonstrate LIFO.
9. Test empty queue and empty stack handling.
10. Add multiple visits for a patient.
11. Search for a visit.
12. Remove a visit.
13. Display patient visit history.

## GitHub Development

The project was developed and maintained using Git and GitHub. Meaningful changes were committed during development and testing.

Example development commits include:

* Created project structure
* Tested hospital management system
* Added gitignore for compiled Java files

## Academic Purpose

This project was developed as an individual learning project for CIT300 Data Structures and Algorithms. The implementation demonstrates practical use of a Binary Search Tree, Queue, Stack, and Singly Linked List in a hospital management scenario.

The student should understand the implementation, test the program, and be able to explain the design and operations during the demonstration.
