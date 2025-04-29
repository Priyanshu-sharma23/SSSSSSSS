class Queue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue with a given capacity
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = -1;  // Initially both front and rear are -1
        size = 0;  // No elements initially
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow! Unable to enqueue " + data);
        } else {
            if (front == -1) {
                front = 0; // First element is inserted
            }
            rear = (rear + 1) % capacity;  // Circular increment
            queue[rear] = data;
            size++;
            System.out.println("Enqueued " + data);
        }
    }

    // Dequeue operation to remove an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Unable to dequeue");
        } else {
            int dequeuedData = queue[front];
            front = (front + 1) % capacity;  // Circular increment
            size--;
            System.out.println("Dequeued " + dequeuedData);
        }
    }

    // Display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue: ");
            int count = size;
            int i = front;
            while (count > 0) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % capacity;  // Circular increment
                count--;
            }
            System.out.println();
        }
    }
}

public class QueueUsingCircularArray {
    public static void main(String[] args) {
        // Create a queue with a capacity of 5
        Queue queue = new Queue(5);

        // Perform queue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Display the queue
        queue.display();

        // Attempt to enqueue when the queue is full
        queue.enqueue(60);

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
