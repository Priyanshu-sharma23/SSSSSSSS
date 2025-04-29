class CheckNonDescendingOrder {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Function to insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Function to check if the linked list is in non-descending order
    public boolean isNonDescending() {
        if (head == null || head.next == null) {
            return true; // Empty or single-node list is trivially sorted
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.data > temp.next.data) {
                return false; // Found a descending pair
            }
            temp = temp.next;
        }
        return true;
    }

    // Function to traverse and display the linked list
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        CheckNonDescendingOrder list = new CheckNonDescendingOrder();

        list.insert(10);
        list.insert(20);
        list.insert(20);
        list.insert(30);

        System.out.println("Linked List:");
        list.traverse();

        if (list.isNonDescending()) {
            System.out.println("The linked list is in non-descending order.");
        } else {
            System.out.println("The linked list is NOT in non-descending order.");
        }
    }
}
