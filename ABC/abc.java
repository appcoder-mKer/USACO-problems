package ABC;
import java.util.*;  
import java.io.*;  
public class abc {  
    public static void main(String[] args) throws IOException{  
        Scanner fileScanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i = 0; i<7;i++){
        numbers.add(fileScanner.nextInt());
    }
    Collections.sort(numbers);
    int a = 0; 
    int b = 0; 
    int c = 0; 

    a = numbers.get(0);
    b = numbers.get(1);

    int sumOfAB = a+b;
    c = numbers.get(6)-sumOfAB;


    System.out.print(a+" "+b+" "+c);




            fileScanner.close();  
        }  
}  