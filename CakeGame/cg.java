package CakeGame;
import java.util.*;  
import java.io.*;  
public class cg {  
    public static void main(String[] args) throws IOException{  
        Scanner scanner = new Scanner(System.in);        
        int numOfTestCases = scanner.nextInt();
        int bessieSum = 0; 
        long answer = 0;         
        for(int i = 0; i<numOfTestCases; i++){
            int sizeOfArray = scanner.nextInt(); 
            // int M = scanner.nextInt();
            ArrayList<Long> set = new ArrayList<Long>();

            long[] psums = new long[sizeOfArray + 1];

            // for(int b =0; b<sizeOfArray;b++){
            //     set.add(scanner.nextLong());
                
            // }
            // System.out.println(set);

		    for (int b = 1; b <psums.length; b++) {
                 psums[b] = psums[b-1] + scanner.nextLong();
                
            }
            //  System.out.println(Arrays.toString(psums));


            int numOfBessieTurn = sizeOfArray/2;
            int numOfBessieCake = numOfBessieTurn+1;
            bessieSum+=psums[numOfBessieCake]-psums[numOfBessieTurn];
            long largetsNumber = Long.MAX_VALUE; 


        //    for(int t = 0; t<numOfBessieCake;t++){
                

                for(int w = 0; w<numOfBessieTurn;w++){
                    long oneSet = psums[numOfBessieTurn+w+1]-psums[w];
                    // System.out.println(numOfBessieCake+w+1);
                    if (oneSet<largetsNumber) {
                    largetsNumber = oneSet;
                    }
                }
                answer = psums[sizeOfArray] - largetsNumber;

               



        // }


//loop through over half of the numbers so you get the most amount 
//loop over n- n/2 = 1/2
//there each value for I is i at the first elemtn and then the last one will be N/2+i+1
//take the minium bc thats what bessie will take

System.out.println(largetsNumber +" " + answer);
answer = 0;

}













    }  
}  