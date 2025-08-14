package angry;
import java.util.*;
import java.io.*;

public class angry {

    public static int checkNumberOfExplosions(ArrayList<Integer> hayBarrels, int index) {
        int numberOfExplosions = 1; 
        int radius = 1;
        int highestExploded = hayBarrels.get(index);
        int lowestExploded = hayBarrels.get(index);

        while (true) {
            boolean explodedInThisStep = false;

            for (int i = hayBarrels.indexOf(highestExploded) + 1; i < hayBarrels.size(); i++) {
                if (hayBarrels.get(i) <= highestExploded + radius) {
                    numberOfExplosions++;
                    highestExploded = hayBarrels.get(i);
                    explodedInThisStep = true;
                } else {
                    break;
                }
            }

            for (int i = hayBarrels.indexOf(lowestExploded) - 1; i >= 0; i--) {
                if (hayBarrels.get(i) >= lowestExploded - radius) {
                    numberOfExplosions++;
                    lowestExploded = hayBarrels.get(i);
                    explodedInThisStep = true;
                } else {
                    break;
                }
            }

            if (!explodedInThisStep) {
                break;
            }

            radius++; 
        }

        return numberOfExplosions;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("angry.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        Scanner fileScanner = new Scanner(inputFile);
        ArrayList<Integer> hayBarrels = new ArrayList<>();

        int numberOfHay = fileScanner.nextInt();
        for (int i = 0; i < numberOfHay; i++) {
            hayBarrels.add(fileScanner.nextInt());
        }

        fileScanner.close();
        Collections.sort(hayBarrels);

        int maxExplosions = 0;
        for (int i = 0; i < hayBarrels.size(); i++) {
            maxExplosions = Math.max(maxExplosions, checkNumberOfExplosions(hayBarrels, i));
        }

        out.println(maxExplosions);
        out.close();
    }
}