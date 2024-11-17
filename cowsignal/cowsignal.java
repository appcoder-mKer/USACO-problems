package cowsignal;
import java.util.*;  
import java.io.*;  
public class cowsignal {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("cowsignal.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        Scanner fileScanner = new Scanner(inputFile);

        ArrayList<String> finalCow = new ArrayList<String>();
        int m = fileScanner.nextInt();
        int n = fileScanner.nextInt();
        int k = fileScanner.nextInt();
fileScanner.nextLine();
        for(int i = 0; i<m; i++){

            String line = fileScanner.nextLine();
            String expandedLine = "";

            for(int w=0; w<n;w++){
            char character = line.charAt(w);
            String letter = String.valueOf(character);
            for(int p=0;p<k;p++){
                expandedLine+=letter;
            }
        }
            for(int b=0;b<k;b++){
                out.println(expandedLine);
            }

           
        }


            out.close();  
        }  
}  