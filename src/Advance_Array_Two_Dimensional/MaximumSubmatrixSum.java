package Advance_Array_Two_Dimensional;

//Q=Problem Description
//        Given a row-wise and column-wise sorted matrix A of size N * M.
//        Return the maximum non-empty submatrix sum of this matrix.
//
//
//        Problem Constraints
//        1 <= N, M <= 1000
//        -10^9 <= A[i][j] <= 10^9

public class MaximumSubmatrixSum {
    public long solve(int[][] A) {
        long ans= Long.MIN_VALUE;
        int N=A.length;
        int M=A[0].length;
        long a[][]=new long[N][M];
        for(int i=N-1;i>-1;i--){
            for(int j=M-1;j>-1;j--){
                long sum=A[i][j];
                if((j+1)<M){
                    sum=sum+a[i][j+1];
                }
                if((i+1)<N){
                    sum=sum+a[i+1][j];
                }
                if((i+1)<N && (j+1)<M){
                    sum=sum-a[i+1][j+1];
                }
                if(sum>ans){
                    ans=sum;
                }
                a[i][j]=sum;
            }
        }
        return ans;
    }
    public static void main(String args []){
        MaximumSubmatrixSum R1=new MaximumSubmatrixSum();
        int A[][]=new int[3][3];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=4;
        A[1][1]=5;
        A[1][2]=6;
        A[2][0]=7;
        A[2][1]=8;
        A[2][2]=9;
        System.out.println(R1.solve(A));
    }
}




