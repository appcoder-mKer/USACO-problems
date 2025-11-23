package LightsOn;
import java.util.*;  
import java.io.*;  
public class lightson {  

public static room [][] grid;
public static int rowNum;
public static int colNum;
public static boolean[][] visited;
public static int currSize=0;

public static void floodFill(int r, int c){
   // System.out.println(r +" "+ c);
    

    if((1>r||r>rowNum||1>c||c>colNum)){
    // System.out.println("Print because we have said grid[r][c is false and not a room]");
    return;
    }
    if (grid[r][c]==null) {
        // System.out.println("This is null");
        return;
    }
    if(grid[r][c].isLit()==false||visited[r][c]){
        return;
    }
    

 //   System.out.println(visited[r][c]);
    if (!visited[r][c]) {
        visited[r][c] = true; 
        // System.out.println("Print becuase we have made two var true");
    }
    
    // System.out.println(visited[r][c]);
   // System.out.println(grid[r][c].lightsOn);
for(int i =0; i< grid[r][c].lightsOn.size();i++){
    Integer[] temp = grid[r][c].lightsOn.get(i);
    grid[temp[0]][temp[1]].trueOn();  
    // System.out.println(temp[0]+" "+temp[1]);
    // System.out.println(grid[temp[0]][temp[1]].isLit());
    if(temp[0]+1<=rowNum&&visited[temp[0]+1][temp[1]]){
        floodFill(temp[0], temp[1]);

    }
    if(temp[0]-1>0&&visited[temp[0]-1][temp[1]]){
        floodFill(temp[0], temp[1]);

    }
    if(temp[1]+1<=colNum&&visited[temp[0]][temp[1]+1]){
        floodFill(temp[0], temp[1]);

    } if(temp[1]-1>0&&visited[temp[0]][temp[1]-1]){
        floodFill(temp[0], temp[1]);

    }


}

    
    floodFill(r, c+1);
    floodFill(r, c-1);
    floodFill(r+1, c);
    floodFill(r-1, c);


//have a for loop where if isLit is true it calls back and checks all its neighbors
//tell all of the lit rooms to visit your lit neighbors that havent been visited

// for(int i = 0; i<grid.length;i++){
//     for(int b = 0; b<grid[0].length;b++){

//         if (visited[i][b]) {
//             floodFill(r, c+1);
//             floodFill(r, c-1);
//             floodFill(r+1, c);
//             floodFill(r-1, c);
            
//         }
    
//     }

// }
}   



public class room{

    int roomX;
    int roomY;
    boolean lit;
    ArrayList<Integer[]> lightsOn = new ArrayList<Integer[]>();
    public void addRoom(int x, int y){

        Integer [] roomLightOn = new Integer[2];
        roomLightOn[0] = x;
        roomLightOn[1] = y;
        lightsOn.add(roomLightOn);

    }
    public boolean isLit(){
        return this.lit;
    }


    public void trueOn(){
        this.lit = true;
    }


    public room(int x, int y){
        this.roomX = x;
        this.roomY = y;
        this.lit = false;
    }    

}


    public static void main(String[] args) throws IOException{  
        File inputFile = new File("lightson.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        Scanner fileScanner = new Scanner(inputFile);

        rowNum = fileScanner.nextInt();
        colNum=rowNum;
        grid= new room[rowNum+1][colNum+1];
        visited = new boolean[rowNum+1][colNum+1];
        int numberOfLines = fileScanner.nextInt();

        fileScanner.nextLine();

        for(int i = 0; i<numberOfLines;i++){
            String x = fileScanner.nextLine();
            String[] xNum = x.split(" ");
            int[] intNumbers = new int[xNum.length];
            for (int b = 0; b < xNum.length; b++) {
                intNumbers[b] = Integer.parseInt(xNum[b].trim()); 
            }
            
                if(grid[intNumbers[0]][intNumbers[1]]==null){
                    grid[intNumbers[0]][intNumbers[1]] = new  lightson().new room(intNumbers[0],intNumbers[1]);
                }
                grid[intNumbers[0]][intNumbers[1]].addRoom(intNumbers[2], intNumbers[3]);

                if(grid[intNumbers[2]][intNumbers[3]]==null){

                    grid[intNumbers[2]][intNumbers[3]] = new  lightson().new room(intNumbers[2],intNumbers[3]);
                }

                
               // grid[i][j] = 
                
               // x.charAt(j);
        }




       
        currSize = 0;
        grid[1][1].trueOn();
        
        floodFill(1, 1);   
    for(int i = 1; i<= rowNum;i++){
        for(int b = 1; b<= colNum;b++){
            if(grid[i][b]!=null){
            if(grid[i][b].isLit()){
                currSize++;

            }
        }
        }
    }         
    // for (boolean[] row: visited) {
    //     System.out.println(Arrays.toString(row));
    // }     
        out.println(currSize);
            out.close();  

        }



//applying floodfill and modifying the logic to set up the rooms. start at 1,1. we first handle whats in the current room. we look at which room we are in, which room lights we can turn on. which neighbors lights are on so therefore we can travel to them (thats put in the if statemtn to check if we can visit said room.) 








        } 