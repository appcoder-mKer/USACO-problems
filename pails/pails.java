package pails;
import java.util.*;  
import java.io.*;  
public class pails {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("pails.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        Scanner fileScanner = new Scanner(inputFile);

    int x = fileScanner.nextInt();
    int y = fileScanner.nextInt();
    int m = fileScanner.nextInt();

    int smallMax = m/x;
    int mediumMax = m/y;
    int closeCorrectNumber = 0;
    for(int i =0; i<m+1;i++){
        for(int j = 0; j<m;j++){

                int number = (i*x)+(y*j);
                if(closeCorrectNumber<number && number<=m){
                    closeCorrectNumber=number;
                
            } 
            
        
       

    }
    }


        out.println(closeCorrectNumber);
        out.close();  
    }  
}  