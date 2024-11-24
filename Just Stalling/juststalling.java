import java.util.*;  
import java.io.*;  

public class juststalling {  
    public static void main(String[] args) throws IOException {  
        Scanner fileScanner = new Scanner(System.in);
        ArrayList<Integer> cowLength = new ArrayList<>();
        ArrayList<Integer> stallLength = new ArrayList<>();

        int numberOfCows = fileScanner.nextInt(); 
        
        for (int i = 0; i < numberOfCows; i++) {
            cowLength.add(fileScanner.nextInt());
        }
        
        for (int i = 0; i < numberOfCows; i++) {
            stallLength.add(fileScanner.nextInt());
        }
        
        Collections.sort(cowLength, (a, b) -> b - a);
        Collections.sort(stallLength, (a, b) -> b - a);        

        long numberOfCombo = 1;

        for (int i = 0; i < numberOfCows; i++) {
            int validStalls = 0;

            for (int j = 0; j < stallLength.size(); j++) {
                if (stallLength.get(j) >= cowLength.get(i)) {
                    validStalls++;
                } else {
                    break; 
                }
            }

            if (validStalls <= i) {
                numberOfCombo = 0;
                break;
            }

            numberOfCombo *= (validStalls - i); 
        }

        System.out.println(numberOfCombo);
    }  
}