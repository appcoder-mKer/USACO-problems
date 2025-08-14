
import java.util.*;

public class mn {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int F = scanner.nextInt();
        scanner.nextLine();  
        String s = scanner.nextLine();
        
        Map<String, Integer> mooCount = new HashMap<>();
        
        findMoos(s, N, mooCount);
        
        for (int i = 0; i < N; i++) {
            char originalChar = s.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == originalChar) continue;
                String modifiedString = s.substring(0, i) + ch + s.substring(i + 1);
                findMoos(modifiedString, N, mooCount);
            }
        }
        
        List<String> resultMoos = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mooCount.entrySet()) {
            if (entry.getValue() >= F) {
                resultMoos.add(entry.getKey());
            }
        }
        
        Collections.sort(resultMoos);
        
        System.out.println(resultMoos.size());
        for (String moo : resultMoos) {
            System.out.println(moo);
        }
    }

    private static void findMoos(String s, int N, Map<String, Integer> mooCount) {
        for (int i = 0; i < N - 2; i++) {
            // Get the substring s[i], s[i+1], s[i+2]
            char c = s.charAt(i);
            char iChar = s.charAt(i + 1);
            char jChar = s.charAt(i + 2);
            
            if (iChar == jChar) {
                String moo = "" + c + iChar + jChar;
                mooCount.put(moo, mooCount.getOrDefault(moo, 0) + 1);
            }
        }
    }
}
