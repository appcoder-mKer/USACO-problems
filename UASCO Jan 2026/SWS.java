package wormsort;
import java.io.*;
import java.util.*;

public class SWS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String rStr = br.readLine();
            int lenR = n - k + 1;
            int[] r = new int[lenR + 2]; // 1-indexed, extra cell for safe access
            for (int i = 1; i <= lenR; i++) {
                r[i] = rStr.charAt(i - 1) - '0';
            }

            long total0 = 0;
            long[] delta = new long[k];

            // Process each residue class modulo k
            for (int m = 0; m < k; m++) {
                long p = 0;          // current prefix XOR for this chain
                long ones = 0;       // number of indices with p == 1
                int cnt = 0;         // length of this chain
                int i = m + 1;       // first index in this chain
                while (i <= n) {
                    cnt++;
                    if (p == 1) ones++;
                    if (i + k <= n) {
                        int d = r[i] ^ r[i + 1];
                        p ^= d;
                    }
                    i += k;
                }
                total0 += ones;
                delta[m] = cnt - 2 * ones; // B_m - A_m
            }

            int pReq = r[1]; // required parity of the first bits

            // DP to find min and max sum of deltas for subsets with given parity
            long evenMin = 0, oddMin = Long.MAX_VALUE / 2;
            long evenMax = 0, oddMax = Long.MIN_VALUE / 2;
            for (int m = 0; m < k; m++) {
                long d = delta[m];
                long newEvenMin = Math.min(evenMin, oddMin + d);
                long newOddMin = Math.min(oddMin, evenMin + d);
                long newEvenMax = Math.max(evenMax, oddMax + d);
                long newOddMax = Math.max(oddMax, evenMax + d);
                evenMin = newEvenMin;
                oddMin = newOddMin;
                evenMax = newEvenMax;
                oddMax = newOddMax;
            }

            long minOnes, maxOnes;
            if (pReq == 0) {
                minOnes = total0 + evenMin;
                maxOnes = total0 + evenMax;
            } else {
                minOnes = total0 + oddMin;
                maxOnes = total0 + oddMax;
            }

            System.out.println(minOnes + " " + maxOnes);
        }
    }
}