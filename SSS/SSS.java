import java.util.*;  
import java.io.*;  
public class SSS {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("div7.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        Scanner fileScanner = new Scanner(inputFile);

int numberOfCows = fileScanner.nextInt();
long[] sums = new long[numberOfCows+1];
sums[0] = 0;
for(int i = 1; i<=numberOfCows;i++){
    sums[i]= sums[i-1]+fileScanner.nextInt();
}
int MAXNUMBERS = 0; 



for(int i =0; i<numberOfCows;i++){    
    for(int j = i+1; j<numberOfCows;j++){
long num = sums[j] - sums[i];

if(num %7 == 0){
    System.out.println(j);
    System.out.println(i);
    System.out.println(sums[j] - sums[i]);
    System.out.println();



    if(MAXNUMBERS<j-i){
    MAXNUMBERS = j-i;
    }
}


    }

}





// System.out.println(MAXNUMBERS);

out.println(MAXNUMBERS);
out.close();

        }  
}  