import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph
{
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please input the number of vertices you want");
        Graph g = new Graph(scn.nextInt());
        System.out.println("Please input the number of edges you want to add to the graph");
        int t = scn.nextInt();
        System.out.println("Please input 1 for directed and 2 undirected graph");
        int choice = scn.nextInt();
        if (choice == 1)
        {
            while (t-- > 0)
            {
                g.addEdge(scn.nextInt(), scn.nextInt());
            }
        }
        else if (choice == 2)
        {
            while (t-- > 0)
            {
                int a = scn.nextInt();
                int b = scn.nextInt();
                g.addEdge(a, b);
                g.addEdge(b, a);
            }
        }
        System.out.println("Please input the starting vetices for BFS");
        int a = scn.nextInt();
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex " + a + " )");
        g.BFS(a);
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    void BFS(int s)
    {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}