class DoublyLinkedList {
    // Node class to represent each element
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail pointers
    Node head, tail;

    // Constructor to initialize the doubly linked list
    public DoublyLinkedList() {
        head = tail = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // If the list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {  // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 1;

        // If inserting at the beginning
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // If position is greater than the length of the list
        if (current == null) {
            System.out.println("Position exceeds list length");
            return;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {  // Only one element in the list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {  // Only one element in the list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete from a specific position
    public void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or empty list");
            return;
        }

        Node current = head;
        int count = 1;

        // If deleting the first node
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        // If position is greater than the length of the list
        if (current == null) {
            System.out.println("Position exceeds list length");
            return;
        }

        // If deleting the last node
        if (current == tail) {
            deleteFromEnd();
            return;
        }

        // Re-link the previous and next nodes
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    // Traverse and print the list
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert elements at different positions
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 3);  // Insert 15 at position 3

        // Traverse the list
        System.out.println("List after insertions:");
        list.traverse();

        // Delete elements from different positions
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteAtPosition(2);  // Delete element at position 2

        // Traverse the list again
        System.out.println("List after deletions:");
        list.traverse();
    }
}
