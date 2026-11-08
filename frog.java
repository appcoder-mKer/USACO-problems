import java.util.*;  
import java.io.*; 
public class frog {  

public static int minJump(int cost, int rock, ArrayList<Integer> path){
    if(rock==path.size()-1){
        return cost;
    }
    else{
        int currentRock = path.get(rock);
        int nextRock = path.get(rock+1);
        int firstOne = Math.abs(nextRock-currentRock);
        if(rock+2>path.size()-1){
           return Math.min(minJump(cost+firstOne, rock+1, path), (Integer.MAX_VALUE));
        }
        else{
        int nextNextRock = path.get(rock+2);
        int secondOne = Math.abs(nextRock-nextNextRock);
        return Math.min(minJump(cost+firstOne, rock+1, path), minJump(cost+secondOne, rock+2, path));
        }
    }
}



    public static void main(String[] args) throws IOException{  
    Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> path = new ArrayList<Integer>();
        int numOfRocks = scanner.nextInt();
        for(int i = 0; i<numOfRocks;i++){
            path.add(scanner.nextInt());
        }  
        System.out.println(minJump(0, 0, path));



        }  
}  