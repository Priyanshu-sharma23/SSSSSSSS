import java.util.Stack;

class QueueUsingTwoStacks {
    private Stack<Integer> stack1; // Stack for enqueue operations
    private Stack<Integer> stack2; // Stack for dequeue operations

    // Constructor to initialize the two stacks
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueued " + data);
    }

    // Dequeue operation to remove an element from the queue
    public void dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue Underflow! Unable to dequeue");
            return;
        }

        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is not empty, pop from stack2
        if (!stack2.isEmpty()) {
            int dequeuedData = stack2.pop();
            System.out.println("Dequeued " + dequeuedData);
        }
    }

    // Peek operation to view the front element of the queue
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // The top element of stack2 is the front of the queue
        return stack2.peek();
    }

    // Display the elements in the queue
    public void display() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue: ");
            // Display elements in stack2 first
            Stack<Integer> tempStack = new Stack<>();
            while (!stack2.isEmpty()) {
                tempStack.push(stack2.pop());
            }
            while (!tempStack.isEmpty()) {
                System.out.print(tempStack.pop() + " ");
            }
            // Display elements in stack1
            for (int element : stack1) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        // Create a queue object
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Perform queue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Display the queue
        queue.display();

        // Perform dequeue operations
        queue.dequeue();
        queue.dequeue();

        // Display the queue after dequeuing
        queue.display();

        // Peek operation
        System.out.println("Front element is: " + queue.peek());

        // Enqueue again after dequeuing some elements
        queue.enqueue(60);
        queue.enqueue(70);

        // Final display of the queue
        queue.display();
    }
}
