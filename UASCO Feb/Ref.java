
import java.util.Scanner;

public class Ref{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and U
        int N = scanner.nextInt();
        int U = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after integers

        // Read the canvas
        char[][] canvas = new char[N][N];
        for (int i = 0; i < N; i++) {
            String row = scanner.nextLine();
            canvas[i] = row.toCharArray();
        }

        // Calculate initial total
        int total = 0;
        for (int r = 1; r <= N / 2; r++) {
            for (int c = N / 2 + 1; c <= N; c++) {
                int cell1_r = r;
                int cell1_c = c;
                int cell2_r = r;
                int cell2_c = N - c + 1;
                int cell3_r = N - r + 1;
                int cell3_c = c;
                int cell4_r = N - r + 1;
                int cell4_c = N - c + 1;

                int countHash = 0;
                if (canvas[cell1_r - 1][cell1_c - 1] == '#') countHash++;
                if (canvas[cell2_r - 1][cell2_c - 1] == '#') countHash++;
                if (canvas[cell3_r - 1][cell3_c - 1] == '#') countHash++;
                if (canvas[cell4_r - 1][cell4_c - 1] == '#') countHash++;

                total += Math.min(countHash, 4 - countHash);
            }
        }

        System.out.println(total);

        // Process each update
        for (int u = 0; u < U; u++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after integers

            // Determine the original_r and original_c for the group
            int original_r = Math.min(r, N - r + 1);
            int original_c = Math.max(c, N - c + 1);

            // Calculate the four cells in the group
            int cell1_r = original_r;
            int cell1_c = original_c;
            int cell2_r = original_r;
            int cell2_c = N - original_c + 1;
            int cell3_r = N - original_r + 1;
            int cell3_c = original_c;
            int cell4_r = N - original_r + 1;
            int cell4_c = N - original_c + 1;

            // Compute old contribution
            int countHashOld = 0;
            if (canvas[cell1_r - 1][cell1_c - 1] == '#') countHashOld++;
            if (canvas[cell2_r - 1][cell2_c - 1] == '#') countHashOld++;
            if (canvas[cell3_r - 1][cell3_c - 1] == '#') countHashOld++;
            if (canvas[cell4_r - 1][cell4_c - 1] == '#') countHashOld++;
            int contribOld = Math.min(countHashOld, 4 - countHashOld);
            total -= contribOld;

            // Toggle the cell
            int row = r - 1;
            int col = c - 1;
            canvas[row][col] = canvas[row][col] == '#' ? '.' : '#';

            // Compute new contribution
            int countHashNew = 0;
            if (canvas[cell1_r - 1][cell1_c - 1] == '#') countHashNew++;
            if (canvas[cell2_r - 1][cell2_c - 1] == '#') countHashNew++;
            if (canvas[cell3_r - 1][cell3_c - 1] == '#') countHashNew++;
            if (canvas[cell4_r - 1][cell4_c - 1] == '#') countHashNew++;
            int contribNew = Math.min(countHashNew, 4 - countHashNew);
            total += contribNew;

            System.out.println(total);
        }

        scanner.close();
    }
}