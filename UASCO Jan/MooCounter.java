import java.io.*;
import java.util.*;


public class MooCounter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> frequencyofNumber = new HashMap<>();

        String N = scanner.nextLine();
        int n = Integer.parseInt(N);
        String input = scanner.nextLine();
        String[] inputSplit = input.split(" ");
        int[] inputSplitNumberVersion = new int[inputSplit.length];
        for(int i = 0;i < inputSplit.length;i++){
            inputSplitNumberVersion[i] = Integer.parseInt(inputSplit[i]);
        }
        int[] uniqueInt = new int[n];
        uniqueInt[0] = 1;
        System.out.println(Arrays.toString(inputSplitNumberVersion));
        //counting for frequncies
            for (int i = 1; i < n; i++) {

            if(frequencyofNumber.containsKey(inputSplitNumberVersion[i])){
                uniqueInt[i] = uniqueInt[i-1];
            }
            
           else{
            frequencyofNumber.put(inputSplitNumberVersion[i],1);

            uniqueInt[i] = uniqueInt[i-1]+1;

           }
        }
        int numberOfUniqueCombonations = 0;
        frequencyofNumber = new HashMap<>();



        for (int i = n-1; i >= 0; i--) {
            System.out.println(inputSplitNumberVersion[i]);
            if(frequencyofNumber.containsKey(inputSplitNumberVersion[i])){
                frequencyofNumber.put(inputSplitNumberVersion[i], frequencyofNumber.get(inputSplitNumberVersion[i])+1);

                if(frequencyofNumber.get(inputSplitNumberVersion[i])==2){
                    // System.out.println(i);
                    int uniquesIntsAtTheIndex = uniqueInt[i]; 
                    // System.out.println(uniquesIntsAtTheIndex);
                    // System.out.println(inputSplitNumberVersion[i]);
                    numberOfUniqueCombonations+=uniquesIntsAtTheIndex;
                }
                
            }
            else{
                frequencyofNumber.put(inputSplitNumberVersion[i],1);

            }

        }
        //decreasing for truplets

System.out.println(frequencyofNumber);

        for (int i = 1; i <= n; i++) {
            if(frequencyofNumber.containsKey(i)){

            if(frequencyofNumber.get(i)>=3){
                numberOfUniqueCombonations-=1;


            }
        }
    }
       

    



        // System.out.println(Arrays.toString(inputSplitNumberVersion));

System.out.println(Arrays.toString(uniqueInt));
        

System.out.println(numberOfUniqueCombonations);






     
    }
}
