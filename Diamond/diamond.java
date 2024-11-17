import java.io.*;
import java.util.*;
class diamond {
  
  
    public static void main (String [] args) throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));  
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        ArrayList<Integer> diamond = new ArrayList<Integer>();
        int numberOfDiamondInCase = 0; 
        int maxCount = 0; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfDiamond = Integer.parseInt(st.nextToken());
        int increment = Integer.parseInt(st.nextToken());
        for(int i = 0; i<numberOfDiamond;i++){
            diamond.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(diamond);
        for(int i = 0; i<diamond.size();i++){
        numberOfDiamondInCase = 0;
        for(int j = i; j<diamond.size();j++){
        if(diamond.get(j)-diamond.get(i)<=increment){
          numberOfDiamondInCase+=1;
          if(numberOfDiamondInCase>maxCount){
            maxCount = numberOfDiamondInCase;
          }
          
        }  
        else{
        break;

        }  
          
        }
        }
        
        
        out.println(maxCount);
        out.close();



    }
}