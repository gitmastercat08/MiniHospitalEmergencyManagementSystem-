public class TreatmentStack {
    private class StackNode {
        TreatmentRecord record;
        StackNode next;

        StackNode(TreatmentRecord record) {
            this.record = record;
        }
    }

    private StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            return null;
        }

        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        StackNode current = top;
        int number = 1;

        System.out.println("----------- TREATMENT HISTORY (TOP FIRST) -----------");
        while (current != null) {
            System.out.println(number + ". " + current.record);
            current = current.next;
            number++;
        }
        System.out.println("-----------------------------------------------------");
    }
}