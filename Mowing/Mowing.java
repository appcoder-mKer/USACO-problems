package Mowing;
import java.util.*;  
import java.io.*;  

public class Mowing {
    public static void main(String[] args) throws IOException {  
        File inputFile = new File("mowing.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        Scanner fileScanner = new Scanner(inputFile);

        int numberOfMoves = fileScanner.nextInt();
        fileScanner.nextLine();
        
        HashMap<String, Integer> visitedTimes = new HashMap<>();

        int currentX = 0, currentY = 0;
        int currentTime = 0;
        visitedTimes.put(currentX + "," + currentY, currentTime); 

        int minTimeDifference = Integer.MAX_VALUE;

        for (int i = 0; i < numberOfMoves; i++) {
            String[] directionArray = fileScanner.nextLine().split(" ");
            String direction = directionArray[0];  
            int steps = Integer.parseInt(directionArray[1]);  

            for (int step = 0; step < steps; step++) {
                currentTime++; 

                // Update position based on direction
                if (direction.equals("N")) {
                    currentY++;
                } else if (direction.equals("S")) {
                    currentY--;
                } else if (direction.equals("E")) {
                    currentX++;
                } else if (direction.equals("W")) {
                    currentX--;
                }

                String currentPosition = currentX + "," + currentY;

                if (visitedTimes.containsKey(currentPosition)) {
                    int lastVisitTime = visitedTimes.get(currentPosition);
                    int timeDifference = currentTime - lastVisitTime;

                    minTimeDifference = Math.min(minTimeDifference, timeDifference);
                }

                visitedTimes.put(currentPosition, currentTime);
            }
        }

        if (minTimeDifference == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(minTimeDifference);
        }

        out.close();
    }
}
