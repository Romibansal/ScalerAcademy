package Advance_DP_One_Dimension;

//Q=Problem Description
//        Given a 2 x N grid of integers, A, your task is to choose numbers from the
//        grid such that sum of these numbers is maximized.

//        However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
//
//        Return the maximum possible sum.
//
//        Note: You are allowed to choose more than 2 numbers from the grid.
//
//
//        Problem Constraints
//        1 <= N <= 20000
//        1 <= A[i] <= 2000
//
//
//        Input Format
//        The first and the only argument of input contains a 2d matrix, A.
//
//
//        Output Format
//        Return an integer, representing the maximum possible sum.
//
//
//        Example Input

//        Input 1:
//
//        A = [
//        [1]
//        [2]
//        ]

//        Input 2:
//
//        A = [
//        [1, 2, 3, 4]
//        [2, 3, 4, 5]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        2

//        Output 2:
//
//        8
//
//
//        Example Explanation

//        Explanation 1:
//
//        We will choose 2 (From 2nd row 1st column).

//        Explanation 2:
//
//        We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).

public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        int[] max_col=new int[A[0].length];
        for(int i=0;i<A[0].length;i++){
            max_col[i]=Math.max(A[0][i],A[1][i]);
        }
        if(max_col.length==1){
            return max_col[0];
        }

        if(max_col.length==2){
            return Math.max(max_col[0],max_col[1]);
        }
        int[] dp=new int[A[0].length];
        dp[0]=max_col[0];
        dp[1]=Math.max(max_col[0],max_col[1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],max_col[i]+dp[i-2]);
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        MaxSumWithoutAdjacentElements I = new MaxSumWithoutAdjacentElements();
        int[][]A=new int[2][10];
        A[0][0]=16;A[0][1]=5;A[0][2]=54;A[0][3]=55;A[0][4]=36;A[0][5]=82;A[0][6]=61;A[0][7]=77;A[0][8]=66;A[0][9]=61;
        A[1][0]=31;A[1][1]=30;A[1][2]=36;A[1][3]=70;A[1][4]=9;A[1][5]=37;A[1][6]=1;A[1][7]=11;A[1][8]=68;A[1][9]=14;
        System.out.println( I.adjacent(A));
    }
}