package Advance_DP_Two_Dimension;
//
//Q=Problem Description
//        Given a M x N grid A of integers, find a path from top left to bottom right
//        which minimizes the sum of all numbers along its path.
//
//        Return the minimum sum of the path.
//
//        NOTE: You can only move either down or right at any point in time.
//
//
//
//        Problem Constraints

//        1 <= M, N <= 2000
//
//        -1000 <= A[i][j] <= 1000
//
//
//
//        Input Format

//        First and only argument is a 2-D grid A.
//
//
//
//        Output Format

//        Return an integer denoting the minimum sum of the path.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [
//        [1, 3, 2]
//        [4, 3, 1]
//        [5, 6, 1]
//        ]

//        Input 2:
//
//        A = [
//        [1, -3, 2]
//        [2, 5, 10]
//        [5, -5, 1]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        8

//        Output 2:
//
//        -1


public class MinSumPathInMatrix {

    public int minPathSum(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int[][]dp=new int[n][m];
        dp[n-1][m-1]=A[n-1][m-1];
        for(int i=n-2;i>-1;i--){
            dp[i][m-1]=dp[i+1][m-1]+A[i][m-1];
        }
        for(int j=m-2;j>-1;j--){
            dp[n-1][j]=dp[n-1][j+1]+A[n-1][j];
        }
        for(int i=n-2;i>-1;i--){
            for(int j=m-2;j>-1;j--){
                dp[i][j]=(A[i][j]+(Math.min(dp[i+1][j],dp[i][j+1])));
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        MinSumPathInMatrix I = new MinSumPathInMatrix();
        int[][]A=new int[3][3];
        A[0][0]=1;A[0][1]=3;A[0][2]=2;

        A[1][0]=4;A[1][1]=3;A[1][2]=1;

        A[2][0]=5;A[2][1]=6;A[2][2]=1;


        System.out.println( I.minPathSum(A));
    }
}
