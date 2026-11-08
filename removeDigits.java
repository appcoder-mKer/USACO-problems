import java.io.*;
import java.util.*;  

public class removeDigits {

    public static int remove(String currentNumber, int numMoves){
        if(currentNumber.length()<2){
            return numMoves+1;
        }
            int maxValue = 0; 
            int newNum = Integer.parseInt(currentNumber);
            for(int i = 0; i<currentNumber.length();i++){
                int value = Integer.parseInt(currentNumber.substring(i,i+1));
                if(value>maxValue){
                    maxValue = value; 
                }
            }
            newNum-=maxValue;  
            currentNumber = newNum+"";
            numMoves++;
            return remove(currentNumber,numMoves);
    }
   
public static void main(String[] args) throws IOException{  
    Scanner scanner = new Scanner(System.in);

    int number = scanner.nextInt();
    String num = number+"";


    System.out.print(remove(num,0));
    }
}
