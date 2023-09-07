package Advance_DP_Two_Dimension;
//
//Q=Problem Description
//        Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
//        At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
//
//        Now consider if some obstacles are added to the grids.
//        Return the total number unique paths from (1, 1) to (n, m).
//
//        Note: An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
//
//
//        Problem Constraints

//        1 <= n, m <= 100

//        A[i][j] = 0 or 1
//
//
//        Input Format

//        Firts and only argument A is a 2D array of size n * m.
//
//
//        Output Format

//        Return an integer denoting the number of unique paths from (1, 1) to (n, m).
//
//
//        Example Input

//        Input 1:
//
//        A = [
//        [0, 0, 0]
//        [0, 1, 0]
//        [0, 0, 0]
//        ]

//        Input 2:
//
//        A = [
//        [0, 0, 0]
//        [1, 1, 1]
//        [0, 0, 0]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        2

//        Output 2:
//
//        0


public class UniquePathsInAGrid {
    int ways(int[][] A,int[][] dp,int i,int j){

        if(i==0 && j==0){
            return 1;
        }

        if(i<0 || j<0) {
            return 0;
        }

        if(A[i][j]==1){
            dp[i][j]=0;
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=ways(A,dp,i-1,j)+ways(A,dp,i,j-1);
        dp[i][j]=ans;
        return ans;
    }
    public int uniquePathsWithObstacles(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        if(A.length==1){
            for(int i=0;i<A[0].length;i++){
                if(A[0][i]==1){
                    return 0;
                }
            }
            return 1;
        }

        if(A[0].length==1){
            for(int i=0;i<A.length;i++){
                if(A[i][0]==1){
                    return 0;
                }
            }
            return 1;
        }

        if(A[0][0]==1) return 0;
        if(A[n-1][m-1]==1) return 0;
        return ways(A,dp,n-2,m-1)+ways(A,dp,n-1,m-2);
    }
    public static void main(String[] args) {
        UniquePathsInAGrid I = new UniquePathsInAGrid();
        int[][]A=new int[3][3];
        A[0][0]=0;A[0][1]=0;A[0][2]=0;

        A[1][0]=0;A[1][1]=1;A[1][2]=0;

        A[2][0]=0;A[2][1]=0;A[2][2]=0;


        System.out.println( I.uniquePathsWithObstacles(A));
    }
}
