import java.util.*;

public class GraphDFS {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjList;

    // Constructor
    public GraphDFS(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // For undirected graph
    }

    // DFS Utility (Recursive)
    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // DFS Traversal
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS traversal starting from vertex " + start + ":");
        DFSUtil(start, visited);
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(6); // Example with 6 vertices (0 to 5)

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        g.DFS(0); // Start DFS from vertex 0
    }
}
