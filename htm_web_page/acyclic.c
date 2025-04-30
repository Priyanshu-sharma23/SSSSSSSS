#include <stdio.h>
#include <string.h>

struct File {
    char name[20];
};

struct Directory {
    char name[20];
    struct File *files[10]; // Files are pointers, allowing shared links
    int fileCount;
    struct Directory *subdirs[5];
    int subdirCount;
};

void display(struct Directory *dir, int level) {
	int i,j;
    for (i = 0; i < level; i++) printf("  ");
    printf("Directory: %s\n", dir->name);

    for (i = 0; i < dir->fileCount; i++) {
        for (j = 0; j < level + 1; j++) printf("  ");
        printf("%s\n", dir->files[i]->name);
    }

    for (i = 0; i < dir->subdirCount; i++) {
        display(dir->subdirs[i], level + 1);
    }
}

int main() {
    struct Directory root;
    strcpy(root.name, "root");
    root.fileCount = 0;
    root.subdirCount = 0;

    struct File sharedFile;
    strcpy(sharedFile.name, "shared.txt");

    struct Directory dirA, dirB;
    strcpy(dirA.name, "dirA");
    strcpy(dirB.name, "dirB");

    dirA.fileCount = 0;
    dirA.subdirCount = 0;
    dirB.fileCount = 0;
    dirB.subdirCount = 0;

    // Both directories have a reference to the same file
    dirA.files[dirA.fileCount++] = &sharedFile;
    dirB.files[dirB.fileCount++] = &sharedFile;

    root.subdirs[root.subdirCount++] = &dirA;
    root.subdirs[root.subdirCount++] = &dirB;

    printf("Directory Structure with Acyclic Graph:\n");
    display(&root, 0);

    return 0;
}

