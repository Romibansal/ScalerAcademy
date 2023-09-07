package Advance_DP_Applications_Of_Knapsack;

//Q=Problem Description
//        Given a rod of length N units and an array A of size N denotes prices that
//        contains prices of all pieces of size 1 to N.
//
//        Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
//
//
//
//        Problem Constraints

//        1 <= N <= 1000
//
//        0 <= A[i] <= 10^6
//
//
//
//        Input Format

//        First and only argument is an integer array A of size N.
//
//
//
//        Output Format

//        Return an integer denoting the maximum value that can be obtained
//        by cutting up the rod and selling the pieces.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [3, 4, 1, 6, 2]

//        Input 2:
//
//        A = [1, 5, 2, 5, 6]
//
//
//        Example Output

//        Output 1:
//
//        15

//        Output 2:
//
//        11
//
//
//        Example Explanation

//        Explanation 1:
//
//        Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.

//        Explanation 2:
//
//        Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.

public class CuttingARod {
    public int solve(int[] A) {
        int[] B=new int[A.length+1];
        for(int i=0;i<A.length;i++){
            B[i+1]=A[i];
        }
        int[]dp=new int[B.length];
        dp[0]=0;
        for(int i=1;i<B.length;i++){
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],B[j]+dp[i-j]);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        CuttingARod I = new CuttingARod();
        int[]A=new int[5];
        A[0]=3;A[1]=4;A[2]= 1;A[3]= 6;A[4]= 2;
        System.out.println( I.solve(A));
    }
}


