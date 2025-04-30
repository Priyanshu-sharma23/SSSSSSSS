#include <stdio.h>
#include <string.h>

struct File {
    char name[20];
};

struct User {
    char username[20];
    struct File files[10];
    int fileCount;
};

int main() {
    struct User users[5];
    int userCount = 0;
    int choice;
    char username[20], filename[20];

    while (1) {
        printf("\n1. Create User\n2. Add File\n3. Display Files\n4. Exit\nEnter your choice: ");
        scanf("%d", &choice);

        if (choice == 1) {
            if (userCount < 5) {
                printf("Enter username: ");
                scanf("%s", users[userCount].username);
                users[userCount].fileCount = 0;
                userCount++;
            } else {
                printf("User limit reached!\n");
            }
        } else if (choice == 2) {
        	int i;
            printf("Enter username: ");
            scanf("%s", username);
            for (i = 0; i < userCount; i++) {
                if (strcmp(users[i].username, username) == 0) {
                    if (users[i].fileCount < 10) {
                        printf("Enter file name: ");
                        scanf("%s", users[i].files[users[i].fileCount].name);
                        users[i].fileCount++;
                    } else {
                        printf("File limit reached!\n");
                    }
                    break;
                }
            }
        } else if (choice == 3) {
        	int i,j;
            for (i = 0; i < userCount; i++) {
                printf("\nUser: %s\n", users[i].username);
                for (j = 0; j < users[i].fileCount; j++) {
                    printf("  %s\n", users[i].files[j].name);
                }
            }
        } else {
            break;
        }
    }
    return 0;
}

