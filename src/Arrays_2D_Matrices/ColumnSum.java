package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
//
//        Problem Constraints
//        1 <= A.size() <= 10^3
//
//        1 <= A[i].size() <= 10^3
//
//        1 <= A[i][j] <= 10^3

public class ColumnSum {
    public int[] solve(int[][] A) {
        int n=A[0].length;
        // System.out.print(n);
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<A.length;j++){
                sum=sum+A[j][i];
            }
            a[i]=sum;
        }
        return a;
    }
    public static void main(String args []){
        ColumnSum R1=new ColumnSum();
        int[][] A=new int[3][4];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[0][3]=4;
        A[1][0]=5;
        A[1][1]=6;
        A[1][2]=7;
        A[1][3]=8;
        A[2][0]=9;
        A[2][1]=2;
        A[2][2]=3;
        A[2][3]=4;
        R1.solve(A);
    }
}

