package Arrays_2D_Matrices;

//Q=Problem Description
//
//        You are given two integer matrices A and B having same size(Both having same number of rows (N) and columns (M). You have to subtract matrix B from A and return the resultant matrix. (i.e. return the matrix A - B).
//
//        If A and B are two matrices of the same order (same dimensions). Then A - B is a matrix of the same order as A and B and its elements are obtained by doing an element wise subtraction of A from B.
//
//
//        Problem Constraints
//
//        1 <= N, M <= 10^3
//
//        -109 <= A[i][j], B[i][j] <= 10^9

public class MatrixSubtraction {
    public int[][] solve(int[][] A, int[][] B) {
        int r=A.length;
        int c=A[0].length;
        int[][] a=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                a[i][j]=A[i][j]-B[i][j];
            }
        }
        return a;
    }
    public static void main(String args []){
        MatrixSubtraction R1=new MatrixSubtraction();
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
        int[][] B=new int[3][3];
        B[0][0]=1;
        B[0][1]=2;
        B[0][2]=3;
        B[1][0]=5;
        B[1][1]=6;
        B[1][2]=7;
        B[2][0]=9;
        B[2][1]=2;
        B[2][2]=3;
        System.out.println(R1.solve(A,B));
    }
}




