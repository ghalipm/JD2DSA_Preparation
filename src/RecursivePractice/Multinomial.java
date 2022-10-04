package RecursivePractice;

public class Multinomial {
    static long[][] table ;

    public static void main(String[] args) {
        int n = 20;
        int k = 20;
        table = new long[n+1][k+1];
        long ratio=0;
//        System.out.println("============= Multinomial Memoization: ============");
//        startWatch(n,k,multinomialFast2(n,k));

        System.out.println("============= Multinomial Memoization: ============");
        long durationF=0;
        //starting time:
        long startTimeF = System.currentTimeMillis();
        long numTerms = multinomialFast(n, k);
        System.out.println("terms=" + n + ", degree=" + k + ": number of terms = " + numTerms);
        //ending time:
        long endTimeF= System.currentTimeMillis();
        durationF = endTimeF - startTimeF;
        System.out.println("Time elapsed: " + durationF + "ms");

        System.out.println("============= Multinomial Regular: ============");
        //startWatch(n,k,multinomial(n,k));
        long durationR=0;
        //starting time:
        long startTimeR = System.currentTimeMillis();
        long numTermsR = multinomial(n, k);
        System.out.println("terms=" + n + ", degree=" + k + ": number of terms = " + numTermsR);
        //ending time:
        long endTimeR= System.currentTimeMillis();
        durationR = endTimeR - startTimeR;
        System.out.println("Time elapsed: " + durationR + "ms");


        ratio=durationR/durationF;
        System.out.println("ratio of regular to fast = " + ratio);

    }

    // n terms k degree: n>=1, k>=0; (a_1+a_2+...+a_n)^k :
    public static long multinomial(int n, int k) {

        if(n==0) return 0; // better to leave out: to avoid zero degree of zero case.
        if (k == 0 || n == 1) {
            return 1;
        }
        return  multinomial(n , k - 1)+ multinomial(n-1 , k);

    }

    public static long multinomialFast(int n, int k) {
        if(n==0) return 0;
        if (k == 0 || n == 1) {
            return 1;
        }

        // if calculated, return it:
        if(table[n][k]>1) return table[n][k];
        else {
            table[n][k] = multinomialFast(n , k - 1)+ multinomialFast(n-1 , k);
            return table[n][k];
        }

    }


    public static long multinomialFast2(int n, int k) {
        if(n==0) return 0;
        if (k == 0 || n == 1) {
            return 1;
        }

        // if not calculated, return it:
        if(table[n][k]<=1) {
            table[n][k] = multinomialFast2(n, k - 1) + multinomialFast2(n - 1, k);
        }
            return table[n][k];

    }

    public static long startWatch(int terms, int degree, long function) {
        long durationR=0;
        //starting time:
        long startTimeR = System.nanoTime();
        long numTerms = function;
                System.out.println("terms=" + terms + ", degree=" + degree + ": " + numTerms);
        //ending time:
        long endTimeR= System.nanoTime();
        durationR = endTimeR - startTimeR;
        System.out.println("Time elapsed: " + durationR + "ns");
        return durationR;
    }

}
