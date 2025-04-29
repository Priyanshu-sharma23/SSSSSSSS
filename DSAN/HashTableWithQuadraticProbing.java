public class HashTableWithQuadraticProbing {

    static final int SIZE = 10;
    int[] table = new int[SIZE];

    // Constructor to initialize the hash table
    public HashTableWithQuadraticProbing() {
        for (int i = 0; i < SIZE; i++) {
            table[i] = -1;  // -1 denotes an empty slot
        }
    }

    // Hash function: h(x) = x % SIZE
    public int hashFunction(int key) {
        return key % SIZE;
    }

    // Method to insert key into hash table using quadratic probing
    public void insert(int key) {
        int index = hashFunction(key);  // Primary hash function
        int i = 1;

        // Resolve collision using quadratic probing: index + i^2
        while (table[index] != -1) {
            index = (index + i * i) % SIZE;  // Quadratic probing formula
            i++;
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
        HashTableWithQuadraticProbing hashTable = new HashTableWithQuadraticProbing();
        
        // Elements to insert into the hash table
        int[] keys = {17, 16, 22, 36, 33, 46, 26, 144};
        
        // Insert the elements into the hash table
        for (int key : keys) {
            hashTable.insert(key);
        }

        // Display the hash table
        System.out.println("Hash Table using Quadratic Probing:");
        hashTable.displayHashTable();
    }
}
