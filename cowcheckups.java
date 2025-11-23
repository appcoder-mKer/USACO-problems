import java.util.ArrayList;
import java.util.Scanner;

public class cowcheckups {
    



/*

counts how many subarrays there are. Where "i" is the center of the reversal  = (i, N-i-1)
Tells us how many subarrays given the lengh of N = N(N+1)/2
R<i = just the subarray of "i"
L>i  = the subarray of (N-i-1)
Min(i, N-i-1)

R<i+L>i + min = total value your print 

*/

public static int subArraysCount(int numCows){
    return (numCows*(numCows+1))/2;
}




public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
int numCows = scanner.nextInt(); 
ArrayList<Integer> fjorder = new ArrayList<Integer>();
ArrayList<Integer> vetorder = new ArrayList<Integer>();
int counter = 0; 
for(int  i = 0; i<numCows;i++){
    // int currentInt = scanner.nextInt();
   fjorder.add(scanner.nextInt()); 
}
for(int  i = 0; i<numCows;i++){
    vetorder.add(scanner.nextInt()); 
 }

for(int i = 0; i<fjorder.size();i++){
    if (fjorder.get(i)==vetorder.get(i)) {
        counter++;
        int varone = subArraysCount(i-1);
        int vartwo = subArraysCount(numCows-i-1);
        int varthree = Math.min(i, numCows-i-1);
        counter = varone+vartwo+varthree;
        
    }
}

//next case, if "i" doesnt move. This is swapping case
//find and index where a{i} = b[j]
//find the reversal subarray that swaps them
//to swap them, they need to be the same distance away from some midpoint
//mininum length reversal where we
//find when two match, calcuate the mininum sum array. 
//each possible reversal is 1 in the counter 



for(int i = 0; i<counter; i++){

}




System.out.println(counter);




}
}
