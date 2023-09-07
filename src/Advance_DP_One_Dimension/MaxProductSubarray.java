package Advance_DP_One_Dimension;

//Q=Problem Description

//        Given an integer array A of size N. Find the contiguous subarray within
//        the given array (containing at least one number) which has the largest product.
//
//        Return an integer corresponding to the maximum product possible.
//
//        NOTE: Answer will fit in 32-bit integer value.
//
//
//
//        Problem Constraints
//        1 <= N <= 5 * 10^5
//
//        -100 <= A[i] <= 100
//
//
//
//        Input Format
//        First and only argument is an integer array A.
//
//
//
//        Output Format
//        Return an integer corresponding to the maximum product possible.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [4, 2, -5, 1]

//        Input 2:
//
//        A = [-3, 0, -5, 0]
//
//
//        Example Output

//        Output 1:
//
//        8

//        Output 2:
//
//        0
//
//
//        Example Explanation

//        Explanation 1:
//
//        We can choose the subarray [4, 2] such that the maximum product is 8.

//        Explanation 2:
//
//        0 will be the maximum product possible.

public class MaxProductSubarray {
    public int maxProduct(int[] A) {
        int[] max=new int[A.length];
        int[] min=new int[A.length];
        max[0]=A[0];
        min[0]=A[0];
        for(int i=1;i<A.length;i++){
            int curr=A[i];
            int curr_max=A[i]*max[i-1];
            int curr_min=A[i]*min[i-1];
            int temp_max=Math.max(curr_min,(Math.max(curr,curr_max)));
            int temp_min=Math.min(curr_min,(Math.min(curr,curr_max)));
            max[i]=temp_max;
            min[i]=temp_min;
        }
        int ans=max[0];
        for(int i=0;i<max.length;i++){
            ans=Math.max(ans,max[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        MaxProductSubarray I = new MaxProductSubarray();
        int[] A=new int[4];
        A[0]=4;A[1]=2;A[2]=-5;A[3]=1;
        System.out.println( I.maxProduct(A));
    }
}
