package Berries;
import java.util.*;  
import java.io.*;  

public class berries {  
    public static void main(String[] args) throws IOException {  
        File inputFile = new File("berries.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        Scanner fileScanner = new Scanner(inputFile);

        int numOfTrees = fileScanner.nextInt();
        int numOfBaskets = fileScanner.nextInt();
        ArrayList<Integer> numOfBerries = new ArrayList<Integer>();
        int biggest = 0; 

        for (int i = 0; i < numOfTrees; i++) {
            int x = fileScanner.nextInt();
            numOfBerries.add(x);
            if (x>biggest) {
                biggest = x;
            }
        }

        // Collections.sort(numOfBerries, Collections.reverseOrder());
        int max = 0;

        for (int i = 1; i <= biggest; i++) {
            int totalNumOfBasketswithIBerries = 0;
            ArrayList<Integer> remainders = new ArrayList<Integer>();

            for (int b = 0; b < numOfTrees; b++) {
                totalNumOfBasketswithIBerries += numOfBerries.get(b) / i;
                remainders.add(numOfBerries.get(b) % i);
            }

            if (totalNumOfBasketswithIBerries < numOfBaskets / 2) {
                continue;
            }

            if (totalNumOfBasketswithIBerries >= numOfBaskets) {
                max = Math.max(max, i * (numOfBaskets / 2));
            }

            else { 
                int bessie = i * (totalNumOfBasketswithIBerries - numOfBaskets / 2);

                Collections.sort(remainders, Collections.reverseOrder());
                int need = numOfBaskets - totalNumOfBasketswithIBerries;
                // System.out.println(need);
                for (int j = 0; j < need && j<numOfTrees; j++) {
                    bessie += remainders.get(j);
                }

                max = Math.max(max, bessie);
            }
        }

        out.println(max);
        out.close();
    }  
}  

//3 scenarions baskets <k/2


//2. baskets>= k 
//max = max(max, i*(k/2))

//3. k/2<= baskets<k
//fill remaining baskets with whats left 
//resortign the number of trees, and add the berries, starting with the tree with the most berries. 