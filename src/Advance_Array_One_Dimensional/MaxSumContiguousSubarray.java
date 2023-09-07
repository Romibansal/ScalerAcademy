package Advance_Array_One_Dimensional;


//Q=Problem Description
//        Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.
//
//
//
//        Problem Constraints
//        1 <= N <= 1e6
//        -1000 <= A[i] <= 1000

public class MaxSumContiguousSubarray {
    public int maxSubArray(final int[] A) {
        int sum=0;
        int ans=A[0];
        for(int i=0;i<A.length;i++){
            sum=sum+A[i];
            if(sum>ans){
                ans=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
    public static void main(String args []){
        MaxSumContiguousSubarray R1=new MaxSumContiguousSubarray();
        int A[] = new int[5];
        A[0]=1;A[1]= 2;A[2]= 3;A[3]= 4;A[4]= -10;
        System.out.println(R1.maxSubArray(A));
    }
}





