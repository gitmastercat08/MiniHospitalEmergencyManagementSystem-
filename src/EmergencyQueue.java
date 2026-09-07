public class EmergencyQueue {
    private class QueueNode {
        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Patient dequeue() {
        if (isEmpty()) {
            return null;
        }

        Patient patient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        QueueNode current = front;
        int position = 1;

        System.out.println("------------- WAITING PATIENTS -------------");
        while (current != null) {
            System.out.println(position + ". Patient ID: " + current.patient.getPatientId()
                    + " | Name: " + current.patient.getName()
                    + " | Condition: " + current.patient.getMedicalCondition());
            current = current.next;
            position++;
        }
        System.out.println("--------------------------------------------");
    }
}