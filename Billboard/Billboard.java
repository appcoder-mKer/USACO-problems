package Billboard;
import java.util.*;
import java.io.*;

class Billboard {
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

        int x5 = fileScanner.nextInt(); 
        int y5 = fileScanner.nextInt();
        int x6 = fileScanner.nextInt();
        int y6 = fileScanner.nextInt();

        int areaOfFirstShape = (x2 - x1) * (y2 - y1);
        int areaOfSecondShape = (x4 - x3) * (y4 - y3);

        int xOverlapFirst = Math.max(0, Math.min(x2, x6) - Math.max(x1, x5));
        int yOverlapFirst = Math.max(0, Math.min(y2, y6) - Math.max(y1, y5));
        int areaOfOverlapFirst = xOverlapFirst * yOverlapFirst;

        int xOverlapSecond = Math.max(0, Math.min(x4, x6) - Math.max(x3, x5));
        int yOverlapSecond = Math.max(0, Math.min(y4, y6) - Math.max(y3, y5));
        int areaOfOverlapSecond = xOverlapSecond * yOverlapSecond;

        int visibleAreaFirst = areaOfFirstShape - areaOfOverlapFirst;
        int visibleAreaSecond = areaOfSecondShape - areaOfOverlapSecond;

        out.println(visibleAreaFirst + visibleAreaSecond);

        out.close();
    }
}
