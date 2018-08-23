import java.util.*;

public class e {

    public static int n;
    public static int e;
    public static ArrayList[] graph;
    public static int curCost;

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        e = stdin.nextInt();
        int limit = stdin.nextInt();
        curCost = 0;
        graph = new ArrayList[n];
        for (int i=0; i<n; i++) graph[i] = new ArrayList<edge>();

        // Read in the graph, adding in the cost of the current edges.
        for (int i=0; i<e; i++) {
            int v1 = stdin.nextInt()-1;
            int v2 = stdin.nextInt()-1;
            int w = stdin.nextInt();
            if (i<limit) curCost += w;
            graph[v1].add(new edge(v1, v2, w));
            graph[v2].add(new edge(v2, v1, w));
        }

        // Get the MST.
        int getMST = mst();

        // This is what the problem is asking for.
        if (getMST <= curCost)
            System.out.println("possible");
        else
            System.out.println("impossible");
    }

    // Runs prims and return's the graph's MST.
    public static int mst() {

        // Set up the priority queue.
        PriorityQueue<edge> pq = new PriorityQueue<edge>();
        int cost = 0, numE = 0;
        for (int i=0; i<graph[0].size(); i++)
            pq.offer(((ArrayList<edge>)graph[0]).get(i));
        boolean[] used = new boolean[n];
        used[0] = true;

        // Run until we get the MST or run out of edges.
        while (pq.size() > 0 && numE < n-1) {

            // Grab the next edge.
            edge cur = pq.poll();

            // Skip it, these two are connected already.
            if (used[cur.v1] && used[cur.v2]) continue;

            // Add into MST.
            cost += cur.w;
            numE++;

            // Add in edges leaving v2.
            if (!used[cur.v2]) {
                used[cur.v2] = true;
                for (int i=0; i<graph[cur.v2].size(); i++)
                    pq.offer(((ArrayList<edge>)graph[cur.v2]).get(i));
            }

            // Add in edges leaving v1.
            else {
                used[cur.v1] = true;
                for (int i=0; i<graph[cur.v1].size(); i++)
                    pq.offer(((ArrayList<edge>)graph[cur.v1]).get(i));
            }

        }

        // How we indicate no solution.
        if (numE < n-1) return curCost + 1;

        // Ta da!
        return cost;
    }
}

class edge implements Comparable<edge> {

    public int v1;
    public int v2;
    public int w;

    public edge(int a, int b, int myw) {
        v1 = a;
        v2 = b;
        w = myw;
    }

    public int compareTo(edge other) {
        return this.w - other.w;
    }
}