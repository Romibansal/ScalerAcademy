package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
//
//        Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).

//        Problem Constraints
//        1 <= N <= 10^3
//        -1000 <= A[i][j] <= 1000

public class MinorDiagonalSum {
    public int solve(final int[][] A) {
        int n=A.length+1;
        int sum=0;
        for(int i=1;i<n;i++){
            sum=sum+A[i-1][n-i-1];
        }
        return sum;
    }
    public static void main(String args []){
        MinorDiagonalSum R1=new MinorDiagonalSum();
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




