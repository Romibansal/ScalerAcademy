package Advance_Array_Two_Dimensional;

//Q=Problem Description
//        Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1,
//        such that the sum of all the elements in the submatrix is maximum.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^3.
//
//        1 <= B <= N
//
//        -10^2 <= A[i][j] <= 10^2.

public class MaximumSumSquareSubMatrix {
    public int solve(int[][] A, int B) {
        int N=A.length;
        int ans=-2147483648;
        long a[][]=new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                long sum=A[i][j];
                if((j-1)>-1){
                    sum=sum+a[i][j-1];
                }
                if((i-1)>-1){
                    sum=sum+a[i-1][j];
                }
                if((j-1)>-1 && (i-1)>-1){
                    sum=sum-a[i-1][j-1];
                }
                a[i][j]=sum;
            }
        }
        int sx=0;

        int ex=B-1;

        while(ex<N){
            int sy=0;
            int ey=B-1;
            while(ey<N){
                long temp=a[ex][ey];
                if((sx-1)>-1){
                    temp=temp-a[sx-1][ey];
                }
                if((sy-1)>-1){
                    temp=temp-a[ex][sy-1];
                }
                if((sy-1)>-1 && (sx-1)>-1){
                    temp=temp+a[sx-1][sy-1];
                }
                ans=Math.max(ans,(int)temp);
                ey++;
                sy++;
            }
            ex++;
            sx++;
        }
        return ans;
    }
    public static void main(String args []){
        MaximumSumSquareSubMatrix R1=new MaximumSumSquareSubMatrix();
        int A[][]=new int[5][5];
        A[0][0]=1;
        A[0][1]=1;
        A[0][2]=1;
        A[0][3]=1;
        A[0][4]=1;

        A[1][0]=2;
        A[1][1]=2;
        A[1][2]=2;
        A[1][3]=2;
        A[1][4]=2;

        A[2][0]=3;
        A[2][1]=8;
        A[2][2]=6;
        A[2][3]=7;
        A[2][4]=3;

        A[3][0]=4;
        A[3][1]=4;
        A[3][2]=4;
        A[3][3]=4;
        A[3][4]=4;

        A[4][0]=5;
        A[4][1]=5;
        A[4][2]=5;
        A[4][3]=5;
        A[4][4]=5;

        System.out.println(R1.solve(A,3));
    }
}


