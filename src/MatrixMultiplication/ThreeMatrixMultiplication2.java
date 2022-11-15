package MatrixMultiplication;

/**
 *         // (ABC)==> (A[0], B[0], C[0], C[1])=(10, 30, 5, 60)==>
 *         (AB)C=(10, 30, 5)+(10, 5, 60): min num=5 (also second min=10) showed up twice
 *         // (ABC)==> (A[0], B[0], C[0], C[1])=(10, 30, 5, 60)==>
 *         A(BC)=(30, 5, 60)+(10, 30, 60): max num=60 (also second max) showed up twice
 *         // check (10, 5, 30, 60); (10, 30, 5, 60); (30, 5, 10, 60); (30, 10, 5, 60); (5, 10, 30, 60); (5, 30, 10, 60)
 */

/**
 *  m1=<m2=<m3=<m4: ABC=(m1,m2,m3,m4): (AB)C or A(BC) - only two options - min or max
 */

public class ThreeMatrixMultiplication2 {
    public static void main(String[] args) {
        //int[] m = {7,3,5,4}; //matricesChain; matricesIndex
        int[] m = {30,10,5,20}; //matricesChain; matricesIndex

        //============================Ring Min case============================
        //{5,30,10,20} /\/(UDU), {30,10,20,5}\/\(DUD), {10,20,5,30}/\/(UDU), {20,5,30,10}\/\(DUD), min=2500;
        //{5,20,10,30} /\/ (UDU), {30,5,20,10} \/\(DUD),{10,30,5,20}/\/(UDU),{20,10,30,5} \/\(DUD) min =2500;

      //================================Ring Max Case================================
        //{5,20,30,10}//\(UUD),{20,30,10,5} /\\(UDD),{30,10,5,20}\\/(DDU),{10,5,20,30}//\(DUU),
        // min=5*20*30+5*30*10=3000+1500=4500, max=20*30*10+5*20*10=6000+1000=7000
        //{5,10,30,20} //\ (UUD),{10,30,20,5}/\\(UDD), {30,20,5,10} \\/(DDU), {20,5,10,30}\//(DUU), min =4500;

        // (m1,m3,m4,m2) //\ (UUD),{m3,m4,m2,m1}/\\(UDD), {m4,m2,m1,m3} \\/(DDU), {m2,m1,m3,m4}\//(DUU);
        // min=m1*m3*m4+m1*m4*m2, max=m3*m4*m2+m1*m3*m2: max>=min? depends on m1,m2,m3,m4;
        //(10,20,30,15): min=(10)*20*30+(10)*30*15=6000+4500=10500, max=20*30*15+(10)*20*15=9000+3000=12000; m4=40, 50 still min<max;
        //(10,20,60,15): min=10*20*60+10*60*15=12000+9000=21000, max=20*60*15+10*20*15=18000+3000=21000; min=max;
        //(10,20,80,15): min=(10)*20*80+(10)*80*15=16000+12000=28000, max=20*80*15+10*20*15=24000+3000=27000; min>max;
        // (m1,m2,m4,m3)//\(UUD ++-), (m2,m4,m3,m1)/\\(UDD +--), (m4,m3,m1,m2)\\/(DDU --+), (m3,m1,m2,m4)\//(DUU -++);
        // min=m1*m2*m4+m1*m4*m3, max=m2*m4*m3+m1*m2*m3: max>=min? depends on m1,m2,m3,m4;

      //=====================Ring sorted=====================
        // {5,10,20,30} ///(UUU),{10,20,30,5},{20,30,5,10},{30,5,10,20} ring sorted increasing order; min =4000.
        // {5,30,20,10}, {30,20,10,5}\\\(DDD) ,{20,10,5,30},{10,5,30,20} ring sorted decreasing order; min =4000.

        // (m1,m2,m3,m4), (m2,m3,m4,m1), (m3,m4,m1,m2), (m4,m1,m2,m3) ring sorted increasing order;
        // min =m1*m2*m3+m1*m3*m4, max=m4*m1*m2+m4*m2*m3; max-min=m1*m2(m4-m3)+m4*m3(m2-m1)>=0;
        // (m4,m3m,m2,m1), (m3,m2,m1,m4), (m2,m1,m4,m3), (m1,m4,m3,m2) ring sorted decreasing order;
        // min=m1*m2*m3+m1*m3*m4; max=m4*m1*m2+m4*m2*m3; max-min=m1*m2(m4-m3)+m4*m3(m2-m1)>=0;

        System.out.println("minNumsOfMultiplications(m) = " + minNumsOfMultiplications(m));

        /**
         * 4 element permutation: 4!=24; ring sorted starting the min element at the first position of the ring
         * : 3*2*1=6 different cases;
         * essentially only ///(\\\), //\(/\\), /\/(\/\) : 3 different cases.
         * what if 2 or 2 nums equal? {5,20,20,10} //\ (UUD),{20,20,10,5}/\\(UDD), {20,10,5,20} \\/(DDU), {10,5,20,20}\//(DUU), min =3000;
         * {5,20,20,20} /// (UUU)(not D is U), min =4000;
         */
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
