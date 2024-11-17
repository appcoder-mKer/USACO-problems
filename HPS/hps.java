package HPS;
import java.util.*;
import java.io.*;

class hps {
    public static void main(String[] args) throws IOException {
        // Reading input
        Scanner fileScanner = new Scanner(new File("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        int numberOfGames = fileScanner.nextInt();
        int[][] games = new int[numberOfGames][2];

        for (int i = 0; i < numberOfGames; i++) {
            games[i][0] = fileScanner.nextInt(); 
            games[i][1] = fileScanner.nextInt(); 
        }

        int[][] mappings = {
            {1, 2, 3}, // 1->Hoof, 2->Paper, 3->Scissors
            {1, 3, 2}, // 1->Hoof, 2->Scissors, 3->Paper
            {2, 1, 3}, // 1->Paper, 2->Hoof, 3->Scissors
            {2, 3, 1}, // 1->Paper, 2->Scissors, 3->Hoof
            {3, 1, 2}, // 1->Scissors, 2->Hoof, 3->Paper
            {3, 2, 1}  // 1->Scissors, 2->Paper, 3->Hoof
        };

        int maxWins = 0;

        for (int[] map : mappings) {
            int currentWins = 0;

            for (int i = 0; i < numberOfGames; i++) {
                int cowOneMove = games[i][0];
                int cowTwoMove = games[i][1];

                int cowOneGesture = map[cowOneMove - 1];
                int cowTwoGesture = map[cowTwoMove - 1];

                if ((cowOneGesture == 1 && cowTwoGesture == 3) ||  // Hoof beats Scissors
                    (cowOneGesture == 2 && cowTwoGesture == 1) ||  // Paper beats Hoof
                    (cowOneGesture == 3 && cowTwoGesture == 2)) {  // Scissors beats Paper
                    currentWins++;
                }
            }

            maxWins = Math.max(maxWins, currentWins);
        }

        // Output the result
        out.println(maxWins);
        out.close();
    }
}
