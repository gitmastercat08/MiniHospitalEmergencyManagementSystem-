public class PatientBST {
    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    public boolean insert(Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return true;
        }

        Node current = root;

        while (true) {
            if (patient.getPatientId() == current.patient.getPatientId()) {
                return false;
            }

            if (patient.getPatientId() < current.patient.getPatientId()) {
                if (current.left == null) {
                    current.left = new Node(patient);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(patient);
                    return true;
                }
                current = current.right;
            }
        }
    }

    public Patient search(int id) {
        Node current = root;

        while (current != null) {
            if (id == current.patient.getPatientId()) {
                return current.patient;
            }

            current = id < current.patient.getPatientId()
                    ? current.left : current.right;
        }

        return null;
    }

    public boolean delete(int id) {
        Node parent = null;
        Node current = root;

        while (current != null && current.patient.getPatientId() != id) {
            parent = current;
            current = id < current.patient.getPatientId()
                    ? current.left : current.right;
        }

        if (current == null) {
            return false;
        }

        // Case 1: no child
        if (current.left == null && current.right == null) {
            replaceChild(parent, current, null);
        }
        // Case 2: only right child
        else if (current.left == null) {
            replaceChild(parent, current, current.right);
        }
        // Case 3: only left child
        else if (current.right == null) {
            replaceChild(parent, current, current.left);
        }
        // Case 4: two children
        else {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.patient = successor.patient;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        return true;
    }

    private void replaceChild(Node parent, Node oldNode, Node newNode) {
        if (parent == null) {
            root = newNode;
        } else if (parent.left == oldNode) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-8s %-18s %-5s %-15s %-20s%n",
                "ID", "Name", "Age", "Contact", "Condition");
        System.out.println("--------------------------------------------------------------------------");
        inOrder(root);
        System.out.println("--------------------------------------------------------------------------");
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.patient);
        inOrder(node.right);
    }
}