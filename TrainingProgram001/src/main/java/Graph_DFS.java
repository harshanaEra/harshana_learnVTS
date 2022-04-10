// DFS algorithm

import java.util.*;

public class Graph_DFS {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // Creating the graph
    Graph_DFS(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();

    }

    // Adding edges
    void addEdge(int s, int d) {
        adjLists[s].add(d);

    }

    // Building the algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);

        }
    }

    public static void main(String args[]) {
        Graph_DFS g = new Graph_DFS(6);

        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        //Printing the Depth First Traversal
        System.out.println("DFS of the graph is: ");

        g.DFS(0);

    }
}
