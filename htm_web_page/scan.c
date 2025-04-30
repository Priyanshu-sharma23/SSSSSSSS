#include <stdio.h>
#include <stdlib.h>

// Function to compare for qsort
int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

// SCAN Disk Scheduling
void scan(int request[], int n, int head, int disk_size) {
    int seek_count = 0;
    int left[100], right[100];
    int l = 0, r = 0;
    int i;

    // Divide requests
    for (i = 0; i < n; i++) {
        if (request[i] < head)
            left[l++] = request[i];
        else
            right[r++] = request[i];
    }

    qsort(left, l, sizeof(int), compare);
    qsort(right, r, sizeof(int), compare);

    printf("\n--- SCAN Scheduling ---\nSeek sequence: %d", head);

    for (i = 0; i < r; i++) {
        seek_count += abs(head - right[i]);
        head = right[i];
        printf(" -> %d", head);
    }

    // Move to end
    seek_count += abs(head - (disk_size - 1));
    head = disk_size - 1;

    // Reverse and go to left
    for (i = l - 1; i >= 0; i--) {
        seek_count += abs(head - left[i]);
        head = left[i];
        printf(" -> %d", head);
    }

    printf("\nTotal Seek Time: %d\n", seek_count);
}

// C-SCAN Disk Scheduling
void c_scan(int request[], int n, int head, int disk_size) {
    int seek_count = 0;
    int left[100], right[100];
    int l = 0, r = 0;
    int i;

    // Divide requests
    for (i = 0; i < n; i++) {
        if (request[i] < head)
            left[l++] = request[i];
        else
            right[r++] = request[i];
    }

    qsort(left, l, sizeof(int), compare);
    qsort(right, r, sizeof(int), compare);

    printf("\n--- C-SCAN Scheduling ---\nSeek sequence: %d", head);

    for (i = 0; i < r; i++) {
        seek_count += abs(head - right[i]);
        head = right[i];
        printf(" -> %d", head);
    }

    // Move to end and wrap to beginning
    if (head != disk_size - 1) {
        seek_count += abs(head - (disk_size - 1));
        head = 0;
        seek_count += (disk_size - 1);
        printf(" -> %d -> %d", disk_size - 1, head);
    }

    for (i = 0; i < l; i++) {
        seek_count += abs(head - left[i]);
        head = left[i];
        printf(" -> %d", head);
    }

    printf("\nTotal Seek Time: %d\n", seek_count);
}

// Main function
int main() {
    int request[] = {82, 170, 43, 140, 24, 16, 190};
    int n = sizeof(request) / sizeof(request[0]);
    int head = 50;
    int disk_size = 200;

    scan(request, n, head, disk_size);
    c_scan(request, n, head, disk_size);

    return 0;
}

