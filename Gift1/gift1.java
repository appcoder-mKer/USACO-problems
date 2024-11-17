package Gift1;
/*
ID: nakul.s1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    
    public static void main(String[] args) throws IOException {

        HashMap <String,Integer> peoplesMoney = new HashMap<String,Integer>();

        BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfPeople = Integer.parseInt(st.nextToken());

        for(int i = 0; i<numberOfPeople; i++){

            String names = br.readLine();
            peoplesMoney.put(names, 0);
        }
        for(int i = 0; i<numberOfPeople; i++){

            String personsName = br.readLine();
            String money = br.readLine();
            String[] twoValues = money.split(" ", 2);
            String amountOfMoney = twoValues[0];
            String division = twoValues[1];
            Integer amountOfMoneyNumberical = Integer.parseInt(amountOfMoney);
            Integer divisionNumberical = Integer.parseInt(division);
            Integer leftover = 0;
            if (divisionNumberical == 0) {
                continue;
            }
            
            else{
            if(amountOfMoneyNumberical%divisionNumberical!=0){
                leftover = amountOfMoneyNumberical % divisionNumberical;

                Integer moneyLeft =leftover-amountOfMoneyNumberical;
                Integer currentMoney = peoplesMoney.get(personsName);
                Integer newAmountOfMoney =moneyLeft-currentMoney;
                peoplesMoney.put(personsName,newAmountOfMoney);

            }
            if(amountOfMoneyNumberical%divisionNumberical==0){
                Integer currentMoney = peoplesMoney.get(personsName);
                Integer newAmountOfMoney =currentMoney-amountOfMoneyNumberical;
                peoplesMoney.put(personsName,newAmountOfMoney);
            }
            Integer amountOfMoneyForEachPerson = 0;
            if(divisionNumberical == 0){
                amountOfMoneyForEachPerson = 0;
            }
            else{
            amountOfMoneyForEachPerson = (amountOfMoneyNumberical-leftover)/divisionNumberical;   
            }
            for(int b = 0; b<divisionNumberical;b++){
                personsName = br.readLine();
                Integer currentMoney = peoplesMoney.get(personsName);
                Integer newAmountOfMoney =currentMoney+amountOfMoneyForEachPerson;
                peoplesMoney.put(personsName,newAmountOfMoney);

            }
            }

        }

        for (Map.Entry<String, Integer> entry : peoplesMoney.entrySet()){ 
            String key = entry.getKey(); 
            Integer value = entry.getValue();
            out.println("Key: " + key + ", Value: " + value); 
             

    }
}
}