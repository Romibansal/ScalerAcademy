package Intro_To_Arrays;



//Q=Problem Description
//        Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -10^9 <= A[i] <= 10^9



public class MaxMinOfAnArray {
    public int solve(int[] A) {
        int max=A[0];
        int min=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
        }
        return max+min;
    }
    public static void main(String args []){
        MaxMinOfAnArray N1=new MaxMinOfAnArray();
        int[] A=new int[4];
        A[0]=1;A[3]=4;
        A[1]=2;
        A[2]=3;
        System.out.println( N1.solve(A));
    }
}
