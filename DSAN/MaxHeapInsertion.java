public class MaxHeapInsertion {

    // Method to heapify the Max Heap
    public static void heapifyMax(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger than root
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and heapify recursively
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyMax(arr, n, largest);
        }
    }

    // Method to insert a new element into Max Heap
    public static void insertMaxHeap(int[] arr, int n, int value) {
        // First insert the value at the end
        arr[n] = value;
        int i = n;

        // Move the inserted element up to restore the heap property
        while (i > 0 && arr[(i - 1) / 2] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[(i - 1) / 2];
            arr[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    // Method to print array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] maxHeapArr = {75, 56, 35, 19, 25, 12, 11, 7, 3, 9};
        int n = maxHeapArr.length;

        System.out.println("Original Max Heap:");
        printArray(maxHeapArr);

        // Insert 20 into Max Heap
        insertMaxHeap(maxHeapArr, n, 20);
        n++;

        System.out.println("Max Heap after inserting 20:");
        printArray(maxHeapArr);
    }
}
