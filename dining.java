import java.io.*;
import java.util.*;
import org.w3c.dom.Node;  

public class dining {  
public class GFG {

    // Member variables of this class
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    // Number of vertices
    private int V;
    List<List<Node> > adj;

    // Constructor of this class
    public GFG(int V){

        // This keyword refers to current object itself
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }
class Node implements Comparator<Node> {

    // Member variables of this class
    public int node;
    public int cost;

    // Constructors of this class
    public Node(){}

    public Node(int node, int cost)
    {

        // This keyword refers to current instance itself
        this.node = node;
        this.cost = cost;
    }

    // Method 1
    @Override public int compare(Node node1, Node node2)
    {

        if (node1.cost < node2.cost)
            return -1;

        if (node1.cost > node2.cost)
            return 1;

        return 0;
    }
}
public void dijkstra(List<List<Node> > adj, int src){

        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;

            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))

                // Continue keyword skips execution for
                // following check
                continue;

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            e_Neighbours(u);
        }
    }
     private void e_Neighbours(int u){

        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}

public static void helperadjacent(int current, int connected, int cost){
//use the adjecy list to add the current node and the connected node with the cost of the edge between them
//get(node, int)    


}


    public static void main(String[] args) throws IOException{  
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));  
    BufferedReader br = new BufferedReader(new FileReader("dining.in"));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int numberPastures = Integer.parseInt(st.nextToken());
    int numberTrails = Integer.parseInt(st.nextToken());
    int numberHayBailes = Integer.parseInt(st.nextToken());

for(int i = 0; i<numberPastures;i++){
//make all the nodes in here

}








        }  
}  







//djistkra takes us to the least cost
//then force to go through haybail 
//make the value a edge a negative value
//totalwith the haybail - drjiskta = value 
//if value> than yumminess value then we can say that the haybail is  not worth it
//else{ haybail is worth it}