import java.util.LinkedList;

public class GraphBFS {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency List

    // Constructor
    public GraphBFS(int v) {
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

    // BFS traversal
    /**
     * @param start
     */
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS traversal starting from vertex " + start + ":");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(6); // Example with 6 vertices (0 to 5)

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        g.BFS(0); // Start BFS from vertex 0
    }
}
