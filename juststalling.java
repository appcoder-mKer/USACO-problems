import java.util.*;  
import java.io.*;  
public class juststalling {  
    public static void main(String[] args) throws IOException{  
        Scanner fileScanner = new Scanner(System.in);
        ArrayList<Integer> cowLength = new ArrayList<Integer>();
        ArrayList<Integer> stallLength = new ArrayList<Integer>();

        int numberOfCows = fileScanner.nextInt(); //4
        
        for(int i = 0; i<numberOfCows; i++){
            cowLength.add(fileScanner.nextInt());
        }
        for(int i = 0; i<numberOfCows; i++){
            stallLength.add(fileScanner.nextInt());
        }
        Collections.sort(cowLength, (a, b) -> b - a);
        Collections.sort(stallLength, (a, b) -> b - a);        
        // System.out.println(cowLength);
        // System.out.println(cowLength);
        int numberOfTimesAppear = 0; 
        int numberOfCombo = 1;
        int skipindex = -1;
        for(int i = 0; i<numberOfCows; i++){

            int theCow = cowLength.get(i);
          
            for(int n = 0; n<numberOfCows;n++){
                if(n<=skipindex){
                    continue;
                }
                
                if(theCow<=stallLength.get(n)){
                    numberOfTimesAppear+=1;


                    }
            }
            numberOfCombo*=numberOfTimesAppear;
           

            numberOfTimesAppear = 0;
            skipindex+=1;
        }

        System.out.println(numberOfCombo);
        }  
}  







//the first step is to get the numbers and add the cows and stalls to an arraylist 
//second step is once we get the numbers we loop and check how many of the other arraylist the biggest cow can be put in
