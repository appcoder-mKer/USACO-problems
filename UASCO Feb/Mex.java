import java.util.Scanner;

public class Mex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] freq = new int[N + 2]; 

        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            if (a <= N) {
                freq[a]++;
            }
        }

        boolean[] present = new boolean[N + 2];
        for (int x = 0; x <= N; x++) {
            present[x] = (freq[x] > 0);
        }

        int[] missing = new int[N + 2];
        missing[0] = 0;
        for (int i = 1; i <= N + 1; i++) {
            missing[i] = missing[i - 1] + (present[i - 1] ? 0 : 1);
        }

        for (int i = 0; i <= N; i++) {
            int m = missing[i];
            int f = freq[i];
            System.out.println(Math.max(m, f));
        }

        scanner.close();
    }
}