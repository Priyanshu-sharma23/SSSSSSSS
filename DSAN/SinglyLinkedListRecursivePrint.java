class SinglyLinkedListRecursivePrint {
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

    // Recursive function to print list
    public void printRecursively(Node node) {
        if (node == null) {
            System.out.println("NULL");
            return;
        }
        System.out.print(node.data + " -> ");
        printRecursively(node.next);
    }

    public void startPrint() {
        printRecursively(head);
    }

    public static void main(String[] args) {
        SinglyLinkedListRecursivePrint list = new SinglyLinkedListRecursivePrint();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.println("Linked List printed recursively:");
        list.startPrint();
    }
}
