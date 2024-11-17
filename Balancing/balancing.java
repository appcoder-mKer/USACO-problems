/*
ID: nakul.s1
LANG: JAVA
TASK: speeding
*/

import java.io.*;
import java.util.*;

public class balancing {

  public static void main(String[] args) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
    File inputFile = new File("balancing.in");
    Scanner fileScanner = new Scanner(inputFile);
    int numOfCows = fileScanner.nextInt();
    int biggestSize = fileScanner.nextInt();
    int[][] coordinates = new int[numOfCows][2];
    for (int i = 0; i < numOfCows; i++) { // Corrected loop condition
      coordinates[i][0] = fileScanner.nextInt();
      coordinates[i][1] = fileScanner.nextInt();
    }

    int minMax = numOfCows; // Initialize with maximum possible value

    // Try all possible fence positions along the x-axis
    for (int a = 2; a <= biggestSize; a += 2) {
      // Try all possible fence positions along the y-axis
      for (int b = 2; b <= biggestSize; b += 2) {
        int[] quadrants = new int[4]; // Count cows in each quadrant
        for (int i = 0; i < numOfCows; i++) { // Corrected loop condition
          if (coordinates[i][0] < a && coordinates[i][1] < b) {
            quadrants[0]++;
          } else if (coordinates[i][0] >= a && coordinates[i][1] < b) {
            quadrants[1]++;
          } else if (coordinates[i][0] < a && coordinates[i][1] >= b) {
            quadrants[2]++;
          } else {
            quadrants[3]++;
          }
        }
        int maxQuadrant = 0; // Find the quadrant with the maximum cows
        for (int i = 0; i < 4; i++) {
          if (quadrants[i] > maxQuadrant) {
            maxQuadrant = quadrants[i];
          }
        }
        // Update minMax if a better balance is found
        if (maxQuadrant < minMax) {
          minMax = maxQuadrant;
        }
      }
    }

    out.println(minMax);
    out.close();
  }
}