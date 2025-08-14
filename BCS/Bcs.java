package BCS;
import java.util.*;
import java.io.*;

public class Bcs {

    public static boolean canCombineWithShift(char[][] piece1, char[][] piece2, char[][] target, int dx1, int dy1, int dx2, int dy2) {
        int n = target.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean inPiece1 = (i - dx1 >= 0 && i - dx1 < n && j - dy1 >= 0 && j - dy1 < n && piece1[i - dx1][j - dy1] == '#');
                boolean inPiece2 = (i - dx2 >= 0 && i - dx2 < n && j - dy2 >= 0 && j - dy2 < n && piece2[i - dx2][j - dy2] == '#');
                boolean inTarget = target[i][j] == '#';

                if (inPiece1 && inPiece2) return false; // Overlapping pieces
                if ((inPiece1 || inPiece2) != inTarget) return false; // Must match target
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("bcs.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));
        Scanner fileScanner = new Scanner(inputFile);

        int sizeOfGrid = fileScanner.nextInt();
        int k = fileScanner.nextInt();
        fileScanner.nextLine(); // Consume the newline character

        // Read the complete figurine
        char[][] completeFigurine = new char[sizeOfGrid][sizeOfGrid];
        for (int i = 0; i < sizeOfGrid; i++) {
            completeFigurine[i] = fileScanner.nextLine().toCharArray();
        }

        // Read the broken pieces
        char[][][] pieces = new char[k][sizeOfGrid][sizeOfGrid];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sizeOfGrid; j++) {
                pieces[i][j] = fileScanner.nextLine().toCharArray();
            }
        }

        // Find the two pieces that fit together
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                for (int dx1 = 0; dx1 < sizeOfGrid; dx1++) {
                    for (int dy1 = 0; dy1 < sizeOfGrid; dy1++) {
                        for (int dx2 = 0; dx2 < sizeOfGrid; dx2++) {
                            for (int dy2 = 0; dy2 < sizeOfGrid; dy2++) {
                                if (canCombineWithShift(pieces[i], pieces[j], completeFigurine, dx1, dy1, dx2, dy2)) {
                                    out.println((i + 1) + " " + (j + 1));
                                    out.close();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        fileScanner.close();
        out.close();
    }
}
