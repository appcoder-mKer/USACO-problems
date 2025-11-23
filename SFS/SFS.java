package SFS;
import java.util.*;  
import java.io.*;  
public class SFS {  
    public static void main(String[] args) throws IOException{  
    Scanner scanner = new Scanner(System.in);
    int numberOfCows = scanner.nextInt();
    scanner.nextLine();
for(int i = 0; i<numberOfCows;i++){    
    StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
    Long cowOne = Long.parseLong(tokenizer.nextToken());
    Long cowTwo = Long.parseLong(tokenizer.nextToken());
    Long answer = Long.MAX_VALUE;
    for(int b = 0; cowTwo>>b>0;b++){
        long numOperations = 0; 
        long prefix = cowTwo>>b;
        long cow = cowOne;
        System.out.println("Cow one: "+ cowOne);
        System.out.println("Cow two: "+ cowTwo);
        while (cow>prefix) {
            if(cow%2L ==1L){
                cow++;
                numOperations++;
            }
            cow/=2L;
            numOperations++;
        }
        numOperations+=prefix-cow;
        numOperations+=b;
        numOperations+=Long.bitCount(cowTwo & ((1L << b) - 1L));
        System.out.println(cowTwo & ((1L << b) - 1L));
        System.out.println("B: "+b);
        System.out.println("Number of operation: "+ numOperations);
    }
    answer = Math.min(answer, numOperations);
}
System.out.print(out);






        
//have a function for the additon, subtraction, multiplication, and division by 2
//have the division check is its divisibel by 2 first
//run many simulations using a while loop that checks the 1st number until it is like the second number


        
        }  
}  