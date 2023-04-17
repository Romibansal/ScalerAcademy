package Prifix_Sum;

//Q=Problem Description
//        You are given an integer array A of length N.
//        You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
//        For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
//        More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
//
//
//
//        Problem Constraints
//        1 <= N, M <= 10^5
//        1 <= A[i] <= 10^9
//        0 <= L <= R < N


public class RangeSumQuery {
    public long[] rangeSum(int[] A, int[][] B) {
        long[] longArray = new long[B.length];
        long[] pArray = new long[A.length];
        pArray[0]=A[0];
        for(int i=1;i<A.length;i++){
            pArray[i]=pArray[i-1]+A[i];
        }
        for(int i=0;i<B.length;i++){
            int L=B[i][0];
            int R=B[i][1];
            if(L==0){
                longArray[i]=pArray[R];
            }
            else{
                longArray[i]=pArray[R]-pArray[L-1];
            }
        }
        return longArray;
    }
    public static void main(String[] args) {
        RangeSumQuery I = new RangeSumQuery();
        int[] A=new int[5];
        A[0]=1 ;
        A[1]=2;
        A[2]=3;
        A[3]=4;
        A[4]=5;
        int [][]B=new int [2][2];
        B[0][0]=0;B[0][1]=3;
        B[1][0]=1;B[1][1]=2;
        System.out.println( I.rangeSum(A,B));
    }
}



