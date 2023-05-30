package MatrixMultiplication;

import static com.google.common.primitives.Ints.max;
import static com.google.common.primitives.Ints.min;

public class RingSortedArray {

    /**
     * define ring sorted concept for  3 matrices dimension array
     * m0<=m1=<m2=<m3: ABC=(m0,m1,m2,m3) increasing - sorted;
     * (m0,m1,m2,m3), (m3,m0,m1,m2), (m2,m3,m0,m1), (m1,m2,m3,m0) are increasing ring sorted;
     *          m1                          m1
     *       /     \                     /     \
     *     m0       m2   clockwise;    m0       m2   counter-clockwise;
     *       \     /                     \     /
     *         m3                           m3
     * clockwise: increasing ring sorted; counter-clockwise: decreasing ring sorted;
     *
     * m0<=m1=<m2=<m3: ABC=(m3, m2, m1, m0) decreasing sorted;
     * (m3,m2,m1,m0), (m0,m3,m2,m1), (m1,m0,m3,m2), (m2,m1,m0,m3) are decreasing ring sorted;
     *         m2
     *        /   \
     *       m3   m1   counter-clockwise ?
     *        \  /
     *         m0
     */

    int[] primarySortedArray=new int[4];
    public static boolean isRingSorted(int[] array){
        boolean isRingSorted=false;
        int min=min(array);
        int max=max(array);
        int[] newArray=new int[array.length];
        // check if array is increasing ring sorted:
        /**
         * starting from the min element, check if the next element
         *  is larger than the previous one until we reach the max element
         */


        // check if array is decreasing ring sorted:
        /**
         * starting from the max element, check if the next element
         *  is smaller than the previous one until we reach the min element
         */

        return isRingSorted;
    }

}
