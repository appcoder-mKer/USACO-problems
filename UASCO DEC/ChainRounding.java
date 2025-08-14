import java.util.*;

public class ChainRounding {
    
    private static int round(int u, int d) {
        return (u % d < d / 2) ? (u - u % d) : (u + d - u % d);
    }
    
    private static int chainRound(int u, int target) {
        for (int ten = 10; ten <= target; ten *= 10) {
            u = round(u, ten);
        }
        return u;
    }
    
    private static int alg(int N) {
        int digits = 0;
        while (Math.pow(10, digits) < N) {
            digits++;
        }
        
        int answer = 0;
        for (int curDigits = 1; curDigits <= digits; curDigits++) {
            int upper = Integer.parseInt("5" + "0".repeat(curDigits - 1)) - 1;
            upper = Math.min(N, upper);
            int lower = Integer.parseInt("4".repeat(curDigits));
            answer += Math.max(0, upper - lower);
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder results = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            results.append(alg(n)).append("\n");
        }
        
        System.out.print(results);
        scanner.close();
    }
}
