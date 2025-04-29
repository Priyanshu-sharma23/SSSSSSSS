public class MaxHeapDeletion {

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

    // Method to delete the root (maximum) from Max Heap
    public static void deleteMax(int[] arr, int n) {
        // Replace the root with the last element
        arr[0] = arr[n - 1];
        
        // Decrease the heap size by 1
        n = n - 1;

        // Call heapify to restore the heap property
        heapifyMax(arr, n, 0);
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

        // Delete the maximum element (root) and reheapify
        deleteMax(maxHeapArr, n);

        System.out.println("Max Heap after deleting the maximum element:");
        printArray(maxHeapArr);
    }
}
