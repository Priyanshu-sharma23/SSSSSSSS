#include <stdio.h>

#define MAX 10

struct Process {
    int pid, at, bt, ct, tat, wt, priority, queue_type, rt;
};

// Function to sort by arrival time
void sortByArrival(struct Process p[], int n) {
    struct Process temp;
    int i,j;
	for (i = 0; i < n - 1; i++) {
        for ( j = i + 1; j < n; j++) {
            if (p[i].at > p[j].at) {
                temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
    }
}

// First-Come-First-Serve (FCFS) Scheduling
void FCFS(struct Process q[], int n, int *time) {
    int i;
	for (i = 0; i < n; i++) {
        if (*time < q[i].at) *time = q[i].at; // Wait if CPU is idle
        q[i].ct = *time + q[i].bt;
        *time = q[i].ct;
        q[i].tat = q[i].ct - q[i].at;
        q[i].wt = q[i].tat - q[i].bt;
    }
}

// Shortest Job First (SJF) Scheduling
void SJF(struct Process q[], int n, int *time) {
    int completed = 0, min_index;
    while (completed != n) {
        min_index = -1;
        int min_bt = 9999;

        int i;
		for (i = 0; i < n; i++) {
            if (q[i].at <= *time && q[i].bt < min_bt && q[i].ct == 0) {
                min_bt = q[i].bt;
                min_index = i;
            }
        }

        if (min_index == -1) {
            (*time)++;
            continue;
        }

        q[min_index].ct = *time + q[min_index].bt;
        *time = q[min_index].ct;
        q[min_index].tat = q[min_index].ct - q[min_index].at;
        q[min_index].wt = q[min_index].tat - q[min_index].bt;
        completed++;
    }
}

// Round Robin (RR) Scheduling
void RoundRobin(struct Process q[], int n, int quantum, int *time) {
    int completed = 0, front = 0, rear = 0;
    int queue[MAX], visited[MAX] = {0};

    queue[rear++] = 0;
    visited[0] = 1;

    while (completed != n) {
        int index = queue[front++];

        int exec_time = (q[index].rt > quantum) ? quantum : q[index].rt;
        q[index].rt -= exec_time;
        *time += exec_time;

        int i;
		for (i = 0; i < n; i++) {
            if (!visited[i] && q[i].at <= *time && q[i].rt > 0) {
                queue[rear++] = i;
                visited[i] = 1;
            }
        }

        if (q[index].rt > 0) {
            queue[rear++] = index;
        } else {
            completed++;
            q[index].ct = *time;
            q[index].tat = q[index].ct - q[index].at;
            q[index].wt = q[index].tat - q[index].bt;
        }
    }
}

int main() {
    int n, quantum;
    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n], q1[MAX], q2[MAX], q3[MAX];
    int count1 = 0, count2 = 0, count3 = 0;
    
    printf("Enter time quantum for Round Robin queue: ");
    scanf("%d", &quantum);

    // Input process details
    int i;
	for (i = 0; i < n; i++) {
        printf("Enter Arrival Time, Burst Time, and Queue Type (1-FCFS, 2-SJF, 3-RR) for P%d: ", i + 1);
        scanf("%d %d %d", &p[i].at, &p[i].bt, &p[i].queue_type);
        p[i].pid = i + 1;
        p[i].rt = p[i].bt;

        // Assign process to appropriate queue
        if (p[i].queue_type == 1)
            q1[count1++] = p[i];
        else if (p[i].queue_type == 2)
            q2[count2++] = p[i];
        else
            q3[count3++] = p[i];
    }

    // Sort processes by arrival time
    sortByArrival(p, n);

    int time = 0;
    
    // Execute queues in order of priority
    if (count1 > 0) {
        printf("\nExecuting FCFS Queue:\n");
        FCFS(q1, count1, &time);
    }
    
    if (count2 > 0) {
        printf("\nExecuting SJF Queue:\n");
        SJF(q2, count2, &time);
    }

    if (count3 > 0) {
        printf("\nExecuting RR Queue:\n");
        RoundRobin(q3, count3, quantum, &time);
    }

    // Display results
    printf("\nPID\tAT\tBT\tCT\tTAT\tWT\tQueue\n");
    int j,k,l;
	for (j = 0; j < count1; j++)
        printf("%d\t%d\t%d\t%d\t%d\t%d\tFCFS\n", q1[j].pid, q1[j].at, q1[j].bt, q1[j].ct, q1[j].tat, q1[j].wt);

    for (k= 0; k< count2; k++)
        printf("%d\t%d\t%d\t%d\t%d\t%d\tSJF\n", q2[k].pid, q2[k].at, q2[k].bt, q2[k].ct, q2[k].tat, q2[k].wt);

    for (l = 0; l < count3; l++)
        printf("%d\t%d\t%d\t%d\t%d\t%d\tRR\n", q3[l].pid, q3[l].at, q3[l].bt, q3[l].ct, q3[l].tat, q3[l].wt);

    return 0;
}

