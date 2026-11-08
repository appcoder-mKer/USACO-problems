package frog;
import java.util.*;  
import java.io.*;  
public class frog {  


public static int frogs(int n, ArrayList<Integer> heights, int currentcost){

        if(n==heights.size()-1){
            return currentcost;
        }

        else{
            int one = frogs(n+1,heights, currentcost+Math.abs(heights.get(n)-heights.get(n+1)));
            int two = Integer.MAX_VALUE;
            if(n+2<heights.size()){
            two = frogs(n+2,heights, currentcost+Math.abs(heights.get(n)-heights.get(n+2)));
            }
            return Math.min(one, two);
        }
}
    public static void main(String[] args) throws IOException{  
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        ArrayList<Integer> heights = new ArrayList<>();
        int currentcost = 0; 

        for(int i =0; i<n;i++){
            heights.add(scanner.nextInt());
        }
        System.out.println(heights);
       System.out.print(frogs(0,heights,0));




        }  
}  