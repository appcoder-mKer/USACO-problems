package Acowdemia;
import java.io.*;
import java.util.*;

class Acowdemia {

    // Function to calculate the h-index given a list of citation counts
    public static int calculateHIndex(int numOfPapers, ArrayList<Integer> citationPapers) {
        int HIndex = 0;
        for (int i = 0; i < numOfPapers; i++) {
            if (citationPapers.get(i) >= i + 1) {
                HIndex = i + 1;
            } else {
                break;
            }
        }
        return HIndex;
    }

    public static void main(String[] args) throws IOException {
        // Input and output file handling
        BufferedReader br = new BufferedReader(new FileReader("Acowdemia.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Acowdemia.out")));

        // Read the first line: N (number of papers) and L (number of extra citations allowed)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // Read the second line: citations for each paper
        ArrayList<Integer> citationPapers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            citationPapers.add(Integer.parseInt(st.nextToken()));
        }

        // Sort citation counts in descending order
        Collections.sort(citationPapers, Collections.reverseOrder());

        // Calculate the initial h-index
        int currentHIndex = calculateHIndex(N, citationPapers);

        // Try to increase the h-index by adding up to L citations
    }
}