package bcount;
import java.util.*;  
import java.io.*;  
public class bcount {  
    public static void main(String[] args) throws IOException{  
        File inputFile = new File("bcount.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        Scanner fileScanner = new Scanner(inputFile);

        int numberOfCows = fileScanner.nextInt();
        int numberOfQueries = fileScanner.nextInt();

        int[] orginal = new int [numberOfCows];
        int[] breedone = new int [numberOfCows+1];
        int[] breedtwo = new int [numberOfCows+1];
        int[] breedthree = new int [numberOfCows+1];


        for(int i = 0; i<numberOfCows; i++){
            int x = fileScanner.nextInt();
            breedone[i+1] = breedone[i];
            breedtwo[i+1] = breedtwo[i];
            breedthree[i+1] = breedthree[i];

            if (x==1){
                breedone[i+1] ++;
            }
            if (x==2){
                breedtwo[i+1] ++;
            }
            if (x==3){
                breedthree[i+1] ++;
            }
        }
        fileScanner.nextLine();
        for(int i = 0; i<numberOfQueries;i++){

        String queryLine = fileScanner.nextLine();
        String[] strArray = queryLine.split(" ");
        System.out.println(queryLine);
        int smallNumber = Integer.parseInt(strArray[0]);
        int bigNumber = Integer.parseInt(strArray[1]);


        
        int BiggeseNumberBreedOne = breedone[bigNumber];
        int SmallestNumberBreedOne = breedone[smallNumber-1];
        int breedOneNumber = BiggeseNumberBreedOne-SmallestNumberBreedOne;

        int BiggeseNumberBreedTwo = breedtwo[bigNumber];
        int SmallestNumberBreedTwo = breedtwo[smallNumber-1];
        int breedTwoNumber = BiggeseNumberBreedTwo-SmallestNumberBreedTwo;

        int BiggeseNumberBreedThree = breedthree[bigNumber];
        int SmallestNumberBreedThree = breedthree[smallNumber-1];
        int breedThreeeNumber = BiggeseNumberBreedThree-SmallestNumberBreedThree;


        out.println(breedOneNumber+" "+breedTwoNumber+" "+breedThreeeNumber);
        }

System.out.println(Arrays.toString(breedone));
System.out.println(Arrays.toString(breedtwo));
System.out.println(Arrays.toString(breedthree));

        

            out.close();  
        }  
}  