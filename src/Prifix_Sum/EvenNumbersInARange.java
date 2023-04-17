package Prifix_Sum;

//Q=Problem Description
//        You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
//
//        Each query consists of two integers B[i][0] and B[i][1].
//
//        For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= Q <= 10^5
//        1 <= A[i] <= 10^9
//        0 <= B[i][0] <= B[i][1] < N
//
//
//Input Format
//        First argument A is an array of integers.
//        Second argument B is a 2D array of integers.
//
//
//        Output Format
//        Return an array of integers.


public class EvenNumbersInARange {
    public int[] solve(int[] A, int[][] B) {
        int[] C = new int[B.length];
        if(A[0]%2==0){
            A[0]=1;
        }
        else{
            A[0]=0;
        }
        for(int i=1;i<A.length;i++){
            if(A[i]%2==0){
                A[i]=A[i-1]+1;
            }
            else{
                A[i]=A[i-1];
            }
        }
        for(int i=0;i<B.length;i++){
            int L=B[i][0];
            int R=B[i][1];
            if(L==0){
                C[i]=A[R];
            }
            else{
                C[i]=A[R]-A[L-1];
            }
        }
        return C;
    }
    public static void main(String[] args) {
        EvenNumbersInARange I = new EvenNumbersInARange();
        int[] A=new int[6];
        A[0]=2 ;
        A[1]=1;
        A[2]=8;
        A[3]=3;
        A[4]=9;
        A[5]=6;
        int [][]B=new int[4][2] ;
        B[0][0]=0;B[0][1]=3; B[1][0]=3;B[1][1]=5; B[2][0]=1;B[2][1]=3; B[3][0]=2;B[3][1]=4;
        System.out.println( I.solve(A,B));
    }
}




