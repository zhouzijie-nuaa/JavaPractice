package Collection.sieve;

import java.util.BitSet;

/**
 * author: zijiezhou
 * Date:   2020/11/7 17:13
 * Description:
 */
public class sieve {

    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int cout = 0;
        int i ;
        for (i = 2; i <= n; i++ ) {
            b.set(i);
        }
        i = 2;
        while (i * i <= n ) {
            if (b.get(i)) {
                cout++;
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (b.get(i)) {
                cout++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(cout + "primes");
        System.out.println((end - start) + "milliseconds");
    }

}
