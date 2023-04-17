package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.
//
//
//
//        Problem Constraints
//
//        1 <= A.size() <= 1000
//
//        1 <= A[i].size() <= 1000
//
//        1 <= A[i][j] <= 1000
//
//        1 <= B <= 1000

public class MatrixScalarProduct {
    public int[][] solve(int[][] A, int B) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                A[i][j]=B*(A[i][j]);
            }
        }
        return A;
    }
    public static void main(String args []){
        MatrixScalarProduct R1=new MatrixScalarProduct();
        int[][] A=new int[3][3];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=5;
        A[1][1]=6;
        A[1][2]=7;
        A[2][0]=9;
        A[2][1]=2;
        A[2][2]=3;
        System.out.println(R1.solve(A,3));
    }
}




