class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1; // Stack is initially empty
    }

    // Push operation to insert an element into the stack
    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Unable to push " + data);
        } else {
            stack[++top] = data; // Increment top and insert element
            System.out.println("Pushed " + data);
        }
    }

    // Pop operation to remove the top element from the stack
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Unable to pop");
        } else {
            int poppedElement = stack[top--]; // Remove element and decrement top
            System.out.println("Popped " + poppedElement);
        }
    }

    // Display the elements in the stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        // Create a stack with a maximum size of 5
        Stack stack = new Stack(5);

        // Perform stack operations
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Display the stack
        stack.display();

        // Attempt to push beyond the capacity
        stack.push(60);

        // Perform pop operations
        stack.pop();
        stack.pop();

        // Display the stack after popping elements
        stack.display();
    }
}
