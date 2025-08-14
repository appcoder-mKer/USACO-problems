package Art;
import java.util.*;
import java.io.*;

public class modernart {

    // Find max X (column) for a given color
    public static int returnMaxXValue(int[][] canvas, int color) {
        int maxX = -1;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == color) {
                    maxX = Math.max(maxX, j);
                }
            }
        }
        return maxX;
    }

    // Find max Y (row) for a given color
    public static int returnMaxYValue(int[][] canvas, int color) {
        int maxY = -1;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == color) {
                    maxY = Math.max(maxY, i);
                }
            }
        }
        return maxY;
    }

    // Find min X (column) for a given color
    public static int returnMinXValue(int[][] canvas, int color) {
        int minX = Integer.MAX_VALUE;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == color) {
                    minX = Math.min(minX, j);
                }
            }
        }
        return minX;
    }

    // Find min Y (row) for a given color
    public static int returnMinYValue(int[][] canvas, int color) {
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == color) {
                    minY = Math.min(minY, i);
                }
            }
        }
        return minY;
    }

    public static void main(String[] args) throws IOException {
        // Read input
        File inputFile = new File("art.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
        Scanner fileScanner = new Scanner(inputFile);

        int N = fileScanner.nextInt();
        int[][] canvas = new int[N][N];
        fileScanner.nextLine();

        Set<Integer> colors = new HashSet<>();

        // Populate canvas and identify all colors
        for (int i = 0; i < N; i++) {
            String line = fileScanner.nextLine();
            for (int j = 0; j < N; j++) {
                int color = Character.getNumericValue(line.charAt(j));
                canvas[i][j] = color;
                if (color > 0) {
                    colors.add(color);
                }
            }
        }

        // Determine which colors can be the first
        Set<Integer> possibleFirstColors = new HashSet<>(colors);
        for (int color : colors) {
            int minX = returnMinXValue(canvas, color);
            int maxX = returnMaxXValue(canvas, color);
            int minY = returnMinYValue(canvas, color);
            int maxY = returnMaxYValue(canvas, color);

            // Check if any other color overlaps this rectangle
            for (int i = minY; i <= maxY; i++) {
                for (int j = minX; j <= maxX; j++) {
                    if (canvas[i][j] != color && canvas[i][j] != 0) {
                        possibleFirstColors.remove(canvas[i][j]);
                    }
                }
            }
        }

        // Output the result
        out.println(possibleFirstColors.size());
        out.close();
    }
}
