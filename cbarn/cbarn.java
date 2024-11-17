package cbarn;
import java.util.*;  
import java.io.*;  

class cbarn {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("cbarn.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        Scanner fileScanner = new Scanner(inputFile);
        ArrayList<Integer> numberOfCowsInEachRoom = new ArrayList<Integer>();
        int numberOfRooms = fileScanner.nextInt();
        int minNum = Integer.MAX_VALUE;
        int tempDistance = 0;
        int distance = 0; 
        for(int i = 0; i<numberOfRooms; i++){
            int numberOfCows = fileScanner.nextInt();
            numberOfCowsInEachRoom.add(numberOfCows);
        }

    for(int i = 0; i<numberOfRooms;i++) {
       int lastNum = numberOfCowsInEachRoom.remove(numberOfCowsInEachRoom.size()-1);
        numberOfCowsInEachRoom.add(0,lastNum);
        for(int b = 0; b<numberOfRooms;b++){
            distance = b*numberOfCowsInEachRoom.get(b);
            tempDistance= tempDistance+distance;

   }

   if(tempDistance<minNum){
    minNum = tempDistance;

    }
tempDistance=0;

}




out.println(minNum);
    out.close();  
    }  
}  