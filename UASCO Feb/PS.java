
import java.util.Scanner;

public class PS {
    static int[] program;
    static int[][][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            program = new int[N];
            for (int i = 0; i < N; i++) {
                program[i] = scanner.nextInt();
            }
            memo = new int[N][N][K + 1];
            boolean result = canGenerate(0, N - 1, K);
            System.out.println(result ? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean canGenerate(int start, int end, int K) {
        if (K < 0) return false;
        if (start > end) return true;
        if (K == 0) return false;
        if (memo[start][end][K] != 0) {
            return memo[start][end][K] == 1;
        }

        boolean allSame = true;
        int first = program[start];
        for (int i = start + 1; i <= end; i++) {
            if (program[i] != first) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            memo[start][end][K] = 1;
            return true;
        }

        int length = end - start + 1;

        for (int x = (K == 3 ? 4 : 2); x <= length; x++) {
            if (length % x == 0) {
                int subLength = length / x;
                boolean valid = true;
                for (int i = 1; i < x; i++) {
                    for (int j = 0; j < subLength; j++) {
                        if (program[start + j] != program[start + i * subLength + j]) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) break;
                }
                if (valid) {
                    if (canGenerate(start, start + subLength - 1, K)) {
                        memo[start][end][K] = 1;
                        return true;
                    }
                }
            }
        }

        // Check all possible splits into prefix and suffix
        for (int split = start; split < end; split++) {
            boolean prefixSame = true;
            int prefixFirst = program[start];
            for (int i = start; i <= split; i++) {
                if (program[i] != prefixFirst) {
                    prefixSame = false;
                    break;
                }
            }
            if (prefixSame) {
                // Subtract more operations when K=3
                if (canGenerate(split + 1, end, K - (K == 3 ? 2 : 1))) {
                    memo[start][end][K] = 1;
                    return true;
                }
            }
        }

        memo[start][end][K] = -1;
        return false;
    }
}