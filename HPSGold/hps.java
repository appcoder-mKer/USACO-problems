package HPSGold;
import java.util.*;  
import java.io.*;  
public class hps {  
    
    public static boolean helperWins(Character playerOne, Character playerTwo){
        boolean var = false; 
        if(playerOne == 'S' )switch (playerTwo) {
            case 'P':
                var = true;
                break;

            case 'H':
                var = false;
                break;

            case 'S':
                var = false;
                break;
        }
        if(playerOne == 'P' )switch (playerTwo) {
            case 'P':
                var = false;
                break;
            case 'H':
                var = true;
                break;

            case 'S':
                var = false;
                break; 
        }
        if(playerOne == 'H' )switch (playerTwo) {
            case 'P':
                var = false;
                break;

            case 'H':
                var = false;
                break;

            case 'S':
                var = true;
                break;
        }
        return var;
    }


    public static char[] switchMoves(Character currentMove){
        if(currentMove == 'P'){
            return new char[]{'S', 'H'};
        }
         if(currentMove == 'S'){
            return new char[]{'P', 'H'};
        }
         if(currentMove == 'H'){
            return new char[]{'S', 'P'};
        }
        return new char[]{' '};
    }


    public static int games(int currentGame, Character currentMove, int switchesLeft, int gamesWon, ArrayList<Character> FJmove, ArrayList<Character> Bessiemove){

        if(currentGame == FJmove.size()){
            // System.out.println(Bessiemove);
            // System.out.println(gamesWon);

            return gamesWon;

        }
        
        // System.out.println(currentMove);

            ArrayList<Character> dupeBessieMove = new ArrayList<>(Bessiemove);
            dupeBessieMove.add(currentMove);
            int x =  games(currentGame+1, currentMove, switchesLeft, (helperWins(currentMove, FJmove.get(currentGame))? gamesWon+1:gamesWon), FJmove, dupeBessieMove);
        //    System.out.println("HELPER WINS: " + (helperWins(currentMove, FJmove.get(currentGame))? 1:0+gamesWon));
        int y = 0; 
        if(switchesLeft>0){
            
           int t =  games(currentGame+1, switchMoves(currentMove)[0], switchesLeft-1, (helperWins(currentMove, FJmove.get(currentGame))? gamesWon+1:gamesWon), FJmove,dupeBessieMove);
           int z =  games(currentGame+1, switchMoves(currentMove)[1], switchesLeft-1, (helperWins(currentMove, FJmove.get(currentGame))? gamesWon+1:gamesWon), FJmove, dupeBessieMove);
            y = Math.max(t, z);
        }
        // System.out.println(currentMove);
        


        return Math.max(x, y);
    }




    
    public static void main(String[] args) throws IOException{  
         BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
                StringTokenizer st = new StringTokenizer(br.readLine());

        // Scanner scanner = new Scanner(br);

        int games = Integer.parseInt(st.nextToken());
        int movesLeft = Integer.parseInt(st.nextToken());
        ArrayList<Character> FJmove = new ArrayList<Character>();
        //br.readLine();
        for(int i = 0; i<games;i++){
            //System.out.println(br.readLine());
            FJmove.add(br.readLine().charAt(0));
        }


        char[] moves = {'P','S','H'};
        int max = 0; 
        for(char i:moves){
            max = Math.max(games(0, i, movesLeft, 0, FJmove, new ArrayList<>()), max);
        }
        br.close();
        out.println(max);
        out.close();
        // System.out.println(max);
        
        // for(char i:moves){
        //     for(char j:moves){
        //             System.out.println(helperWins(i, j));
        //             System.out.println("I: "+ i + " J: "+ j);

        //     }
                

        // }



        }  
}  