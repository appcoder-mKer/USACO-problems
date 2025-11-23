package FJJO;
import java.util.*;  
import java.io.*;  
public class fjjo {  
    public static void main(String[] args) throws IOException{  
        
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int totalSum = 0; 

        for(int i = 0; i<numberOfTestCases;i++){
            int sizeOfArray = scanner.nextInt(); 
            int M = scanner.nextInt();
            ArrayList<Integer> set = new ArrayList<Integer>();


            for(int m =0; m<sizeOfArray;m++){
                set.add(scanner.nextInt());
                
            }
            int temp = 0; 
            int otherTemp = 0; 
            int roudUpDown = M/2;
            int currenyBest = Integer.MAX_VALUE;
           

            for(int p = 0; p < M; p++) {
                int x = p; 
                totalSum = 0; 
                for(int j = 0; j<set.size();j++){
                    // System.out.println(set.get(j));
                    // System.out.println(x);

                    if (Math.abs(set.get(j)-x)%M>roudUpDown) {
                        temp = M-((Math.abs(set.get(j)-(x)))%M);
                        totalSum+=temp;
                        // System.out.println("operations: " + temp);


                    }
                    else{
                        otherTemp = Math.abs(set.get(j)-x)%M;
                        // System.out.println("Other temp: "+otherTemp);
                        totalSum+=otherTemp;
                         

                    }
                    

                }
                if (totalSum<currenyBest) {
                    currenyBest = totalSum;

                }
                // System.out.println("total operations for x = " + x + " " + totalSum);
                // System.out.println();
            }

            System.out.println(currenyBest);

            // temp = 0; 
            // otherTemp = 0; 
            // totalSum = 0; 

        }





        }  
}