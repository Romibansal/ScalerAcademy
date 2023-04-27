package Advanced_Array_Two_Dimensional;

//Q=Problem Description
//        Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
//
//        Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
//
//        NOTE:
//
//        Rows are numbered from top to bottom, and columns are numbered from left to right.
//        Sum may be large, so return the answer mod 10^9 + 7.
//
//
//        Problem Constraints
//        1 <= N, M <= 1000
//        -100000 <= A[i] <= 100000
//        1 <= Q <= 100000
//        1 <= B[i] <= D[i] <= N
//        1 <= C[i] <= E[i] <= M



public class SubMatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        long a[][]=new long[A.length][A[0].length];
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                long sum=A[i][j];
                if((i-1)>=0){
                    sum=(sum+a[i-1][j]);
                }
                if((j-1)>=0){
                    sum=(sum+(a[i][j-1]));
                }
                if((i-1)>=0 && (j-1)>=0){
                    sum=sum-a[i-1][j-1];
                }
                a[i][j]=sum;
            }
        }
        int ans[]=new int [B.length];
        for(int i=0;i<B.length;i++){
            int sx=B[i]-1;
            int sy=C[i]-1;
            int ex=D[i]-1;
            int ey=E[i]-1;
            long sum=a[ex][ey];
            if((sx-1)>=0){
                sum=sum-a[sx-1][ey];
            }
            if((sy-1>=0)){
                sum=sum-a[ex][sy-1];
            }
            if((sx-1)>=0 && (sy-1>=0) ){
                sum=((sum)%mod+a[sx-1][sy-1]%mod)%mod;
            }
            while(sum<0){
                sum=sum+mod;
            }
            ans[i]=(int)(sum+mod)%mod;
        }
        return ans;
    }
    public static void main(String args []){
        SubMatrixSumQueries R1=new SubMatrixSumQueries();
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
        int B[]=new int[2];
        B[0]=1;B[1]=2;
        int C[]=new int[2];
        C[0]=1;C[1]=2;
        int D[]=new int[2];
        D[0]=2;D[1]=3;
        int E[]=new int[2];
        E[0]=2;E[1]=3;
        System.out.println(R1.solve(A,B,C,D,E));
    }
}
