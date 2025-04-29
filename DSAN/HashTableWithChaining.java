import java.util.LinkedList;

public class HashTableWithChaining {

    // Hash table size
    static final int SIZE = 10;
    
    // Create an array of LinkedLists to store elements at each index
    LinkedList<Integer>[] table = new LinkedList[SIZE];

    // Constructor to initialize the table
    public HashTableWithChaining() {
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to map values to a specific index
    public int hashFunction(int key) {
        return key % SIZE;
    }

    // Method to insert key into hash table
    public void insert(int key) {
        int index = hashFunction(key);
        table[index].add(key);  // Add key to the list at the hashed index
    }

    // Method to calculate the minimum, maximum, and average chain length
    public void calculateChainLengths() {
        int minLength = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE, totalChains = 0, totalElements = 0;

        for (int i = 0; i < SIZE; i++) {
            int chainLength = table[i].size();
            if (chainLength > 0) {
                totalChains++;
                totalElements += chainLength;
                minLength = Math.min(minLength, chainLength);
                maxLength = Math.max(maxLength, chainLength);
            }
        }

        // Calculate average chain length
        double avgLength = totalChains > 0 ? (double) totalElements / totalChains : 0;

        System.out.println("Minimum Chain Length: " + minLength);
        System.out.println("Maximum Chain Length: " + maxLength);
        System.out.println("Average Chain Length: " + avgLength);
    }

    // Method to display the hash table
    public void displayHashTable() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            for (Integer key : table[i]) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTableWithChaining hashTable = new HashTableWithChaining();
        
        // Insert the keys into the hash table
        int[] keys = {5, 28, 19, 15, 20, 33, 12, 17, 10};
        for (int key : keys) {
            hashTable.insert(key);
        }

        // Display the hash table
        System.out.println("Hash Table:");
        hashTable.displayHashTable();

        // Calculate and display the chain lengths
        System.out.println("\nChain Lengths:");
        hashTable.calculateChainLengths();
    }
}
