public class VisitLinkedList {
    private class VisitNode {
        Visit visit;
        VisitNode next;

        VisitNode(Visit visit) {
            this.visit = visit;
        }
    }

    private VisitNode head;

    public void addVisit(Visit visit) {
        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        VisitNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Visit searchVisit(String visitId) {
        VisitNode current = head;

        while (current != null) {
            if (current.visit.getVisitId().equalsIgnoreCase(visitId)) {
                return current.visit;
            }
            current = current.next;
        }

        return null;
    }

    public boolean removeVisit(String visitId) {
        if (head == null) {
            return false;
        }

        if (head.visit.getVisitId().equalsIgnoreCase(visitId)) {
            head = head.next;
            return true;
        }

        VisitNode current = head;

        while (current.next != null) {
            if (current.next.visit.getVisitId().equalsIgnoreCase(visitId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("No previous visits found.");
            return;
        }

        VisitNode current = head;
        int number = 1;

        System.out.println("--------------- VISIT HISTORY ---------------");
        while (current != null) {
            System.out.println(number + ". " + current.visit);
            current = current.next;
            number++;
        }
        System.out.println("---------------------------------------------");
    }
}