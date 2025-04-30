#include <stdio.h>
#include <stdbool.h>

#define SIZE 100  // Total disk size in blocks

int disk[SIZE];  // Simulating the disk (0 = free, 1 = allocated)

void allocateFile(int start, int length) {
    // Check if space is available
    int i;
	for (i = start; i < start + length; i++) {
        if (disk[i] == 1) { 
            printf("Error: Blocks already allocated. Choose another start.\n");
            return;
        }
    }

    // Allocate space
    for (i = start; i < start + length; i++) {
        disk[i] = 1;
    }
    printf("File allocated from block %d to %d\n", start, start + length - 1);
}

void displayDisk() {
    printf("Disk Status: \n");
    int i;
	for (i = 0; i < SIZE; i++) {
        printf("%d", disk[i]);
    }
    printf("\n");
}

int main() {
    int i;
	for (i = 0; i < SIZE; i++) disk[i] = 0;  // Initialize disk (all blocks free)

    allocateFile(10, 5);
    allocateFile(20, 7);
    allocateFile(12, 3);  // Overlapping test

    displayDisk();
    return 0;
}

