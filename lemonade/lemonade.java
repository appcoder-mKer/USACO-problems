package lemonade;
import java.util.*;  
import java.io.*;  
public class lemonade {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("lemonade.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        Scanner fileScanner = new Scanner(inputFile);
        ArrayList<Integer> listOfCows = new ArrayList<Integer>();
        int numberOfCows = fileScanner.nextInt();

        for(int i = 0; i<numberOfCows; i++){
            listOfCows.add(fileScanner.nextInt());
        }
        Collections.sort(listOfCows,Collections.reverseOrder());
        // System.out.println(listOfCows);
        int minCows = 0;

        for(int i = 0; i<listOfCows.size();i++){
            if (listOfCows.get(i)>=minCows) {
                minCows++;
            }
        }
        out.println(minCows);

            out.close();  
        }  
}  