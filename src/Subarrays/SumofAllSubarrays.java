package Subarrays;

//Q=Problem Description
//        You are given an integer array A of length N.
//        You have to find the sum of all subarray sums of A.
//        More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
//        A subarray sum denotes the sum of all the elements of that subarray.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= Ai <= 10^4


public class SumofAllSubarrays {
    public long subarraySum(int[] A) {
        long sum=0;
        for(int i=0;i<A.length;i++){
            long temp=(long)(i + 1) * (A.length - i);
            sum=sum+(A[i]*temp);
        }
        return sum;
    }
    public static void main(String args[]) {
        SumofAllSubarrays N1 = new SumofAllSubarrays();
        int A[]=new int[3];
        A[0]=2;A[1]=1;A[2]=3;
        System.out.println(N1.subarraySum(A));
    }
}


