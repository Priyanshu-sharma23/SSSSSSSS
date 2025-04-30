#include <stdio.h>

struct Process {
    int pid;      // Process ID
    int at;       // Arrival Time
    int bt;       // Burst Time
    int rt;       // Remaining Time
    int ct, tat, wt; // Completion, Turnaround, Waiting Time
};

int main() {
    int n, quantum, completed = 0, current_time = 0;
    float total_wt = 0, total_tat = 0;

    printf("Enter number of processes: ");
    scanf("%d", &n);
    
    printf("Enter time quantum: ");
    scanf("%d", &quantum);

    struct Process p[n];

    // Input process details
    int i;
	for (i = 0; i < n; i++) {
        printf("Enter arrival time and burst time for process %d: ", i + 1);
        scanf("%d %d", &p[i].at, &p[i].bt);
        p[i].pid = i + 1;
        p[i].rt = p[i].bt;  // Initialize remaining time
    }

    // Sort processes by Arrival Time (AT) to start execution properly
    int k,j;
	for (k = 0; k < n - 1; k++) {
        for (j = k + 1; j < n; j++) {
            if (p[k].at > p[j].at) {
                struct Process temp = p[k];
                p[k] = p[j];
                p[j] = temp;
            }
        }
    }

    // Round Robin Execution
    int queue[n], front = 0, rear = 0;
    int visited[n]; // Track if a process has been added to the queue
    int l;
	for (l = 0; l < n; l++) visited[l] = 0;

    // Add the first process to the queue
    queue[rear++] = 0;
    visited[0] = 1;

    printf("\nGantt Chart:\n");

    while (completed != n) {
        int index = queue[front++];
        
        // Execute for time quantum or until completion
        int exec_time = (p[index].rt > quantum) ? quantum : p[index].rt;
        p[index].rt -= exec_time;
        current_time += exec_time;
        printf("| P%d ", p[index].pid);

        // Add new arriving processes to queue
        int i;
		for (i = 0; i < n; i++) {
            if (!visited[i] && p[i].at <= current_time && p[i].rt > 0) {
                queue[rear++] = i;
                visited[i] = 1;
            }
        }

        // If process still needs execution, re-add it to queue
        if (p[index].rt > 0) {
            queue[rear++] = index;
        } else {
            // Process completed
            completed++;
            p[index].ct = current_time;
            p[index].tat = p[index].ct - p[index].at;
            p[index].wt = p[index].tat - p[index].bt;
            total_wt += p[index].wt;
            total_tat += p[index].tat;
        }
    }
    printf("|\n");

    // Display Process Table
    printf("\nPID\tAT\tBT\tCT\tTAT\tWT\n");
    int h;
	for (h = 0; h < n; h++) {
        printf("%d\t%d\t%d\t%d\t%d\t%d\n", p[h].pid, p[h].at, p[h].bt, p[h].ct, p[h].tat, p[h].wt);
    }

    // Display Average Times
    printf("\nAverage Turnaround Time: %.2f", total_tat / n);
    printf("\nAverage Waiting Time: %.2f\n", total_wt / n);

    return 0;
}

