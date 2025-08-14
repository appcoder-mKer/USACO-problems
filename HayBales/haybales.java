package HayBales;
import java.util.*;  
import java.io.*;  
public class haybales {  

    public static int binarySearch(int x, ArrayList<Integer> listofNum){
        int lower = 0; 
        int upper = listofNum.size()-1;
        while(lower <= upper){
          int middle = ((lower+upper)/2);
          if(x >= listofNum.get(middle)){
            lower = middle +1;
          }
          else{
            upper = middle -1;
          }
        }
        return lower; 
        
            
        }
          
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("haybales.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        Scanner fileScanner = new Scanner(inputFile);
        ArrayList<Integer> listofNum = new ArrayList<Integer>();

        int numberOfHay = fileScanner.nextInt();
        int queryNumber = fileScanner.nextInt();

        fileScanner.nextLine();
        String queryLine = fileScanner.nextLine();
        String[] strArray = queryLine.split(" ");
        // System.out.println(queryLine);

        for(int i = 0; i< numberOfHay;i++){
            listofNum.add(Integer.parseInt(strArray[i]));
        }
        listofNum.sort(null);
        
        // System.out.print(listofNum);
        
        //put the queries in a array

        // System.out.print(fileScanner.nextInt());
        // System.out.print(fileScanner.nextInt());


        for(int i = 0; i<queryNumber;i++){
          int firstNumber = fileScanner.nextInt();
          int secondNumber = fileScanner.nextInt();


          int x = binarySearch(firstNumber-1, listofNum);
         int y = binarySearch(secondNumber, listofNum);
        int querySize = y-x;
        out.println(querySize);

        }





            out.close();  

        }  
}  