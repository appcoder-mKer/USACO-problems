package LM;
import java.util.*;
import java.io.*;

public class LM {
    
    public static String evaluate(List<String> tokens) {
        ArrayList<String> stack = new ArrayList<>();
        
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("and")) {
                String left = stack.remove(stack.size() - 1);
                String right = tokens.get(++i);
                stack.add(left.equals("true") && right.equals("true") ? "true" : "false");
            } else {
                stack.add(tokens.get(i));
            }
        }
        
        boolean result = stack.get(0).equals("true");
        for (int i = 1; i < stack.size(); i += 2) {
            result |= stack.get(i + 1).equals("true");
        }
        
        return result ? "true" : "false";
    }
    
    public static void processQueries(int n, int q, ArrayList<String> statement, List<int[]> queries) {
        StringBuilder results = new StringBuilder();
        
        for (int[] query : queries) {
            ArrayList<String> modified = new ArrayList<>(statement);
            modified.subList(query[0] - 1, query[1]).clear();
            modified.add(query[0] - 1, query[2] == 1 ? "true" : "false");
            
            results.append(evaluate(modified).equals(query[2] == 1 ? "true" : "false") ? "Y" : "N");
        }
        
        System.out.println(results);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        ArrayList<String> statement = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
        List<int[]> queries = new ArrayList<>();
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            String desired = st.nextToken();
            queries.add(new int[]{l, r, desired.equals("true") ? 1 : 0});
        }
        
        processQueries(n, q, statement, queries);
    }
}


/*
1. true & true = true 
2. false & true = false
3. true & false = false
4. false & false = false
5. true or true = true
6. false or true = true
7. true or false = true
8. false or false = false
 */







/* 1. Number each keyword 
2. Have operator statements to call 
3. Go through a for loop for the bulk
4. In that for loop you have to remove the keyword and replace it with all the possible options
5. Go through each one to see if it makes the statement true or false
6. To handle the expcetion of and/or statemnts, have an if statments that searches for ands, and if they are present go inside the if, otherwise go to the else with does the or
7. Have a string where it adds to says if it is a proper query 

*/