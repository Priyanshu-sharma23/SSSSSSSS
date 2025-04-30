#include <stdio.h>
#include <stdlib.h>

void FCFS(int requests[], int n, int head) {
    int total = 0;
    printf("FCFS Order: %d ", head);
    int i;
	for (i = 0; i < n; i++) {
        total += abs(head - requests[i]);
        head = requests[i];
        printf("-> %d ", head);
    }
    printf("\nTotal Head Movement: %d\n", total);
}

void SSTF(int requests[], int n, int head) {
    int total = 0, visited[100] = {0}, index;
    printf("SSTF Order: %d ", head);
    int i,j;
    for (i = 0; i < n; i++) {
        int min = 9999, pos = -1;
        for (j = 0; j < n; j++) {
            if (!visited[j] && abs(head - requests[j]) < min) {
                min = abs(head - requests[j]);
                pos = j;
            }
        }
        visited[pos] = 1;
        total += abs(head - requests[pos]);
        head = requests[pos];
        printf("-> %d ", head);
    }
    printf("\nTotal Head Movement: %d\n", total);
}

int main() {
    int requests[100], n, head;
    printf("Enter number of requests: ");
    scanf("%d", &n);
    printf("Enter requests:\n");
    int i;
	for (i = 0; i < n; i++) scanf("%d", &requests[i]);
    printf("Enter initial head position: ");
    scanf("%d", &head);

    FCFS(requests, n, head);
    SSTF(requests, n, head);
    return 0;
}

