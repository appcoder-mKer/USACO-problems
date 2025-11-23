package Perimeter;
import java.util.*;  
import java.io.*;  
public class perimeter {  


    public static int[][]grid;
    public static int rowNum;
    public static int colNum;
    public static boolean[][]visited;
    public static int currSize=0;
    public static int perimeter=0;

    public static int countEdges(boolean[][]visited, int r, int c){
        int neighborVisited = 0;

        if(r+1<rowNum && visited[r+1][c]){
            neighborVisited++;
        }
        if(r-1>=0 && visited[r-1][c]){
            neighborVisited++;
        }
        if(c+1<colNum&&visited[r][c+1]){
            neighborVisited++;
        }
        if(c-1>=0&&visited[r][c-1]){
            neighborVisited++;
        }
        return neighborVisited;

    }

    public static void floodfill(int r, int c, int color){
        if((r<0||r>=rowNum|| c<0||c>=colNum)||grid[r][c]!=color || visited[r][c])
return;
visited[r][c] = true;
currSize++;
//System.out.println(r+" "+ c);
int neighbors = countEdges(visited, r, c);

int edgesNeeded = (-2*neighbors)+4;
perimeter+=edgesNeeded;
//System.out.println(perimeter);
floodfill(r,c+1,color);
floodfill(r,c-1,color);
floodfill(r+1,c,color);
floodfill(r-1,c,color);


}

    public static void main(String[] args) throws IOException{  
        File inputFile = new File("perimeter.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        Scanner fileScanner = new Scanner(inputFile);

rowNum = fileScanner.nextInt();
colNum = rowNum;
grid = new int[rowNum][colNum];
visited = new boolean[rowNum][colNum];

fileScanner.nextLine();

for(int i = 0; i<rowNum;i++){
String x = fileScanner.nextLine();
    for(int j = 0; j< colNum;j++){
grid[i][j] = x.charAt(j);
}
}

int maxArea = 0;
int maxPeri = Integer.MAX_VALUE
;
for(int r = 0; r<rowNum;r++){

    for(int c =0; c<colNum; c++){
        if(!visited[r][c] && grid[r][c] == '#'){

            floodfill(r,c,grid[r][c]);
          //  System.out.println(currSize);
            for(boolean[]row: visited){
         //   System.out.println(Arrays.toString(row));
            }

            
            if(currSize>maxArea){
                maxArea = currSize;
                maxPeri = perimeter;
            }

            else if(currSize==maxArea){
                if(perimeter<maxPeri){
                    maxPeri = perimeter;
                }

            }

           //System.out.println(perimeter);
            
            currSize = 0; 
            perimeter = 0; 

        }
    }
}

out.print(maxArea);
out.print(" ");
out.print(maxPeri);




//Look at every cell in the grid.
// If you find a # that hasn’t been visited yet, explore the whole blob connected to it (using DFS or BFS).
//While exploring, count how many # cells there are (that’s the area).
// Also count edges of each # that touch either the edge of the grid or a . (that’s the perimeter).
// Keep track of the blob with the biggest area. If two blobs have the same area, pick the one with the smaller perimeter.
//At the end, print the area and perimeter of that blob.
//1 neighbor - +2
//2 neighbor +0
//3 neighbor -2
//4 neighhor -4
//function: y=-2x+4



            out.close();  
        }  
    }