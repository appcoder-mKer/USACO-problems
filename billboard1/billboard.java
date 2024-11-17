package billboard1;

import java.util.*;  
import java.io.*;  

public class billboard {  
    // Method to check if the bottom-left corner of the lawnmower billboard is exposed
    public static boolean checkBottomLeft(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // If the cow feed billboard does not cover this corner, return true
        if (x3 > x1 || y3 > y1) {
            return true;
        }
        return false;
    }

    // Method to check if the top-left corner of the lawnmower billboard is exposed
    public static boolean checkTopLeft(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x3 > x1 || y4 < y2) {
            return true;
        }
        return false;
    }

    // Method to check if the bottom-right corner of the lawnmower billboard is exposed
    public static boolean checkBottomRight(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x4 < x2 || y3 > y1) {
            return true;
        }
        return false;
    }

    // Method to check if the top-right corner of the lawnmower billboard is exposed
    public static boolean checkTopRight(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x4 < x2 || y4 < y2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {  
        File inputFile = new File("billboard.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        Scanner fileScanner = new Scanner(inputFile);

        int x1 = fileScanner.nextInt();
        int y1 = fileScanner.nextInt();
        int x2 = fileScanner.nextInt();
        int y2 = fileScanner.nextInt();

        int x3 = fileScanner.nextInt();
        int y3 = fileScanner.nextInt();
        int x4 = fileScanner.nextInt();
        int y4 = fileScanner.nextInt();

        int lawnMowerArea = (x2 - x1) * (y2 - y1);
        int cornerCovered = 0;
        if (x3 <= x1 && y3 <= y1 && x4 >= x2 && y4 >= y2) {
            out.println(0); 
        } 
        else {
            if(checkBottomLeft(x1, y1, x2, y2, x3, y3, x4, y4)==false){
                cornerCovered++;
            }
            if(checkBottomRight(x1, y1, x2, y2, x3, y3, x4, y4)==false){
                cornerCovered++;
            }
            if(checkTopLeft(x1, y1, x2, y2, x3, y3, x4, y4)==false){
                cornerCovered++;
            } if(checkTopRight(x1, y1, x2, y2, x3, y3, x4, y4)==false){
                cornerCovered++;
            }

            if(cornerCovered>=2){
            int overlapWidth = Math.max(0, Math.min(x2, x4) - Math.max(x1, x3));
            int overlapHeight = Math.max(0, Math.min(y2, y4) - Math.max(y1, y3));
            int overlapArea = overlapWidth * overlapHeight;
            
            int tarpArea = lawnMowerArea - overlapArea;
            out.println(tarpArea);
            }
            else{
                out.println(lawnMowerArea);
            }
        }

        out.close();
    }
}