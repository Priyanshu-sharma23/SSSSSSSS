import java.util.*;

class SinglyLinkedListSort {
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

    // Sort the linked list
    public void sort(boolean ascending) {
        if (head == null || head.next == null)
            return;

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if ((ascending && i.data > j.data) || (!ascending && i.data < j.data)) {
                    // Swap data
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
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
        SinglyLinkedListSort list = new SinglyLinkedListSort();

        list.insert(5);
        list.insert(2);
        list.insert(8);
        list.insert(1);

        System.out.println("Original List:");
        list.traverse();

        list.sort(true);  // true = ascending
        System.out.println("\nList after Ascending Sort:");
        list.traverse();

        list.sort(false); // false = descending
        System.out.println("\nList after Descending Sort:");
        list.traverse();
    }
}
