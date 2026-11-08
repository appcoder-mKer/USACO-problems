import java.util.*;
public class cowcheckups {

    public static int subArraysCount(int numCows){
        return (numCows * (numCows + 1)) / 2;
    }

    public static HashMap<Integer, ArrayList<Integer>> functionMaker(int numCows, ArrayList<Integer> listOfCows){
        HashMap<Integer, ArrayList<Integer>> matching = new HashMap<>();
            // System.out.println(listOfCows);
        
        for (int i = 0; i < numCows; i++) {
            matching.putIfAbsent(listOfCows.get(i), new ArrayList<>());
            matching.get(listOfCows.get(i)).add(i);
        }
        // System.out.println(matching+"\n");
        return matching;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCows = scanner.nextInt();

        ArrayList<Integer> fjorder = new ArrayList<>();
        ArrayList<Integer> vetorder = new ArrayList<>();
        ArrayList<ArrayList<Integer>> combineList = new ArrayList<>();

        

        int counter = 0;

        for (int i = 0; i < numCows; i++) {
            int x = scanner.nextInt();
            fjorder.add(x);
        }

         for (int i = 0; i < numCows; i++) {
            int x = scanner.nextInt();
            vetorder.add(x);
        }
        HashMap<Integer, ArrayList<Integer>> matchesFJ = functionMaker(numCows, fjorder);
        HashMap<Integer, ArrayList<Integer>> matchesVet = functionMaker(numCows, vetorder);


        for (int i = 0; i < numCows; i++) {
            if (fjorder.get(i).equals(vetorder.get(i))) {
                int v1 = subArraysCount(i);
                int v2 = subArraysCount(numCows - i - 1);
                int v3 = Math.min(i, numCows - i - 1);
                counter += v1 + v2 + v3 + 1;
            }
        }


// System.out.println("FJ Hash: "+matchesFJ.toString());
// System.out.println("Vet Hash: "+matchesVet.toString());
// System.out.println("FJ Order: "+fjorder);
// System.out.println("Vet Order: "+ vetorder);
// System.out.println("Counter: "+ counter);


        for (int underscore = 0; underscore<2; underscore++) {
            for(int cow = 1; cow<=numCows; cow++){

                if (!matchesFJ.containsKey(cow)||!matchesVet.containsKey(cow)) {
                    continue;
                }
            for(int i : combineList){
                        // System.out.println(cow + " "+ i+" "+j);
                    int totalNum = Math.min(i, numCows-j-1) +1; 
                    counter+=totalNum;
            
                }
            }
        }
        Collections.reverse(fjorder);
        Collections.reverse(vetorder);
        // System.out.println("FJ Order R: "+fjorder);
        // System.out.println("Vet Order R: "+ vetorder);
        matchesFJ = functionMaker(numCows, fjorder);
        matchesVet = functionMaker(numCows, vetorder);
        }

// System.out.println("FJ Hash Reverse: "+matchesFJ.toString());
// System.out.println("Vet Hash Reverse: "+matchesVet.toString());



        System.out.println(counter);
    }
}
