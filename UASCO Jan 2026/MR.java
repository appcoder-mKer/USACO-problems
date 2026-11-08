package wormsort;
import java.io.*;
import java.util.*;

public class MR {
    static class Edge {
        int to;
        long z;
        Edge(int to, long z) {
            this.to = to;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[] l = new long[N+1];
            long[] r = new long[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) l[i] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) r[i] = Long.parseLong(st.nextToken());

            List<Edge>[] adj = new List[N+1];
            for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long z = Long.parseLong(st.nextToken());
                adj[x].add(new Edge(y, z));
                adj[y].add(new Edge(x, z));
            }

            boolean feasible = true;
            long totalActive = 0;

            boolean[] visited = new boolean[N+1];
            int[] s = new int[N+1];      // coefficient: 1 or -1
            long[] t = new long[N+1];    // constant

            for (int start = 1; start <= N && feasible; start++) {
                if (visited[start]) continue;

                // BFS for this component
                List<Integer> compNodes = new ArrayList<>();
                Long fixedX = null;
                boolean compFeasible = true;

                Deque<Integer> queue = new ArrayDeque<>();
                queue.add(start);
                visited[start] = true;
                s[start] = 1;
                t[start] = 0;
                compNodes.add(start);

                while (!queue.isEmpty() && compFeasible) {
                    int u = queue.poll();
                    for (Edge e : adj[u]) {
                        int v = e.to;
                        long z = e.z;
                        if (!visited[v]) {
                            visited[v] = true;
                            s[v] = -s[u];
                            t[v] = z - t[u];
                            compNodes.add(v);
                            queue.add(v);
                        } else {
                            // consistency check
                            int sumS = s[u] + s[v];
                            long sumT = t[u] + t[v];
                            if (sumS == 0) {
                                if (sumT != z) {
                                    compFeasible = false;
                                    break;
                                }
                            } else {
                                // sumS is 2 or -2
                                long num = z - sumT;
                                if (num % 2 != 0) {
                                    compFeasible = false;
                                    break;
                                }
                                long cand = num / sumS;   // integer division
                                if (fixedX == null) {
                                    fixedX = cand;
                                } else if (fixedX != cand) {
                                    compFeasible = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (!compFeasible) {
                    feasible = false;
                    break;
                }

                if (fixedX != null) {
                    // count how many nodes are in range with this fixed x
                    int cnt = 0;
                    for (int node : compNodes) {
                        long val = s[node] * fixedX + t[node];
                        if (l[node] <= val && val <= r[node]) cnt++;
                    }
                    totalActive += cnt;
                } else {
                    // collect intervals and find max overlap
                    List<long[]> events = new ArrayList<>();
                    for (int node : compNodes) {
                        long L, R;
                        if (s[node] == 1) {
                            L = l[node] - t[node];
                            R = r[node] - t[node];
                        } else {
                            L = t[node] - r[node];
                            R = t[node] - l[node];
                        }
                        if (L > R) continue; // empty interval, node never active
                        events.add(new long[]{L, 1});
                        events.add(new long[]{R + 1, -1});
                    }
                    if (events.isEmpty()) {
                        // no node can be active in this component
                        continue;
                    }
                    events.sort((a, b) -> Long.compare(a[0], b[0]));
                    int cur = 0;
                    int maxOverlap = 0;
                    int idx = 0;
                    while (idx < events.size()) {
                        long x = events.get(idx)[0];
                        while (idx < events.size() && events.get(idx)[0] == x) {
                            cur += events.get(idx)[1];
                            idx++;
                        }
                        if (cur > maxOverlap) maxOverlap = cur;
                    }
                    totalActive += maxOverlap;
                }
            }

            if (!feasible) {
                System.out.println(-1);
            } else {
                System.out.println(totalActive);
            }
        }
    }
}