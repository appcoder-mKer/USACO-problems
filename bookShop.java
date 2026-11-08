import java.io.*;
import java.util.*;

public class bookShop{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] price = new int[n];
        int[] pages = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[x + 1];

        for (int i = 0; i < n; i++) {
            for (int j = x; j >= price[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - price[i]] + pages[i]);
            }
        }

        System.out.println(dp[x]);
    }
}