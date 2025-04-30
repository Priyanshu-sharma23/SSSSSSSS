#include <stdio.h>

int main() {
    int n, i;
    int pid[100], bt[100], wt[100], tat[100];
    float total_wt = 0, total_tat = 0;

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    // Input process IDs
    printf("Enter process IDs:\n");
    for(i = 0; i < n; i++) {
        scanf("%d", &pid[i]);
    }

    // Input burst times
    printf("Enter burst times for each process:\n");
    for(i = 0; i < n; i++) {
        scanf("%d", &bt[i]);
    }

    // Calculate waiting time
    wt[0] = 0;
    for(i = 1; i < n; i++) {
        wt[i] = wt[i - 1] + bt[i - 1];
    }

    // Calculate turnaround time
    for(i = 0; i < n; i++) {
        tat[i] = wt[i] + bt[i];
    }

    // Display results
    printf("\nProcess ID\tBurst Time\tWaiting Time\tTurnaround Time\n");
    for(i = 0; i < n; i++) {
        printf("%d\t\t%d\t\t%d\t\t%d\n", pid[i], bt[i], wt[i], tat[i]);
        total_wt += wt[i];
        total_tat += tat[i];
    }

    printf("\nAverage Waiting Time: %.2f", total_wt / n);
    printf("\nAverage Turnaround Time: %.2f\n", total_tat / n);

    return 0;
}

