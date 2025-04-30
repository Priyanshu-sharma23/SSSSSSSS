#include <stdio.h>

#define MAX_BLOCKS 10  // Maximum number of data blocks per file

typedef struct {
    int indexBlock;  
    int dataBlocks[MAX_BLOCKS];
    int count;
} File;

void allocateFile(File* file, int index, int blocks[], int size) {
    file->indexBlock = index;
    file->count = size;
    int i;
	for (i = 0; i < size; i++) {
        file->dataBlocks[i] = blocks[i];
    }
    printf("File allocated with index block at %d\n", index);
}

void displayFile(File file) {
    printf("Index Block: %d\n", file.indexBlock);
    printf("Data Blocks: ");
    int i;
	for (i = 0; i < file.count; i++) {
        printf("%d ", file.dataBlocks[i]);
    }
    printf("\n");
}

int main() {
    File file1;
    int data1[] = {5, 9, 13, 18};

    allocateFile(&file1, 2, data1, 4);
    displayFile(file1);

    return 0;
}

