public class HeapConstruction {

    // Method to heapify a subtree rooted at index i for Min Heap
    public static void heapifyMin(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is smaller than root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Check if right child is smaller than root
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not root, swap and heapify recursively
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapifyMin(arr, n, smallest);
        }
    }

    // Method to build Min Heap
    public static void buildMinHeap(int[] arr) {
        int n = arr.length;

        // Start heapifying from the last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMin(arr, n, i);
        }
    }

    // Method to heapify a subtree rooted at index i for Max Heap
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

    // Method to build Max Heap
    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        // Start heapifying from the last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMax(arr, n, i);
        }
    }

    // Method to print array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] minHeapArr = {12, 56, 3, 7, 9, 35, 11, 19, 25, 75};
        int[] maxHeapArr = {12, 56, 3, 7, 9, 35, 11, 19, 25, 75};

        // Building and displaying Min Heap
        System.out.println("Min Heap:");
        buildMinHeap(minHeapArr);
        printArray(minHeapArr);

        // Building and displaying Max Heap
        System.out.println("Max Heap:");
        buildMaxHeap(maxHeapArr);
        printArray(maxHeapArr);
    }
}
