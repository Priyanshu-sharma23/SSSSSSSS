class ReverseLinkedListIterative {
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

    // Function to reverse the linked list iteratively
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;   // Save next node
            current.next = prev;   // Reverse current node's pointer
            prev = current;        // Move prev and current one step forward
            current = next;
        }
        head = prev;
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
        ReverseLinkedListIterative list = new ReverseLinkedListIterative();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Original Linked List:");
        list.traverse();

        list.reverse();

        System.out.println("Reversed Linked List:");
        list.traverse();
    }
}
