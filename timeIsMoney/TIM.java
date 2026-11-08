package timeIsMoney;
import java.util.*;  
import java.io.*;
import java.lang.reflect.Array;  

public class TIM {  

public static int trips(int currentCity, int money, int days, int limit, HashMap<Integer, ArrayList<Integer>> citiesConnected, ArrayList<Integer> mooniesCountPerCity){
    int biggestNum = 0;
    if(days==limit){

        return money- days*days;
    }
    else{
        ArrayList<Integer> cities = citiesConnected.get(currentCity);
        for(int i = 0; i<cities.size();i++){
            biggestNum=Math.max(biggestNum, trips(cities.get(i), money+mooniesCountPerCity.get(cities.get(i)-1), days+1,limit, citiesConnected, mooniesCountPerCity));
    }
        return biggestNum;
    }
}

    public static void main(String[] args) throws IOException{  
    Scanner scanner = new Scanner(System.in);


    int citiesNum = scanner.nextInt();
    int mooniesCount = scanner.nextInt();
    int constant = scanner.nextInt();
    int money = 0;
    int greatestMoney = 0;
    ArrayList<Integer> mooniesCountPerCity = new ArrayList<Integer>();
    for(int i=0;i<citiesNum;i++){
        mooniesCountPerCity.add(scanner.nextInt());
    }
    HashMap<Integer, ArrayList<Integer>> citiesConnected = new HashMap<Integer, ArrayList<Integer>>();
    for(int i=0;i<mooniesCount;i++){
        int cityA = scanner.nextInt();
        int cityB = scanner.nextInt();
        if(!citiesConnected.containsKey(cityA)){
            citiesConnected.put(cityA, new ArrayList<>());
        }
        citiesConnected.get(cityA).add(cityB);
        
        }  
    for(int i = 1; i<1000;i++){
    greatestMoney = Math.max(greatestMoney,trips(mooniesCount, money, 0, i, citiesConnected, mooniesCountPerCity));
    }
System.out.println(greatestMoney);




    }  
}