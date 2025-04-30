#include <stdio.h>
#include <string.h>
struct File {
    char name[20];
};
int main() {
    struct File files[10];
    int count = 0;
    int choice;
    char filename[20];
	int i;
    while (1) {
        printf("\n1. Create File\n2. Display Files\n3. Exit\nEnter your choice: ");
        scanf("%d", &choice);

        if (choice == 1) {
            if (count < 10) {
                printf("Enter file name: ");
                scanf("%s", files[count].name);
                count++;
            } else {
                printf("Directory is full!\n");
            }
        } else if (choice == 2) {
            printf("\nFiles in directory:\n");
            for ( i = 0; i < count; i++) {
                printf("%s\n", files[i].name);
            }
        } else {
            break;
        }
    }
    return 0;
}

