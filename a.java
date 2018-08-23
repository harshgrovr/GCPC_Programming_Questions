import java.util.*;

public class a {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        // Store graph edges here.
        String[][] names = new String[n][2];

        // To store id's for each name.
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int ID = 0;

        // Read in the graph.
        for (int i=0; i<n; i++) {

            // Get names and then ids.
            String v1 = stdin.next();
            String sign = stdin.next();
            String v2 = stdin.next();
            int v1ID = getID(map, v1, ID);
            ID = Math.max(ID, v1ID+1);
            int v2ID = getID(map, v2, ID);
            ID = Math.max(ID, v2ID+1);

            // Make edges for < relationship.
            if (sign.equals("<")) {
                names[i][0] = v1;
                names[i][1] = v2;
            }

            // So we flip this one.
            else {
                names[i][0] = v2;
                names[i][1] = v1;
            }
        }

        // Now that we have the edges, store the graph.
        int[] in = new int[ID];
        ArrayList[] g = new ArrayList[ID];
        for (int j=0; j<ID; j++) g[j] = new ArrayList<Integer>();
        for (int j=0; j<n; j++) {
            g[map.get(names[j][0])].add(map.get(names[j][1]));
            in[map.get(names[j][1])]++;
        }

        // Info is consistent if we can topologically sort the graph.
        if (topsort(g, in))
            System.out.println("possible");
        else
            System.out.println("impossible");

    }

    public static boolean topsort(ArrayList[] g, int[] in) {

        int v = in.length;

        node[] all = new node[v];
        for (int i=0; i<v; i++)
            all[i] = new node(in[i], i);

        // Set up our priority quee of nodes.
        PriorityQueue<node> pq = new PriorityQueue<node>();
        for (int i=0; i<v; i++)
            pq.offer(all[i]);

        // Must get all v vertices placed in order.
        for (int i=0; i<v; i++) {

            node next = pq.poll();

            // Oops, got stuck, there's no top sort.
            if (next.degree > 0) return false;

            // Remove this vertex and update all relevant in degree counts for the PQ.
            for (int x: (ArrayList<Integer>)g[next.ID]) {
                pq.remove(all[x]);
                all[x].degree--;
                pq.offer(all[x]);
            }
        }

        return true;
    }

    // Helps to manage the hashmap of names to ids.
    public static int getID(HashMap<String,Integer> map, String name, int curID) {
        if (map.containsKey(name)) return map.get(name);
        map.put(name, curID);
        return curID;
    }
}

class node implements Comparable<node> {

    public int degree;
    public int ID;

    public node(int d, int myID) {
        degree = d;
        ID = myID;
    }

    public int compareTo(node other) {
        return this.degree - other.degree;
    }
}