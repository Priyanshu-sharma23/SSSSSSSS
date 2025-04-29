class Stack {
    // Node class to represent each element in the stack
    class Node {
        int data;
        Node next;

        // Constructor to initialize a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // Top node of the stack

    // Constructor to initialize the stack
    public Stack() {
        top = null;
    }

    // Push operation to insert an element into the stack
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode; // If stack is empty, new node becomes the top
        } else {
            newNode.next = top; // Point new node to the current top
            top = newNode; // Make new node the top
        }
        System.out.println("Pushed " + data);
    }

    // Pop operation to remove the top element from the stack
    public void pop() {
        if (top == null) {
            System.out.println("Stack Underflow! Unable to pop");
        } else {
            int poppedData = top.data;  // Get the top element
            top = top.next;  // Move the top to the next node
            System.out.println("Popped " + poppedData);
        }
    }

    // Display the elements in the stack
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            Node current = top;
            System.out.print("Stack: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        // Create a stack object
        Stack stack = new Stack();

        // Perform stack operations
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Display the stack
        stack.display();

        // Perform pop operations
        stack.pop();
        stack.pop();

        // Display the stack after popping elements
        stack.display();
    }
}
