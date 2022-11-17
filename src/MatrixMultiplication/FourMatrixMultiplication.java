package MatrixMultiplication;

/**
 *         6 Matrices: ABCDEF==>
 *                5:1 options (ABCDE)F, A(BCDEF); 4:2 options (ABCD)EF, AB(CDEF);
 *                1:4:1 A(BCDE)F; 3:3 option (ABC)DEF; 1:3:2 option A(BCD)EF;
 *                2:3:1 option AB(CDE)F; 1:2:3 option ABC(DEF); 2:1:3 option ABC(DEF);
 *
 *         5 Matrices: ABCDE==>
 *              4:1 options (ABCD)E, A(BCDE); 3:2 options (ABC)(DE), (AB)(CDE);
 *
 *         4 Matrices: ABCD==> 3:1 options (ABC)D,A(BCD); 2:2 option (AB)CD, AB(CD) ==>
 *              For (AB)(CD) there is nothing to choose:
 *              For A(BCD) and (ABC)D dynamics are only with 3 Matrices BCD and ABC ;
 *
 */

public class FourMatrixMultiplication {
    public static void main(String[] args) {

    }

}
