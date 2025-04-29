public class HashTableWithDoubleHashing {

    static final int SIZE = 10;
    int[] table = new int[SIZE];

    // Constructor to initialize the hash table
    public HashTableWithDoubleHashing() {
        for (int i = 0; i < SIZE; i++) {
            table[i] = -1;  // -1 denotes an empty slot
        }
    }

    // First hash function: h1(x) = x % SIZE
    public int hashFunction1(int key) {
        return key % SIZE;
    }

    // Second hash function: h2(x) = 1 + (x % (SIZE - 1))
    public int hashFunction2(int key) {
        return 1 + (key % (SIZE - 1));
    }

    // Method to insert key into hash table using double hashing
    public void insert(int key) {
        int index = hashFunction1(key);  // Primary hash function
        int stepSize = hashFunction2(key);  // Step size from secondary hash function

        // Resolve collision using double hashing
        while (table[index] != -1) {
            index = (index + stepSize) % SIZE;
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
        HashTableWithDoubleHashing hashTable = new HashTableWithDoubleHashing();
        
        // Elements to insert into the hash table
        int[] keys = {17, 16, 22, 36, 33, 46, 26, 144};
        
        // Insert the elements into the hash table
        for (int key : keys) {
            hashTable.insert(key);
        }

        // Display the hash table
        System.out.println("Hash Table using Double Hashing:");
        hashTable.displayHashTable();
    }
}
