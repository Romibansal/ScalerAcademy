package Subarrays;

//Q=Problem Description
//        Given an array A of N non-negative numbers and a non-negative number B,
//        you need to find the number of subarrays in A with a sum less than B.
//        We may assume that there is no overflow.
//
//        Problem Constraints
//        1 <= N <= 10^3
//        1 <= A[i] <= 1000
//        1 <= B <= 10^7

public class CountingSubarraysEasy {
    public int solve(int[] A, int B) {
        int count=0;
        for(int i=0;i<A.length;i++){
            int sum=0;
            for(int j=i;j<A.length;j++){
                sum=sum+A[j];
                if(sum<B){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String args[]) {
        CountingSubarraysEasy N1 = new CountingSubarraysEasy();
        int A[]=new int[3];
        A[0]=2;A[1]=5;A[2]=6;
        System.out.println(N1.solve(A,10));
    }
}




