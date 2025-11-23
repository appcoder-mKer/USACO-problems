package wormsort;
// package wormsort;
import java.util.*;
import java.io.*;  

public class wormsort {  

    private static class Node {
        int id;
        ArrayList<Integer> neighbors = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

        public void addNeighbor(int neighborId, int width) {
            neighbors.add(neighborId);
            widths.add(width);
        }
    }

    private static int[] cowPos;
    private static HashMap<Integer, Node> cowNetwork;

    private static int[] buildComponents(int n, int minWidth) {
        int[] comp = new int[n+1];
        Arrays.fill(comp, -1);

        int compId = 0;
        for (int i = 1; i <= n; i++) {
            if (comp[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                comp[i] = compId;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    Node node = cowNetwork.get(u);
                    for (int j = 0; j < node.neighbors.size(); j++) {
                        int v = node.neighbors.get(j);
                        int w = node.widths.get(j);
                        if (w >= minWidth && comp[v] == -1) {
                            comp[v] = compId;
                            q.add(v);
                        }
                    }
                }
                compId++;
            }
        }
        return comp;
    }

    private static boolean canSort(int n, int minWidth) {
        int[] comp = buildComponents(n, minWidth);
        for (int i = 1; i <= n; i++) {
            int cow = cowPos[i];
            if (comp[i] != comp[cow]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {  
        File inputFile = new File("wormsort.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        Scanner scanner = new Scanner(inputFile);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        cowPos = new int[n+1];
        boolean sorted = true;
        for (int i = 1; i <= n; i++) {
            cowPos[i] = scanner.nextInt();
            if (cowPos[i] != i) sorted = false;
        }

        if (sorted) {
            out.println(-1);
            out.close();
            return;
        }

        cowNetwork = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            cowNetwork.put(i, new Node(i));
        }

        int maxW = 0;
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            cowNetwork.get(a).addNeighbor(b, w);
            cowNetwork.get(b).addNeighbor(a, w);
            maxW = Math.max(maxW, w);
        }

        // Binary search on width
        int lo = 0, hi = maxW, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canSort(n, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        out.println(ans);
        out.close();
    }  
}
