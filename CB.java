import java.io.*;
import java.util.*;

/*
  Brute-force solver for small N (works for testing only).
  - Reads N, Q, then Q updates (r c t)
  - After each day prints the minimum number of unusable cells possible
    if we optimally fill all remaining '?' arbitrarily.
  Notes:
  - This brute force enumerates all assignments of remaining '?' (4 choices each)
    so it is only feasible for very small grids or few '?' cells.
*/

public class CB {
    static int N, Q;
    static char[][] grid;

    static final char[] DIRS = {'L','R','U','D'};
    static final int[] dr = {0,0,-1,1}; // L,R,U,D
    static final int[] dc = {-1,1,0,0};

    static boolean leavesGrid(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }

    // simulate starting at (r,c) following belts (grid is fully filled, no '?')
    // returns true if eventually goes out of grid, false if stuck in cycle
    static boolean canExit(int r, int c, char[][] g) {
        boolean[][] visited = new boolean[N][N];
        int cr = r, cc = c;
        while (true) {
            if (leavesGrid(cr, cc)) return true;
            if (visited[cr][cc]) return false;
            visited[cr][cc] = true;
            char ch = g[cr][cc];
            int idx = (ch == 'L' ? 0 : ch == 'R' ? 1 : ch == 'U' ? 2 : 3);
            cr += dr[idx];
            cc += dc[idx];
        }
    }

    // count unusable cells (cells that don't exit) for a fully filled grid
    static int countUnusable(char[][] g) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!canExit(i, j, g)) cnt++;
            }
        }
        return cnt;
    }

    // brute force all fillings of '?', returns minimal unusable
    static int bruteMinUnusable(char[][] base) {
        ArrayList<int[]> unknowns = new ArrayList<>();
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) if (base[i][j] == '?') unknowns.add(new int[]{i,j});
        int k = unknowns.size();
        if (k == 0) {
            return countUnusable(base);
        }
        int minUnusable = Integer.MAX_VALUE;
        int total = (int)Math.pow(4, k);
        // iterate by base-4 counting
        for (int mask = 0; mask < total; mask++) {
            char[][] g = new char[N][N];
            for (int i = 0; i < N; i++) System.arraycopy(base[i], 0, g[i], 0, N);
            int x = mask;
            for (int t = 0; t < k; t++) {
                int choice = x & 3; // 0..3
                int r = unknowns.get(t)[0], c = unknowns.get(t)[1];
                g[r][c] = DIRS[choice];
                x >>= 2;
            }
            int unus = countUnusable(g);
            if (unus < minUnusable) minUnusable = unus;
        }
        return minUnusable;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        N = fs.nextInt();
        Q = fs.nextInt();
        grid = new char[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(grid[i], '?');

        // We'll apply updates day by day and after each day call bruteMinUnusable
        for (int day = 0; day < Q; day++) {
            int r = fs.nextInt() - 1;
            int c = fs.nextInt() - 1;
            char t = fs.next().charAt(0);
            grid[r][c] = t;
            int ans = bruteMinUnusable(grid);
            System.out.println(ans);
        }
    }

    // fast scanner for convenience
    static class FastScanner {
        BufferedInputStream in;
        byte[] buffer = new byte[1<<16];
        int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = new BufferedInputStream(is); }
        int read() throws IOException {
            if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
            return buffer[ptr++];
        }
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ') if (c == -1) return null;
            while (c > ' ') { sb.append((char)c); c = read(); }
            return sb.toString();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}
