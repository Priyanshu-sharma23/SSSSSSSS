#include <stdio.h>
#include <stdlib.h>

// Compare function for qsort
int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

// LOOK Disk Scheduling
void look(int request[], int n, int head) {
    int seek_count = 0;
    int left[100], right[100];
    int l = 0, r = 0;
    int i;

    // Separate requests
    for (i = 0; i < n; i++) {
        if (request[i] < head)
            left[l++] = request[i];
        else
            right[r++] = request[i];
    }

    qsort(left, l, sizeof(int), compare);
    qsort(right, r, sizeof(int), compare);

    printf("\n--- LOOK Scheduling ---\nSeek sequence: %d", head);

    // Go right first
    for (i = 0; i < r; i++) {
        seek_count += abs(head - right[i]);
        head = right[i];
        printf(" -> %d", head);
    }

    // Then left
    for (i = l - 1; i >= 0; i--) {
        seek_count += abs(head - left[i]);
        head = left[i];
        printf(" -> %d", head);
    }

    printf("\nTotal Seek Time: %d\n", seek_count);
}

// C-LOOK Disk Scheduling
void c_look(int request[], int n, int head) {
    int seek_count = 0;
    int left[100], right[100];
    int l = 0, r = 0;
    int i;

    // Separate requests
    for (i = 0; i < n; i++) {
        if (request[i] < head)
            left[l++] = request[i];
        else
            right[r++] = request[i];
    }

    qsort(left, l, sizeof(int), compare);
    qsort(right, r, sizeof(int), compare);

    printf("\n--- C-LOOK Scheduling ---\nSeek");
    // Go right first
    for (i = 0; i < r; i++) {
        seek_count += abs(head - right[i]);
        head = right[i];
        printf(" -> %d", head);
    }

    // Jump to lowest left request
    if (l > 0) {
        seek_count += abs(head - left[0]);
        head = left[0];
        printf(" -> %d", head);
    }

    // Continue on left
    for (i = 1; i < l; i++) {
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

    look(request, n, head);
    c_look(request, n, head);

    return 0;
}

