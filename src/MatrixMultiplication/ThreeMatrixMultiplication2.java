package MatrixMultiplication;

/**
 *         // (ABC)==> (A[0], B[0], C[0], C[1])=(10, 30, 5, 60)==>
 *         (AB)C=(10, 30, 5)+(10, 5, 60): min num=5 (also second min=10) showed up twice
 *         // (ABC)==> (A[0], B[0], C[0], C[1])=(10, 30, 5, 60)==>
 *         A(BC)=(30, 5, 60)+(10, 30, 60): max num=60 (also second max) showed up twice
 *         // check (10, 5, 30, 60); (10, 30, 5, 60); (30, 5, 10, 60); (30, 10, 5, 60); (5, 10, 30, 60); (5, 30, 10, 60)
 */
public class ThreeMatrixMultiplication2 {
    public static void main(String[] args) {
        int[] m = {10,30,60,5}; //matricesChain; matricesIndex
        System.out.println("minNumsOfMultiplications(m) = " + minNumsOfMultiplications(m));
    }

    public static int minNumsOfMultiplications(int[] m){
        //1. (AB)C=DC
        int result1 = m[0]*m[1]*m[2]+m[0]*m[2]*m[3];
        //int result1 = m[0]*{m[1]*m[2]+m[2]*m[3]};  // m[0] is min;

        System.out.println( " Number of multiplication from (AB)C:" + result1);

        //2. A(BC)=AE
        int result2 = m[0]*m[1]*m[3]+m[1]*m[2]*m[3];
        //int result2 = {m[0]*m[1]+m[1]*m[2]}*m[3];// m[3] is max;
        System.out.println( "Number of multiplication from A(BC):" + result2);

        return Math.min(result1, result2);
    }


}
