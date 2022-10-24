package MatrixMultiplication;

public class ThreeMatrixMultiplication {
    public static void main(String[] args) {
        int A_row=10; int A_col=30;
        int B_row=30; int B_col=5;
        int C_row=5; int C_col=60;
        int[] A = {A_row, A_col};
        int[] B = {B_row, B_col};
        int[] C = {C_row, C_col};

        System.out.println("numOfMultiplications(A, B) = " + numOfMultiplications(A, B));

        System.out.println("minMultiplyingNumsOfThreeMatrices(A, B, C) = " + minMultiplyingNumsOfThreeMatrices(A, B, C));
    }


    public static int numOfMultiplications(int[] A, int[] B) {
        int result = 0;
            if (A[1] == B[0]) {
                result= (A[0]) * (B[0]) * (B[1]);
                return result;
            }
        else {
                System.out.println( "Invalid input: " +A[1] + "!="+ B[0]);
                System.out.println("Matrices are cannot be multiplied!" );
            return -1;}
    }


    public static int minMultiplyingNumsOfThreeMatrices(int[] A, int[] B, int[] C){
        //1. (AB)C=DC
        int D_row=A[0]; int D_col=B[1];
        int[] D = {D_row, D_col};
        int result1 = numOfMultiplications(A, B) + numOfMultiplications(D, C);
        System.out.println( " Number of multiplication from (AB)C:" + result1);

        //2. A(BC)=AE
        int E_row=B[0]; int E_col=C[1];
        int[] E = {E_row, E_col};
        int result2 = numOfMultiplications(A, E) + numOfMultiplications(B, C);
        System.out.println( " Number of multiplication from A(BC):" + result2);


        return Math.min(result1, result2);
    }


}
