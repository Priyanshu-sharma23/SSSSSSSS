#include <stdio.h>
#include <string.h>

struct File {
    char name[20];
};

struct Directory {
    char name[20];
    struct File files[10];
    int fileCount;
    struct Directory *subdirs[5];
    int subdirCount;
};

void display(struct Directory *dir, int level) {
	int i,j;
    for (i = 0; i < level; i++) printf("  ");
    printf("Directory: %s\n", dir->name);

    for (i = 0; i < dir->fileCount; i++) {
        for ( j = 0; j < level + 1; j++) printf("  ");
        printf("%s\n", dir->files[i].name);
    }

    for ( i = 0; i < dir->subdirCount; i++) {
        display(dir->subdirs[i], level + 1);
    }
}

int main() {
    struct Directory root;
    strcpy(root.name, "root");
    root.fileCount = 0;
    root.subdirCount = 0;

    strcpy(root.files[root.fileCount++].name, "file1.txt");
    
    struct Directory subdir1;
    strcpy(subdir1.name, "subdir1");
    subdir1.fileCount = 0;
    subdir1.subdirCount = 0;

    strcpy(subdir1.files[subdir1.fileCount++].name, "subfile1.txt");
    root.subdirs[root.subdirCount++] = &subdir1;

    printf("Directory Structure:\n");
    display(&root, 0);

    return 0;
}

