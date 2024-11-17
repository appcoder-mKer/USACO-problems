package Circlecross;
import java.util.*;  
import java.io.*;  

public class Circlecross {  
    public static void main(String[] args) throws IOException {  
        // Reading input and initializing output
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
        
        String letters = br.readLine();
        int[] firstAppearance = new int[26];  // Stores first appearance of each cow
        int[] secondAppearance = new int[26]; // Stores second appearance of each cow
        Arrays.fill(firstAppearance, -1);     // Initialize all to -1 to indicate not yet seen
        int crossovers = 0;
        
        // Record the positions of the first and second appearances of each cow
        for (int i = 0; i < 52; i++) {
            char cow = letters.charAt(i);
            int index = cow - 'A';  // Map 'A' to 0, 'B' to 1, ..., 'Z' to 25
            
            if (firstAppearance[index] == -1) {
                firstAppearance[index] = i;
            } else {
                secondAppearance[index] = i;
            }
        }

        // Check for crossings between every pair of cows
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                // Cow i's entry and exit points
                int firstA = firstAppearance[i];
                int secondA = secondAppearance[i];
                
                // Cow j's entry and exit points
                int firstB = firstAppearance[j];
                int secondB = secondAppearance[j];
                
                // Check if paths cross: one cow's entry is between the other's entry and exit, and vice versa
                if ((firstA < firstB && firstB < secondA && secondA < secondB) || 
                    (firstB < firstA && firstA < secondB && secondB < secondA)) {
                    crossovers++;
                }
            }
        }

        // Output the result
        out.println(crossovers);
        out.close();
    }
}
