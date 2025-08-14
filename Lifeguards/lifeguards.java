import java.io.*;
import java.util.*;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lifeguards.out"));

        int N = Integer.parseInt(br.readLine());
        int[][] shifts = new int[N][2];
        TreeSet<Integer> timesSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            shifts[i][0] = start;
            shifts[i][1] = end;
            timesSet.add(start);
            timesSet.add(end);
        }

        // Coordinate compression
        List<Integer> timesList = new ArrayList<>(timesSet);
        Map<Integer, Integer> compress = new HashMap<>();
        for (int i = 0; i < timesList.size(); i++) {
            compress.put(timesList.get(i), i);
        }

        int[] coverage = new int[timesList.size()];  // compressed coverage

        // Mark initial full coverage
        for (int[] shift : shifts) {
            int start = compress.get(shift[0]);
            int end = compress.get(shift[1]);
            for (int i = start; i < end; i++) {
                coverage[i]++;
            }
        }

        int maxTime = 0;

        // Try removing each lifeguard
        for (int k = 0; k < N; k++) {
            int[] tempCoverage = Arrays.copyOf(coverage, coverage.length);

            int start = compress.get(shifts[k][0]);
            int end = compress.get(shifts[k][1]);

            // Subtract this guard's coverage
            for (int i = start; i < end; i++) {
                tempCoverage[i]--;
            }

            // Calculate total covered time
            int total = 0;
            for (int i = 0; i < tempCoverage.length; i++) {
                if (tempCoverage[i] > 0) {
                    // Add the true time span for this interval
                    total += timesList.get(i + 1) - timesList.get(i);
                }
            }

            maxTime = Math.max(maxTime, total);
        }

        pw.println(maxTime);
        pw.close();
    }
}
