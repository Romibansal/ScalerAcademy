package Subarrays;

//Q=Problem Description
//        Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
//        1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
//        2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
//        Your task is to find the count of good subarrays in A.
//
//
//        Problem Constraints
//        1 <= len(A) <= 10^3
//        1 <= A[i] <= 10^3
//        1 <= B <= 10^7

public class GoodSubarraysEasy {
    public int solve(int[] A, int B) {
        int count=0;
        for(int i=0;i<A.length;i++){
            int sum=0;
            int elements=0;
            for(int j=i;j<A.length;j++){
                sum=sum+A[j];
                elements++;
                if(elements%2==0 && sum<B){
                    count++;
                }
                else if(elements%2!=0 && sum>B){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String args[]) {
        GoodSubarraysEasy N1 = new GoodSubarraysEasy();
        int A[]=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=4;A[4]=5;
        System.out.println(N1.solve(A,4));
    }
}



