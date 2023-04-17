package Subarrays;

//Q=Problem Description
//        Given an array A of length N, return the subarray from B to C.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9
//        0 <= B <= C < N

public class SubarrayInGivenRange {
    public int[] solve(int[] A, int B, int C) {
        int n=C-B+1;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=A[B+i];
        }
        return a;
    }
    public static void main(String args[]) {
        SubarrayInGivenRange N1 = new SubarrayInGivenRange();
        int A[] =new int [4];
        A[0]=4;A[1]=3;A[2]=2;A[3]=6;
        System.out.println(N1.solve(A,1,3));
    }
}



