package Arrays_2D_Matrices;

//Q=Problem Description
//
//        You are given a matrix A, you have to return another matrix which is the transpose of A.
//
//        NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row.
//        The tranpose of a matrix switches the element at (i, j)th index to (j, i)th index, and the element at (j, i)th
//        index to (i, j)th index.
//
//        Problem Constraints
//        1 <= A.size() <= 1000
//        1 <= A[i].size() <= 1000
//        1 <= A[i][j] <= 1000

public class MatrixTranspose {
    public int[][] solve(int[][] A) {
        int row=A.length;
        int col=A[0].length;
        int [][] B=new int[col][row];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                B[j][i]=A[i][j];
            }
        }
        return B;
    }
    public static void main(String args []){
        MatrixTranspose R1=new MatrixTranspose();
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
        System.out.println(R1.solve(A));
    }
}




