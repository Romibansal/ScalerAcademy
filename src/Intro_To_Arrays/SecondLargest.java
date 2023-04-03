package Intro_To_Arrays;


//Q=Problem Description
//        You are given an integer array A. You have to find the second largest element/value in
//        the array or report that no such element exists.
//
//        Problem Constraints
//        1 <= |A| <= 10^5
//        0 <= A[i] <= 10^9

public class SecondLargest {
    public int solve(int[] A) {
        int max=A[0];
        for(int i=0;i<A.length;i++){
            if(max<A[i]){
                max=A[i];
            }
        }
        int prev=0;
        int flag=0;
        for(int k=0;k<A.length;k++){
            if(A[k]<max){
                prev=A[k];
                flag=1;
            }
        }
        if(flag==0){
            return -1;
        }

        for(int j=0;j<A.length;j++){
            if( A[j]>prev && A[j]<max){
                prev=A[j];
            }
        }
        return prev;
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
