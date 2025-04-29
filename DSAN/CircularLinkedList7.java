class CircularLinkedList7 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node last = null;

    // Function to add a node to the empty list
    public void addToEmpty(int data) {
        if (last != null) {
            return;
        }
        Node newNode = new Node(data);
        last = newNode;
        last.next = last; // Point to itself
    }

    // Function to add node at the end
    public void addEnd(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }

    // Function to add node at the beginning
    public void addBegin(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
    }

    // Function to traverse the Circular Linked List
    public void traverse() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = last.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList7 cll = new CircularLinkedList7();

        cll.addToEmpty(10);
        cll.addEnd(20);
        cll.addEnd(30);
        cll.addBegin(5);

        System.out.println("Circular Linked List:");
        cll.traverse();
    }
}
