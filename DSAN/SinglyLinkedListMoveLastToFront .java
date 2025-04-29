class SinglyLinkedListMoveLastToFront {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert at end
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

    // Move last node to front
    public void moveLastToFront() {
        if (head == null || head.next == null)
            return;

        Node secondLast = null;
        Node last = head;

        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }

        secondLast.next = null;
        last.next = head;
        head = last;
    }

    // Traverse the list
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedListMoveLastToFront list = new SinglyLinkedListMoveLastToFront();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Original List:");
        list.traverse();

        list.moveLastToFront();

        System.out.println("\nList after moving last node to front:");
        list.traverse();
    }
}
