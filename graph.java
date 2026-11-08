import java.util.*;  
import java.io.*;  

public class graph {

    public static int paths(int gridSize, int rows, int columuns, Character[][] coorGraph){
        if(rows == 0 && columuns == 0){
            return 1; 
        }
        if(rows<0|| columuns<0 || coorGraph[rows][columuns]=='*'){
            return 0; 
        }
        else{
            return paths(gridSize, rows, columuns-1,coorGraph)+paths(gridSize, rows-1, columuns,coorGraph);
        }
    }



 public static void main(String[] args) throws IOException{  
    Scanner scanner = new Scanner(System.in);
    int rows= scanner.nextInt();
    Character[][] coorGraph = new Character[rows][rows];

    for(int i = 0; i< rows;i++){
        String line = scanner.nextLine();
        for(int b = 0; b<rows;b++){
            coorGraph[i][b] = line.charAt(b);
        }
    }

    System.out.println(paths(rows,rows-1, rows-1,coorGraph));


        }  



    
}
