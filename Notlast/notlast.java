import java.io.*;
import java.util.*;
class Main {
  
  
    public static void main (String [] args) throws IOException {

        HashMap<String,Integer> cowsMilkAmount = new HashMap<String,Integer>();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));  

        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		int numOfFarmersLogs = Integer.parseInt(br.readLine());
     for(int i = 0; i< numOfFarmersLogs;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
			String cow = st.nextToken();
			int milk = Integer.parseInt(st.nextToken()); 
			if(cowsMilkAmount.containsKey(cow)){
            int amountOfMilkAlready = cowsMilkAmount.get(cow);
            amountOfMilkAlready+=milk; //updated milk amount
            cowsMilkAmount.put(cow,amountOfMilkAlready);
			}
			else{
                cowsMilkAmount.put(cow,milk);
			}
    }
    int minNum = Integer.MAX_VALUE;
    int secondMinNumber = Integer.MAX_VALUE;
    String name = "";
    for(String key: cowsMilkAmount.keySet()){
    if(cowsMilkAmount.get(key)<minNum){
        minNum = cowsMilkAmount.get(key); 
    }
    }
    for(String key: cowsMilkAmount.keySet()){
        if(cowsMilkAmount.get(key)>minNum && cowsMilkAmount.get(key)<secondMinNumber){
            secondMinNumber = cowsMilkAmount.get(key);  
            name = key;

        }
        }


    out.println(name);
    out.close();    
    }
    
}