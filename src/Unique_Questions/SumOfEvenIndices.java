package Unique_Questions;

//Q=Problem Description
//        You are given an array A of length N and Q queries given by the 2D array B of size Q*2.
//        Each query consists of two integers B[i][0] and B[i][1].
//        For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].
//
//        Note : Use 0-based indexing
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= Q <= 10^5
//        1 <= A[i] <= 100
//        0 <= B[i][0] <= B[i][1] < N

public class SumOfEvenIndices {
    public int[] solve(int[] A, int[][] B) {
        int [] a=new int [B.length];

        for(int i=1;i<A.length;i++){
            if(i%2==0){
                A[i]=A[i-1]+A[i];
            }
            else{
                A[i]=A[i-1];
            }
        }
        for(int j=0;j<B.length;j++){
            int l=B[j][0];
            int r=B[j][1];
            if(l==0){
                a[j]=A[r];
            }
            else{
                a[j]=A[r]-A[l-1];
            }
        }
        return a;
    }
    public static void main(String args []){
        SumOfEvenIndices N1=new SumOfEvenIndices();
        int []A=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=4;A[4]=5;
        int [][]B=new int[2][2];
        B[0][0]=0;
        B[0][1]=2;
        B[1][0]=1;
        B[1][1]=4;
        System.out.println( N1.solve(A,B));
    }
}



