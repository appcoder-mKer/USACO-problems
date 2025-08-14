import java.io.*;
import java.util.*;

public class cc {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // Read the sequence
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(countDistinctMoos(N, arr));
    }
//subtrct one for every pair and then add one for spacing at the end 
//
    public static int countDistinctMoos(int N, int[] arr) {
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            positions.add(arr[i]);
        }

        Set<String> uniqueMoos = new HashSet<>();


        for(int i = 0; i<n)
        for (int y : positions.keySet()) {
            List<Integer> posList = positions.get(y);
            if (posList.size() < 2) continue; 

            for (int j = 1; j < posList.size(); j++) {  
                int pos1 = posList.get(j - 1);
                int pos2 = posList.get(j);
                for (int i = 0; i < pos1; i++) {
                    if (arr[i] != y) {  // x must be different from y
                        uniqueMoos.add(arr[i] + " " + y + " " + y);
                    }
                }
            }
        }

        return uniqueMoos.size();
    }
}





//count how many pairs we have before reversal 
//Make a middle index which the pairs are able to grow off(make it as big as possible on oth sides)
//# of pairs = # of pairs from previous subarray + # paird outisde subarray - pairs broken + pairs made
//pairs broken and pairs made is 0,1,2