#include <stdio.h>

struct Process {
    int pid;          // Process ID
    int at;           // Arrival Time
    int bt;           // Burst Time
    int rt;           // Remaining Time
    int ct, wt, tat;  // Completion, Waiting, and Turnaround Time
};

int main() {
    int n, completed = 0, time = 0, min_index;
    float total_wt = 0, total_tat = 0;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n];

    // Input process details
    int i;
	for (i = 0; i < n; i++) {
        printf("Enter arrival time and burst time for process %d: ", i + 1);
        scanf("%d %d", &p[i].at, &p[i].bt);
        p[i].pid = i + 1;
        p[i].rt = p[i].bt; // Remaining time initially equals burst time
    }

    printf("\nGantt Chart:\n");
    
    // SRTF Algorithm Execution
    while (completed != n) {
        min_index = -1;
        int min_rt = 9999; // Set a large number to find the minimum remaining time

        // Find process with the shortest remaining time at the current time
        int i;
		for (i = 0; i < n; i++) {
            if (p[i].at <= time && p[i].rt > 0 && p[i].rt < min_rt) {
                min_rt = p[i].rt;
                min_index = i;
            }
        }

        if (min_index == -1) {
            time++; // If no process is ready, increment time
            continue;
        }

        printf("| P%d ", p[min_index].pid);

        // Execute the process for 1 time unit
        p[min_index].rt--;
        time++;

        // If process is completed
        if (p[min_index].rt == 0) {
            completed++;
            p[min_index].ct = time; // Completion time
            p[min_index].tat = p[min_index].ct - p[min_index].at; // Turnaround time
            p[min_index].wt = p[min_index].tat - p[min_index].bt; // Waiting time

            total_wt += p[min_index].wt;
            total_tat += p[min_index].tat;
        }
    }
    printf("|\n");

    // Display Process Table
    printf("\nPID\tAT\tBT\tCT\tTAT\tWT\n");
    int j;
	for (j = 0; j < n; j++) {
        printf("%d\t%d\t%d\t%d\t%d\t%d\n", p[j].pid, p[j].at, p[j].bt, p[j].ct, p[j].tat, p[j].wt);
    }

    // Display Average Times
    printf("\nAverage Turnaround Time: %.2f", total_tat / n);
    printf("\nAverage Waiting Time: %.2f\n", total_wt / n);

    return 0;
}

