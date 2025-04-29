import java.util.*;

public class BucketSort {
    public static void bucketSort(int[] arr, int numberOfBuckets) {
        if (arr.length == 0)
            return;

        // 1. Find maximum and minimum values
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int num : arr) {
            if (num > maxValue) maxValue = num;
            if (num < minValue) minValue = num;
        }

        // 2. Initialize buckets
        List<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 3. Distribute input array values into buckets
        for (int num : arr) {
            int bucketIndex = (num - minValue) * (numberOfBuckets - 1) / (maxValue - minValue);
            buckets[bucketIndex].add(num);
        }

        // 4. Sort individual buckets
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 5. Merge all buckets into original array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 56, 3, 7, 9, 35, 11, 19, 25, 75};

        System.out.println("Original array:");
        printArray(arr);

        bucketSort(arr, 5);  // You can change the number of buckets

        System.out.println("Sorted array using Bucket Sort:");
        printArray(arr);
    }
}
