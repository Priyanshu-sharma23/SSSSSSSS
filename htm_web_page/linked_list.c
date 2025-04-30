#include <stdio.h>
#include <stdlib.h>

typedef struct Block {
    int blockNumber;
    struct Block *next;
} Block;

Block* allocateFile(int blocks[], int size) {
    Block *head = NULL, *temp = NULL, *newBlock;
    int i;
    for ( i = 0; i < size; i++) {
        newBlock = (Block*)malloc(sizeof(Block));
        newBlock->blockNumber = blocks[i];
        newBlock->next = NULL;
        
        if (head == NULL) {
            head = newBlock;
            temp = head;
        } else {
            temp->next = newBlock;
            temp = newBlock;
        }
    }
    return head;
}

void displayFile(Block* head) {
    printf("File allocated at blocks: ");
    while (head) {
        printf("%d -> ", head->blockNumber);
        head = head->next;
    }
    printf("NULL\n");
}

int main() {
    int blocks1[] = {3, 5, 9, 12};  
    int blocks2[] = {2, 6, 8, 14, 20};

    Block* file1 = allocateFile(blocks1, 4);
    Block* file2 = allocateFile(blocks2, 5);

    displayFile(file1);
    displayFile(file2);

    return 0;
}

