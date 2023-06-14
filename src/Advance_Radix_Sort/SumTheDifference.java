package Advance_Radix_Sort;

import java.util.Arrays;


//Q=Problem Description
//        Given an integer array, A of size N.
//        You have to find all possible non-empty subsequences of the array of numbers and then,
//        for each subsequence, find the difference between the largest and smallest number in that subsequence.
//        Then add up all the differences to get the number.
//
//        As the number may be large, output the number modulo 1e9 + 7 (1000000007).
//
//        NOTE: Subsequence can be non-contiguous.
//
//
//
//        Problem Constraints
//        1 <= N <= 10000
//
//        1<= A[i] <=1000


public class SumTheDifference {
    public long pow(long x, int y, int k) {
        if(y==0){
            return 1;
        }
        long l=pow(x,y/2,k);
        long r=((l%k)*(l%k))%k;
        if(y%2==0){
            return r;
        }
        else{
            r=((r%k)*x)%k;
            return r;
        }
    }
    public int solve(int[] A) {
        int mod=(int)Math.pow(10,9)+7;
        Arrays.sort(A);
        long sum=0;
        for(int i=0;i<A.length;i++){
            long max=(pow(2,i,mod))%mod;
            long min=pow(2,A.length-1-i,mod)%mod;
            long diff=  ((max)-(min));
            long mul=(A[i]*(diff)%mod)%mod;
            sum=(sum%mod+mul%mod)%mod;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        SumTheDifference I = new SumTheDifference();
        int A[]=new int[3];
        A[0]=5;A[1]=4;A[2]=2;
        System.out.println(I.solve(A));
    }
}
