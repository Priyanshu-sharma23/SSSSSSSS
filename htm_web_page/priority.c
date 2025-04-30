#include <stdio.h>

struct Process {
    int pid, at, bt, priority, ct, tat, wt;
};

// Function to sort processes by Arrival Time
void sortByArrival(struct Process p[], int n) {
    struct Process temp;
    int i=0;
    int j=0;
	for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n - i - 1; j++) {
            if (p[j].at > p[j + 1].at) {
                temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }
}

// Function to implement Priority Scheduling
void priorityScheduling(struct Process p[], int n) {
    int completed = 0, time = 0, min_index;
    
    // Sort processes by arrival time
    sortByArrival(p, n);

    while (completed != n) {
        min_index = -1;
        int highest_priority = 9999;

        int i=0;
		for (i = 0; i < n; i++) {
            if (p[i].at <= time && p[i].ct == 0 && p[i].priority < highest_priority) {
                highest_priority = p[i].priority;
                min_index = i;
            }
        }

        if (min_index == -1) {
            time++; // If no process is available, increment time
            continue;
        }

        // Execute the selected process
        p[min_index].ct = time + p[min_index].bt;
        time = p[min_index].ct;
        p[min_index].tat = p[min_index].ct - p[min_index].at;
        p[min_index].wt = p[min_index].tat - p[min_index].bt;
        completed++;
    }
}

int main() {
    int n;
    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n];

    // Input process details
    int i;
	for (i = 0; i < n; i++) {
        printf("Enter Arrival Time, Burst Time, and Priority for Process %d: ", i + 1);
        scanf("%d %d %d", &p[i].at, &p[i].bt, &p[i].priority);
        p[i].pid = i + 1;
        p[i].ct = 0; // Mark as not completed
    }

    // Execute Priority Scheduling
    priorityScheduling(p, n);

    // Display process details
    printf("\nPID\tAT\tBT\tPriority\tCT\tTAT\tWT\n");
    
	for (i = 0; i < n; i++) {
        printf("%d\t%d\t%d\t%d\t\t%d\t%d\t%d\n", p[i].pid, p[i].at, p[i].bt, p[i].priority, p[i].ct, p[i].tat, p[i].wt);
    }

    return 0;
}

