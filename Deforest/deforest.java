package Deforest;
import java.util.*;
import java.io.*;

public class deforest {

    public static class Interval implements Comparable<Interval> {
        int startpoint;
        int endPoint;
        int numOfTreesNeeded;

        Interval(int startpoint, int endPoint, int numOfTreesNeeded) {
            this.startpoint = startpoint;
            this.endPoint = endPoint;
            this.numOfTreesNeeded = numOfTreesNeeded;
        }

        public int compareTo(Interval other) {
            return Integer.compare(this.endPoint, other.endPoint);
        }

        public String toString() {
            return "Startpoint: " + startpoint + ", Endpoint: " + endPoint + ", Trees needed: " + numOfTreesNeeded;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(System.in);

        int numberOfTestCases = fileScanner.nextInt();

        for (int t = 0; t < numberOfTestCases; t++) {
            int numberOfTrees = fileScanner.nextInt();
            int numberOfRestrictions = fileScanner.nextInt();

            ArrayList<Integer> treePositions = new ArrayList<>();
            for (int i = 0; i < numberOfTrees; i++) {
                treePositions.add(fileScanner.nextInt());
            }
            Collections.sort(treePositions);

            ArrayList<Interval> intervalArr = new ArrayList<>();
            for (int i = 0; i < numberOfRestrictions; i++) {
                int begPoint = fileScanner.nextInt();
                int endPoint = fileScanner.nextInt();
                int numOfTreesNeeded = fileScanner.nextInt();
                intervalArr.add(new Interval(begPoint, endPoint, numOfTreesNeeded));
            }

            Collections.sort(intervalArr);

            TreeSet<Integer> mustKeep = new TreeSet<>();
            int neededTrees = 0;

            for (Interval interval : intervalArr) {
                // find trees within this interval
                int treesInRange = 0;
                for (int pos : mustKeep) {
                    if (pos >= interval.startpoint && pos <= interval.endPoint)
                        treesInRange++;
                }

                // if not enough trees, add more from the rightmost available ones
                int needed = interval.numOfTreesNeeded - treesInRange;
                for (int i = treePositions.size() - 1; i >= 0 && needed > 0; i--) {
                    int pos = treePositions.get(i);
                    if (pos >= interval.startpoint && pos <= interval.endPoint && !mustKeep.contains(pos)) {
                        mustKeep.add(pos);
                        needed--;
                    }
                }
            }

            neededTrees = mustKeep.size();
            int maxCut = numberOfTrees - neededTrees;
            System.out.println(maxCut);
        }

        fileScanner.close();
    }
}
