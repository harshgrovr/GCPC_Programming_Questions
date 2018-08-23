
// Java program to print DFS traversal from a given given graph
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
public class graph {
    public static int V;   // No. of vertices
    public boolean visited[];
    public char color[];

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
        boolean visited[] = new boolean[V];
        char color[]= new char[V];
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);    // Add w to v's list.
    }

    // A function used by DFS
    boolean DFSUtil(int v) {
        // Mark the current node as visited and print it
        if(visited[v]==false && color[v]=='\u0000')
            color[v]='b';
        visited[v] = true;
        //System.out.print(v + " ");

// coloring al the edges of current node, with different color of the parent
        for(int j=0;j<adj[v].size();j++)
        {
            if(color[adj[v].get(j)]=='\u0000' && color[v]=='b')
            {
                color[adj[v].get(j)]='w';
            }
            else if(color[adj[v].get(j)]=='\u0000' && color[v]=='w')
            {
                color[adj[v].get(j)]='b';
            }

            else if((color[adj[v].get(j)]=='b' && color[v]=='b')||(color[adj[v].get(j)]=='w' && color[v]=='w'))
            {
                return false;
            }
            else if(adj[v].get(j)==v)
            {
                return false;
            }
        }

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> ii = adj[v].listIterator();
        while (ii.hasNext()) {
            int n = ii.next();
            if (!visited[n])
                return DFSUtil(n);
        }
        return true;
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    boolean DFS(int first) {

        // Mark all the vertices as not visited(set as
        // false by default in java)
        visited = new boolean[V];
        color= new char[V];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        boolean result=true;
        for (int i = 0; i < V; ++i){


            if (visited[i] == false) {
                result= DFSUtil(i);
                if(result==false)
                    return  false;
            }
        }
        return true;
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int testcase = 0; testcase < t; testcase++) {
            int n;
            int count_1 = testcase + 1;
            int m;
            int first = 0, second = 0;
            n = sc.nextInt();

            m = sc.nextInt();
            graph g = new graph(n);

            int first_time = 1;
            int temp_first = 0;
            for (int i = 0; i < m; i++) {
                if (first_time == 1) {
                    first = sc.nextInt() - 1;
                    temp_first = first;
                } else
                    first = sc.nextInt() - 1;
                first_time = 0;
                second = sc.nextInt() - 1;
                g.addEdge(first, second);
                g.addEdge(second, first);
            }
            boolean result = g.DFS(temp_first);

            if (result) {
                System.out.println("Case #" + (count_1) + ": yes");
            } else
                System.out.println("Case #" + (count_1) + ": no");


    }
}
}
