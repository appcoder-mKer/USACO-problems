package MooCastSIlver;
import java.io.*;
import java.util.*;

public class MooCast {

    public static double distance(int x1, int y1, int x2, int y2) {
        double x = x2 - x1;
        double y = y2 - y1;
        return Math.sqrt(x * x + y * y);
    }

    private static class Node {
        public int power;
        public int x;
        public int y;
        public ArrayList<Node> neighbors;

        public Node(int x, int y, int power) {
            this.power = power;
            this.x = x;
            this.y = y;
            neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node n) {
            neighbors.add(n);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new File("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        int numOfCow = fileScanner.nextInt();
        ArrayList<Node> cows = new ArrayList<>();

        for (int i = 0; i < numOfCow; i++) {
            int x = fileScanner.nextInt();
            int y = fileScanner.nextInt();
            int p = fileScanner.nextInt();
            cows.add(new Node(x, y, p));
        }

        // Build neighbors for each cow
        for (int i = 0; i < numOfCow; i++) {
            Node cow1 = cows.get(i);
            for (int j = 0; j < numOfCow; j++) {
                if (i == j) continue;
                Node cow2 = cows.get(j);
                if (distance(cow1.x, cow1.y, cow2.x, cow2.y) <= cow1.power) {
                    cow1.addNeighbor(cow2);
                }
            }
        }

        int maxReach = 0;
        for (Node cow : cows) {
            maxReach = Math.max(maxReach, bfs(cow));
        }

        out.println(maxReach);
        out.close();
    }

    // BFS starting from a cow
    public static int bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited.size();
    }
}
