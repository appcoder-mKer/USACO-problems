/*
ID: nakul.s1
LANG: JAVA
TASK: speeding
*/

import java.io.*;
import java.util.*;

public class Speeding {

  public static void main(String[] args) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
    File inputFile = new File("speeding.in");
    Scanner fileScanner = new Scanner(inputFile);
    int N = fileScanner.nextInt();
    int M = fileScanner.nextInt();
    int[] roadLengths = new int[N];
    int[] roadLimits = new int[N];
    int[] bessieLengths = new int[M];
    int[] bessieSpeeds = new int[M];

    for (int i = 0; i < N; i++) {
      roadLengths[i] = fileScanner.nextInt();
      roadLimits[i] = fileScanner.nextInt();
    }
    for (int i = 0; i < M; i++) {
      bessieLengths[i] = fileScanner.nextInt();
      bessieSpeeds[i] = fileScanner.nextInt();
    }

    int maxOverLimit = 0;
    int speedOverLimit = 0;
    int bessieIndex = 0;
    int roadIndex = 0;
    int currentRoadLength = 0;
    int currentBessieLength = 0;
    int roadRemain = roadLengths[roadIndex];
    int bessieRemain = bessieLengths[bessieIndex];

    while (bessieIndex < M && roadIndex < N) {
      // If Bessie's current segment is longer than the current road segment
      if (bessieRemain > roadRemain) {
        // Iterate through the current road segment and calculate speed over limit
        for (int i = 0; i < roadRemain; i++) {
          speedOverLimit = bessieSpeeds[bessieIndex] - roadLimits[roadIndex];
          if (speedOverLimit > maxOverLimit) {
            maxOverLimit = speedOverLimit;
          }
        }

        // Update remaining distances
        bessieRemain -= roadRemain;
        roadRemain = 0; // Road segment is fully covered
        roadIndex++; // Move to the next road segment

        // If there are more road segments
        if (roadIndex < N) {
          roadRemain = roadLengths[roadIndex]; // Reset roadRemain for the new segment
        }

      } else if (bessieRemain < roadRemain) { // Bessie's segment is shorter
        // Iterate through Bessie's current segment
        for (int i = 0; i < bessieRemain; i++) {
          speedOverLimit = bessieSpeeds[bessieIndex] - roadLimits[roadIndex];
          if (speedOverLimit > maxOverLimit) {
            maxOverLimit = speedOverLimit;
          }
        }

        // Update remaining distances
        roadRemain -= bessieRemain;
        bessieRemain = 0; // Bessie's segment is fully covered
        bessieIndex++; // Move to the next Bessie segment

        // If there are more Bessie segments
        if (bessieIndex < M) {
          bessieRemain = bessieLengths[bessieIndex]; // Reset bessieRemain for the new segment
        }

      } else { // Bessie's segment and road segment are the same length
        for (int i = 0; i < bessieRemain; i++) {
          speedOverLimit = bessieSpeeds[bessieIndex] - roadLimits[roadIndex];
          if (speedOverLimit > maxOverLimit) {
            maxOverLimit = speedOverLimit;
          }
        }

        // Both segments are fully covered
        bessieIndex++;
        roadIndex++;
        if (bessieIndex < M) {
          bessieRemain = bessieLengths[bessieIndex];
        }
        if (roadIndex < N) {
          roadRemain = roadLengths[roadIndex];
        }
      }
    }

    out.println(maxOverLimit);
    out.close();
  }
}