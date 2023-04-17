package Subarrays;

//Q=Problem Description
//        You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
//        But the sum must not exceed B.
//
//
//        Problem Constraints
//        1 <= A <= 10^3
//        1 <= B <= 10^9
//        1 <= C[i] <= 10^6

public class MaximumSubarrayEasy {
    public int maxSubarray(int A, int B, int[] C) {
        int sum=0;
        for(int i=0;i<A;i++){
            int sum1=0;
            for(int j=i;j<A;j++){
                sum1=sum1+C[j];
                if(sum<sum1 && sum1<=B){
                    sum=sum1;
                }
            }
        }
        return sum;
    }
    public static void main(String args[]) {
        MaximumSubarrayEasy N1 = new MaximumSubarrayEasy();
        int C[] =new int [5];
        C[0]=2;C[1]=1;C[2]=3;C[3]=4;C[4]=5;
        System.out.println(N1.maxSubarray(5,12,C));
    }
}
