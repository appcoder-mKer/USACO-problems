package Cowtip;
import java.io.*;
import java.util.*;

public class cowtip {

    // Function to toggle all cows in the sub-grid from (0,0) to (r, c)
    public static void toggleCows(int[][] grid, int r, int c) {
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                // Toggle each cow (flip 0 to 1 and 1 to 0)
                grid[i][j] = 1 - grid[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Input file handling
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

        // Read the size of the grid
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];

        // Read the grid from input
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j) - '0'; // Convert char to int
            }
        }

        int flipCount = 0;

        // Traverse the grid from bottom-right to top-left
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                // If we find a tipped cow ('1'), we need to apply the machine
                if (grid[i][j] == 1) {
                    // Toggle all cows in the rectangle from (0,0) to (i,j)
                    toggleCows(grid, i, j);
                    // Increment the flip count
                    flipCount++;
                }
            }
        }

        // Output the result
        out.println(flipCount);

        // Close input and output streams
        br.close();
        out.close();
    }
}
