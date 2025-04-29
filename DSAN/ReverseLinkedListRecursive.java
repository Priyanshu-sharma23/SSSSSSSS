class ReverseLinkedListRecursive {
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

    // Recursive function to reverse the linked list
    Node reverseRecursive(Node current) {
        // Base case: if head is null or only one node
        if (current == null || current.next == null) {
            return current;
        }

        Node newHead = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        
        return newHead;
    }

    // Function to start recursion and update head
    public void reverse() {
        head = reverseRecursive(head);
    }

    // Function to print the linked list
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ReverseLinkedListRecursive list = new ReverseLinkedListRecursive();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original Linked List:");
        list.traverse();

        list.reverse();

        System.out.println("Reversed Linked List (using recursion):");
        list.traverse();
    }
}
