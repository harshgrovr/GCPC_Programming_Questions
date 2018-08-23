// JAVA Code to check whether a given
// graph is Bipartite or not
import java.util.*;

public class Bipartitee {

    public static int V ;

    // This function returns true if graph
    // G[V][V] is Bipartite, else false
    public static boolean isBipartiteUtil(int G[][], int src,
                                          int colorArr[]) {
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers and 
        // enqueue source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);

        // Run while there are vertices in queue 
        // (Similar to BFS)
        while (!q.isEmpty()) {
            // Dequeue a vertex from queue 

            int u = q.getFirst();
            q.pop();

            // Return false if there is a self-loop 
            if (G[u][u] == 1)
                return false;

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) {
                // An edge from u to v exists and
                // destination v is not colored
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this
                    // adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }

                // An edge from u to v exists and 
                // destination v is colored with same
                // color as u
                else if (G[u][v] == 1 && colorArr[v] ==
                        colorArr[u])
                    return false;
            }
        }

        // If we reach here, then all adjacent vertices
        // can be colored with alternate color
        return true;
    }

    // Returns true if G[][] is Bipartite, else false
    public static boolean isBipartite(int G[][]) {
        // Create a color array to store colors assigned 
        // to all veritces. Vertex/ number is used as 
        // index in this array. The value '-1' of  
        // colorArr[i] is used to indicate that no color 
        // is assigned to vertex 'i'. The value 1 is used 
        // to indicate first color is assigned and value
        // 0 indicates second color is assigned.
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        // This code is to handle disconnected graoh
        for (int i = 0; i < V; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(G, i, colorArr) == false)
                    return false;

        return true;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int testcase = 0; testcase < t; testcase++) {
            int n;
            int count_1 = testcase + 1;
            int m;
            int first = 0, second = 0;

            n = sc.nextInt();
            V=n;
            m = sc.nextInt();
            int graph[][] = new int[n][n];


            for (int i = 0; i < m; i++) {
                first = sc.nextInt() - 1;
                second = sc.nextInt() - 1;
                graph[first][second] = 1;
                graph[second][first] = 1;
            }


            if (isBipartite(graph))
                System.out.println("Case #" + (count_1) + ": yes");
            else
                System.out.println("Case #" + (count_1) + ": no");
        }
    }
}

// This code is contribute