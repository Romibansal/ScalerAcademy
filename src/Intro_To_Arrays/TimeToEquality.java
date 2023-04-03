package Intro_To_Arrays;

//Q=Problem Description
//        Given an integer array A of size N. In one second, you can increase the value of one element by 1.
//        Find the minimum time in seconds to make all elements of the array equal.
//
//        Problem Constraints
//        1 <= N <= 1000000
//        1 <= A[i] <= 1000



public class TimeToEquality {
    public int solve(int[] A) {
        int max=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
        }
        int sum=0;
        int count=0;
        for(int j=0;j<A.length;j++){
            if(A[j]==max){
                count++;
                continue;
            }
            else{
                sum=sum+A[j];

            }
        }
        return ((A.length-count)*max)-sum;
    }
    public static void main(String args []){
        MaxMinOfAnArray N1=new MaxMinOfAnArray();
        int[] A=new int[4];
        A[0]=2;A[3]=3;
        A[1]=4;A[4]=2;
        A[2]=1;
        System.out.println( N1.solve(A));
    }
}
