package Advance_DP_Two_Dimension;

//Q=Problem Description
//        Given a 2-D binary matrix A of size N x M filled with 0's and 1's,
//        find the largest rectangle containing only ones and return its area.
//
//
//
//        Problem Constraints

//        1 <= N, M <= 100
//
//
//
//        Input Format

//        The first argument is a 2-D binary array A.
//
//
//
//        Output Format

//        Return an integer denoting the area of the largest rectangle containing only ones.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [
//        [1, 1, 1]
//        [0, 1, 1]
//        [1, 0, 0]
//        ]

//        Input 2:
//
//        A = [
//        [0, 1, 0]
//        [1, 1, 1]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        4

//        Output 2:
//
//        3
//
//
//        Example Explanation

//        Explanation 1:
//
//        As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).

//        Explanation 2:
//
//        As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).

public class MaxRectangleInBinaryMatrix {
    public int maximalRectangle(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=1;j<A[0].length;j++){
                if(A[i][j]==0){
                    continue;
                }
                else{
                    A[i][j]=A[i][j]+A[i][j-1];
                }
            }
        }
        int n=A.length;
        int m=A[0].length;
        int ans=A[0][0];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int width = A[i][j];
                int height = 1;
                int area = width*height;
                ans = Math.max(area,ans);
                for(int k=i-1; k>=0; k--) {
                    width = Math.min(width,A[k][j]);
                    height++;
                    area = width*height;
                    ans = Math.max(area,ans);
                }
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        MaxRectangleInBinaryMatrix I = new MaxRectangleInBinaryMatrix();
        int[][]A=new int[3][3];
        A[0][0]=1;A[0][1]=1;A[0][2]=1;

        A[1][0]=0;A[1][1]=1;A[1][2]=1;

        A[2][0]=1;A[2][1]=0;A[2][2]=0;


        System.out.println( I.maximalRectangle(A));
    }
}


