package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
//
//        Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.
//
//
//        Problem Constraints
//        1 <= N <= 10^3
//
//        -1000 <= A[i][j] <= 1000

public class MainDiagonalSum {
    public int solve(final int[][] A) {
        int n=A.length;
        int sum=0;
        int i=0;
        int j=0;
        while(i<n && j<n){
            sum=sum+A[i][j];
            i++;j++;
        }
        return sum;

    }
    public static void main(String args []){
        MainDiagonalSum R1=new MainDiagonalSum();
        int[][] A=new int[3][3];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=5;
        A[1][1]=6;
        A[1][2]=7;
        A[2][0]=9;
        A[2][1]=2;
        A[2][2]=3;
        System.out.println(R1.solve(A));
    }
}



