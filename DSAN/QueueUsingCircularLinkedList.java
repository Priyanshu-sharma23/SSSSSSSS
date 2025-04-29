class Queue {
    // Node class to represent each element in the queue
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    // Constructor to initialize the queue
    public Queue() {
        front = rear = null; // Initially both front and rear are null
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
            rear.next = front; // Point the last node to the front (circular)
        } else {
            rear.next = newNode; // Link the new node to the last node
            rear = newNode; // Update the rear to the new node
            rear.next = front; // Circular link: last node points to front
        }
        System.out.println("Enqueued " + data);
    }

    // Dequeue operation to remove an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Unable to dequeue");
        } else {
            int dequeuedData = front.data; // Get the data from the front node
            if (front == rear) {
                front = rear = null; // If only one element was in the queue
            } else {
                front = front.next; // Move front to the next node
                rear.next = front; // Circular link: rear points to new front
            }
            System.out.println("Dequeued " + dequeuedData);
        }
    }

    // Display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node current = front;
            System.out.print("Queue: ");
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != front); // Circular condition: stop when we reach the front again
            System.out.println();
        }
    }
}

public class QueueUsingCircularLinkedList {
    public static void main(String[] args) {
        // Create a queue object
        Queue queue = new Queue();

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

        // Enqueue again after dequeuing some elements
        queue.enqueue(60);
        queue.enqueue(70);

        // Final display of the queue
        queue.display();
    }
}
