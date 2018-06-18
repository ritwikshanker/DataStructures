import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class GraphD
{
    private int V;

    private LinkedList<Integer> adj[];

    GraphD(int v)
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
        GraphD g = new GraphD(scn.nextInt());
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
        System.out.println("Please input the starting vetices for DFS");
        int a = scn.nextInt();
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex " + a + " )");
        g.DFS(a);
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }
}