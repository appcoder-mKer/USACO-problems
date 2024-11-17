package cowqueue;
import java.util.*;  
import java.io.*;  
public class cowqueue {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("cowqueue.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        Scanner fileScanner = new Scanner(inputFile);
        int numberOfCows = fileScanner.nextInt();
        int[][] cowTimes = new int[numberOfCows][2];
        int time = 0;
        for(int i = 0;i<numberOfCows;i++){
            cowTimes[i][0]=fileScanner.nextInt();
            cowTimes[i][1]=fileScanner.nextInt();
                }
        Arrays.sort(cowTimes,(a, b) -> Integer.compare(a[0], b[0]));

        
        for(int i = 0; i<numberOfCows;i++){
            int firstElement = cowTimes[i][0];
            int secondElement =cowTimes[i][1];
            
            if(time<firstElement){
                time=firstElement+secondElement;
            }
            else{
                time+=secondElement;
            }

        }

        // // System.out.println(cowTimes);
        // System.out.println(time);
    

        //1. sort the array so that we can pull it easoly
        //2. using a for loop pull the cowtime and if the 1st number + the second is equal to the next number  or less skip to the next number 
        //3.start adding till we fnish and then return that    

            out.print(time);
            out.close();  
        }  
}  