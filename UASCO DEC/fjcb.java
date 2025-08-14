
import java.util.*;

public class fjcb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        
        // A set to keep track of carved positions
        Set<String> carved = new HashSet<>();
        
        // To track the number of free lines
        int freeX = N * N * N;
        int freeY = N * N * N;
        int freeZ = N * N * N;
        
        // 3D grid for tracking whether a block is carved along a particular axis
        boolean[][][] carvedGrid = new boolean[N][N][N];
        
        // Process each query
        for (int q = 0; q < Q; q++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            
            // Mark the carving
            if (!carvedGrid[x][y][z]) {
                carvedGrid[x][y][z] = true;
                // Update the number of free lines
                freeX -= 1;
                freeY -= 1;
                freeZ -= 1;
            }
            
            // Output the result after the query
            System.out.println(freeX + freeY + freeZ);
        }
        
        sc.close();
    }
}
