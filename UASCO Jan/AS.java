import java.util.Scanner;

public class AS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            scanner.nextLine(); 

            int[][] grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine().trim();
                for (int j = 0; j < N; j++) {
                    char c = line.charAt(j);
                    if (c == 'W') {
                        grid[i][j] = 0;
                    } else if (c == 'G') {
                        grid[i][j] = 1;
                    } else if (c == 'B') {
                        grid[i][j] = 2;
                    }
                }
            }

            int[][] stars = new int[N][N];
            boolean valid = true;

            outerLoop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 2) {
                        stars[i][j] = 1;
                        if (i < B || j < A) {
                            System.out.println(-1);
                            valid = false;
                            break outerLoop;
                        }
                        int x = i - B;
                        int y = j - A;
                        if (grid[x][y] == 0) {
                            System.out.println(-1);
                            valid = false;
                            break outerLoop;
                        }
                        stars[x][y] = 1;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {
                        if (stars[i][j] == 1) {
                            continue;
                        }
                        if (i < B || j < A) {
                            stars[i][j] = 1;
                            continue;
                        }
                        int x = i - B;
                        int y = j - A;
                        if (stars[x][y] == 1) {
                            continue;
                        }
                        stars[i][j] = 1;
                    }
                }
            }

            int sum = 0;
            for (int[] row : stars) {
                for (int val : row) {
                    sum += val;
                }
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}