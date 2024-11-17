package Cownomics;
import java.util.*;  
import java.io.*;  

public class cownomics {  
    public static void main(String[] args) throws IOException {  
        File inputFile = new File("cownomics.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        Scanner fileScanner = new Scanner(inputFile);
        
        int numberOfDNA = fileScanner.nextInt();
        int lengthOfDNA = fileScanner.nextInt();
        fileScanner.nextLine();
        
        ArrayList<String> DNAS_Spotted = new ArrayList<String>();
        ArrayList<String> DNAS_Plain = new ArrayList<String>();
        
        for (int i = 0; i < numberOfDNA; i++) {
            DNAS_Spotted.add(fileScanner.nextLine());
        }
        for (int i = 0; i < numberOfDNA; i++) {
            DNAS_Plain.add(fileScanner.nextLine());
        }
        
        int distinct = 0;
        
        for (int i = 0; i < lengthOfDNA; i++) {
            ArrayList<Character> spottyChars = new ArrayList<>();
            ArrayList<Character> plainChars = new ArrayList<>();
            
            for (String genome : DNAS_Spotted) {
                char ch = genome.charAt(i);
                if (!spottyChars.contains(ch)) {
                    spottyChars.add(ch);
                }
            }
            
            for (String genome : DNAS_Plain) {
                char ch = genome.charAt(i);
                if (!plainChars.contains(ch)) {
                    plainChars.add(ch);
                }
            }
            
            boolean isDistinct = true;
            for (char ch : spottyChars) {
                if (plainChars.contains(ch)) {
                    isDistinct = false;
                    break;
                }
            }
            
            if (isDistinct) {
                distinct++;
            }
        }
        
        out.println(distinct);
        out.close();  
    }  
}
