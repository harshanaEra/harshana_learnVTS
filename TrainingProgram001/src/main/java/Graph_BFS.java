// BFS algorithm

import java.util.*;

public class Graph_BFS {
    private int A;
    private LinkedList<Integer> adj[];

    // Creating the graph

    Graph_BFS(int a) {
        A = a;
        adj = new LinkedList[a];
        for (int i = 0; i < a; ++i)
            adj[i] = new LinkedList();

    }

    // Adding edges to the graph

    void addEdge(int a, int x) {
        adj[a].add(x);

    }

    // Building the BFS algorithm

    void BFS(int s) {
        boolean visited[] = new boolean[A];
        LinkedList<Integer> queue = new LinkedList();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);

                }
            }
        }
    }

    public static void main(String args[]) {
        Graph_BFS g = new Graph_BFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        //Printing the Breadth First Traversal value
        System.out.println("BFS of the graph is: " + "(starting from vertex 0)");

        g.BFS(0);

    }
}
