package wormsort;
import java.io.*;
import java.util.*;

public class lq {
    
    // Returns cow at position i in the first part at time t (0 <= i <= t/2)
    private static long getCow(long t, long i) {
        if (t == 0) return 0;
        long m = t / 2;
        
        if ((t & 1) == 1) { 
            long newI = (i + 1) % (m + 1);
            return getCow(t - 1, newI);
        } else {  
            if (i == m - 1) return m;
            if (i == m) return getCow(t - 2, 1);
            
          
            long k = (m - i - 1) / 3;
            if (k > 0) {
                return getCow(t - 2 * k, i + 2 * k);
            }
            long nextI = (i + 2) % m;
            return getCow(t - 2, nextI);
        }
    }
    
    // Returns position of cow c at time t (assuming c <= m = t/2)
    private static long position(long t, long c) {
        long s = c;
        long p = c;
        
        while (s < t) {
            if (p == 0) {
                p = (s + 1) / 2;
                s++;
            } else {
                long halfS = s / 2;
                if (p > halfS) {
                    long nextS = 2 * p;
                    if (nextS <= t) {
                        s = nextS;
                        p--;
                    } else {
                        s = t;
                    }
                } else {
                    p--;
                    s++;
                }
            }
        }
        return p;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int Q = Integer.parseInt(br.readLine());
        
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            if (type == 1) {
                // Query type 1: position of cow c at time t
                long c = a;
                long t = b;
                long m = t / 2;
                
                if (c > m) {
                     System.out.println(c);
                } else {
                     System.out.println(position(t, c));
                }
            } else {
                // Query type 2: cow at position x at time t
                long x = a;
                long t = b;
                long m = t / 2;
                
                if (x > m) {
                    System.out.println(x);
                } else {
                    System.out.println(getCow(t, x));
                }
            }
        }
        
      
    }
}