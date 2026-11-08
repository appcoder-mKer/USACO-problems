import java.io.*;
import java.util.*;  
public class RUG {  
    public static void main(String[] args) throws IOException{  
    Scanner scanner = new Scanner(System.in);

int number = scanner.nextInt();
int queries = scanner.nextInt();
int[] arr = new int[number];
    for(int i=0; i<number; i++){
        arr[i] = scanner.nextInt();
    }

minSegmentTree Tree = new minSegmentTree(arr);


    for(int q=1; q<=queries; q++){
        int current = scanner.nextInt();
        if(current==2){
            System.out.println(Tree.kValue(scanner.nextInt()));
        }
        if(current==1){
            int minIndex = scanner.nextInt();
            int maxIndex = scanner.nextInt();
            int increase = scanner.nextInt();
            Tree.set(minIndex, maxIndex, increase);
            System.out.println(Tree);
        }  
    }  


for(int i = 0; i<arr.length;i++){
    System.out.println(arr[i]);
}
    }
}