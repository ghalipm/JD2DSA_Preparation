package MatrixMultiplication;

/**
 *         // (ABC): DO NOT CHANGE ANYTHING IN THIS CLASS:
 *         NOT EVEN THE INPUT OR THE ORDER OF THE INPUT !!!
 *         THEY ARE NOT RANDOMLY GENERATED !!!
 *
 *
 */

/**
 *  m1=<m2=<m3=<m4: ABC=(m1,m2,m3,m4): (AB)C or A(BC) - only two options - min or max
 *
 *  if m4 is not critically larger than m1, then m1 always provides the minMult;
 */

public class ThreeMatrixMultiplication2 {
    public static void main(String[] args) {

         int max=15; int[] m = {5,10,max,6};//14, 15, 16; cause flip-flop  between min and max.
        //int max=9, min=5; int[] m = {min,7,max,6}; //max=9,10; cause flip-flop between min and max.

        // check if max<2*m1, then m1 always provides the minMult;

        //============================/\/: N  or Harmonic Wave (+-+/-+-) Case -- minVal==>minMult ============================
        //{m1,m4,m2,m3}/\/(+-+),{m4,m2,m3,m1}\/\(-+-), {m2,m3,m1,m4}/\/, {m3,m1,m4,m2}\/\;
        // min=(m1)*m4*m2+(m1)*m2*m3, max=m4*m2*m3+m1*m4*m3, max-min=m4*m2(m3-m1)+m1*m3(m4-m2)>=0;
        //{m1,m3,m2,m4} /\/(+-+), {m3,m2,m4,m1} \/\, {m2,m4,m1,m3}/\/, {m4,m1,m3,m2}\/\;
        // min=(m1)*m3*m2+(m1)*m2*m4, max=m3*m2*m4+m1*m3*m4, max-min=m3*m2(m4-m1)+m1*m4(m3-m2)>=0;

      //================================\\/(//\): Hockey Stick Case -- Uncertain ================================
        // (m1,m3,m4,m2) //\ (++-),{m3,m4,m2,m1}, {m4,m2,m1,m3}, {m2,m1,m3,m4}\//(-++);
        // op1=m1*m3*m4+m1*m4*m2, op2=m3*m4*m2+m1*m3*m2: op2>=op1? depends on m1,m2,m3,m4;
        // (m1,m2,m4,m3)//\, (m2,m4,m3,m1), (m4,m3,m1,m2), (m3,m1,m2,m4)\// (-++);
        // op1=m1*m2*m4+m1*m4*m3, op2=m2*m4*m3+m1*m2*m3: op2>=op1? depends on m1,m2,m3,m4;
        ////: Only in this case , need to calculate 4 multiplications to find the min and max.

      //=====================///(\\\): Spear or Monotone case - Ring sorted -- minVal==>minMult =====================
        // (m1,m2,m3,m4)///, (m2,m3,m4,m1), (m3,m4,m1,m2), (m4,m1,m2,m3) ring sorted increasing order;
        // min =m1*m2*m3+m1*m3*m4, max=m4*m1*m2+m4*m2*m3; max-min=m1*m2(m4-m3)+m4*m3(m2-m1)>=0;
        // (m4,m3m,m2,m1)\\\, (m3,m2,m1,m4), (m2,m1,m4,m3), (m1,m4,m3,m2) ring sorted decreasing order;
        // min=m1*m2*m3+m1*m3*m4; max=m4*m1*m2+m4*m2*m3; max-min=m1*m2(m4-m3)+m4*m3(m2-m1)>=0;

        System.out.println("minNumsOfMultiplications(m) = " + minNumsOfMultiplications(m));

        /**
         * 4 element permutation: 4!=24; ring sorted starting the min element at the first position of the ring
         * : 3*2*1=6 different cases;
         * essentially only ///(\\\), //\(/\\), /\/(\/\) : 3 types of gradients.
         * "2 out 3 cases, min value provides the min number of multiplications." : 2/3=0.6666666666666666;
         * So 2 out of 3 cases, need to calculate only 2 multiplications out
         * of 4 multiplications associated with 3 matrices.
         * Thus at least (2/3)*(2/4)=1/3 improvement in the number of multiplications for 3 matrices.
         * what if 2 or 3 nums equal? NP. If all equal, then 1 case, nothing to optimize
         */

        //if m4 is not critically larger than m1, then m1 always provide the minMult

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
