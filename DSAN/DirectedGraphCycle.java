import java.util.*;

public class DirectedGraphCycle {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public DirectedGraphCycle(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v); // directed edge
    }

    // Utility method to check for cycle
    private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true; // Found a back edge -> cycle
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjList[node]) {
            if (isCyclicUtil(neighbor, visited, recStack))
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recStack))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycle graph = new DirectedGraphCycle(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // Cycle from 3 → 1 → 2 → 3

        if (graph.isCyclic())
            System.out.println("Graph contains a cycle.");
        else
            System.out.println("Graph does not contain a cycle.");
    }
}
