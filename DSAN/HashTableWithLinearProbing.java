public class HashTableWithLinearProbing {

    static final int SIZE = 10;
    int[] table = new int[SIZE];

    // Constructor to initialize the hash table
    public HashTableWithLinearProbing() {
        for (int i = 0; i < SIZE; i++) {
            table[i] = -1;  // -1 denotes an empty slot
        }
    }

    // Hash function: h(x) = x % SIZE
    public int hashFunction(int key) {
        return key % SIZE;
    }

    // Method to insert key into hash table using linear probing
    public void insert(int key) {
        int index = hashFunction(key);  // Primary hash function

        // Resolve collision using linear probing
        while (table[index] != -1) {
            index = (index + 1) % SIZE;  // Move to the next index
        }
        table[index] = key;
    }

    // Method to display the hash table
    public void displayHashTable() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i] != -1) {
                System.out.print(table[i]);
            } else {
                System.out.print("Empty");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTableWithLinearProbing hashTable = new HashTableWithLinearProbing();
        
        // Elements to insert into the hash table
        int[] keys = {17, 16, 22, 36, 33, 46, 26, 144};
        
        // Insert the elements into the hash table
        for (int key : keys) {
            hashTable.insert(key);
        }

        // Display the hash table
        System.out.println("Hash Table using Linear Probing:");
        hashTable.displayHashTable();
    }
}
