package RecursivePractice;

public class MultinomialBare {
    static long[][] table ;

    public static void main(String[] args) {
        int n = 20;
        int k = 20;
        table = new long[n+1][k+1];

        System.out.println("============= Multinomial Memoization: ============");
        System.out.println("multinomialFast(n, k) = " + multinomialFast(n, k));

        System.out.println("============= Multinomial Regular: ============");
        System.out.println("multinomial(n, k) = " + multinomial(n, k));

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
            //calculate only if not calculated yet:
            if (table[n][k] <= 1) {
                table[n][k] = multinomialFast2(n, k - 1) + multinomialFast2(n - 1, k);
            }
            return table[n][k];
    }


}
