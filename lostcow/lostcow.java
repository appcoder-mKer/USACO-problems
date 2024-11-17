package lostcow;

import java.util.*;  
import java.io.*;  


public class lostcow {

    public static void main(String[] args) throws IOException {  
        File inputFile = new File("lostcow.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        Scanner fileScanner = new Scanner(inputFile);

    int x = fileScanner.nextInt();
    int y = fileScanner.nextInt();
    int distance = 0;
    int orginalX = x;
    for(int i = 0; i<10;i++){
            int expo =(int)Math.pow(2,i);
            int beforex = orginalX+expo;
            distance = expo++;
            if(x<y){
                i++;
                expo =(int)Math.pow(2,i);
                int afterx = orginalX-expo;
                distance =  Math.abs(beforex-afterx);
                System.out.println(afterx);

            }
            System.out.println(beforex);


     }




        out.close();  
    }  
}  
