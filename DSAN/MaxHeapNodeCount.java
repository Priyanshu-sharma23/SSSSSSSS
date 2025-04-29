public class MaxHeapNodeCount {

    // Method to count leaf nodes in a Max Heap
    public static int countLeafNodes(int[] arr, int n) {
        int count = 0;
        
        // Leaf nodes are at indices from n/2 to n-1
        for (int i = n / 2; i < n; i++) {
            count++;
        }
        return count;
    }

    // Method to count non-leaf nodes in a Max Heap
    public static int countNonLeafNodes(int[] arr, int n) {
        int count = 0;
        
        // Non-leaf nodes are from index 0 to n/2 - 1
        for (int i = 0; i < n / 2; i++) {
            count++;
        }
        return count;
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

        System.out.println("Max Heap:");
        printArray(maxHeapArr);

        int leafNodes = countLeafNodes(maxHeapArr, n);
        int nonLeafNodes = countNonLeafNodes(maxHeapArr, n);

        System.out.println("Number of Leaf Nodes: " + leafNodes);
        System.out.println("Number of Non-Leaf Nodes: " + nonLeafNodes);
    }
}
