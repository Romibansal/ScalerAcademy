package Advance_DP_Two_Dimension;

//Q=Problem Description
//        The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon.
//        The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned
//        in the top-left room and must fight his way through the dungeon to rescue the princess.
//
//        The knight has an initial health point represented by a positive integer.
//        If at any point his health point drops to 0 or below, he dies immediately.
//
//        Some of the rooms are guarded by demons, so the knight loses health
//        (negative integers) upon entering these rooms; other rooms are either empty (0's)
//        or contain magic orbs that increase the knight's health (positive integers).
//
//        In order to reach the princess as quickly as possible, the knight decides to
//        move only rightward or downward in each step.
//
//        Given a 2D array of integers A of size M x N. Find and return the knight's
//        minimum initial health so that he is able to rescue the princess.
//
//
//
//        Problem Constraints

//        1 <= M, N <= 500
//
//        -100 <= A[i] <= 100
//
//
//
//        Input Format

//        First and only argument is a 2D integer array A denoting the grid of size M x N.
//
//
//
//        Output Format

//        Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [
//        [-2, -3, 3],
//        [-5, -10, 1],
//        [10, 30, -5]
//        ]

//        Input 2:
//
//        A = [
//        [1, -1, 0],
//        [-1, 1, -1],
//        [1, 0, -1]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        7

//        Output 2:
//
//        1

public class DungeonPrincess {
    public int calculateMinimumHP(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int[][] dp=new int[n][m];
        if(A[n-1][m-1]>=0){
            dp[n-1][m-1]=1;
        }
        else{
            dp[n-1][m-1]=(Math.abs(A[n-1][m-1]))+1;
        }
        for(int i=n-2;i>-1;i--){
            dp[i][m-1]=Math.max(1,dp[i+1][m-1]-A[i][m-1]);
        }
        for(int j=m-2;j>-1;j--){
            dp[n-1][j]=Math.max(1,(dp[n-1][j+1]-A[n-1][j]));
        }
        for(int i=n-2;i>-1;i--){
            for(int j=m-2;j>-1;j--){
                int min=(Math.min(dp[i][j+1],dp[i+1][j]));
                dp[i][j]=Math.max((min-A[i][j]),1);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        DungeonPrincess I = new DungeonPrincess();
        int[][]A=new int[3][3];
        A[0][0]=-2;A[0][1]=-3;A[0][2]=3;

        A[1][0]=-5;A[1][1]=-10;A[1][2]=1;

        A[2][0]=10;A[2][1]=30;A[2][2]=-5;



        System.out.println( I.calculateMinimumHP(A));
    }
}