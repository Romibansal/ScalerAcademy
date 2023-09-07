package Advance_DP_Famous_Problems;

import java.util.ArrayList;

//Q=Problem Description
//        You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.
//
//        In other words, you need to find a subsequence of array A in which the elements are in sorted order,
//        (strictly increasing) and as long as possible.
//
//
//
//        Problem Constraints

//        1 ≤ length(A), A[i] ≤ 10^5
//
//
//
//        Input Format

//        The first and only argument of the input is the array A.
//
//
//
//        Output Format

//        Output a single integer, the length of the longest increasing subsequence in array A.
//
//
//
//        Example Input

//        Input 1:
//
//        A: [2, 1, 4, 3]

//        Input 2:
//
//        A: [5, 6, 3, 7, 9]
//
//
//        Example Output

//        Output 1:
//
//        2

//        Output 2:
//
//        4
//
//
//        Example Explanation

//        Explanation 1:
//
//        [2, 4] and [1, 3] are the longest increasing sequences of size 2.

//        Explanation 2:
//
//        The longest increasing subsequence we can get is [5, 6, 7, 9] of size 4.


public class LengthOfLIS {
    int upper_bound(int low,int high,int target,int[] temp){
        int ans=-1;
        while (low<=high) {
            int mid = ((low + high) / 2);
            if(temp[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int findLIS(ArrayList<Integer> A) {
        int[] temp=new int[A.size()+1];
        temp[1]=A.get(0);
        int lis=1;
        int last_int=A.get(0);
        int last_index=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i)>last_int){
                temp[last_index+1]=A.get(i);
                last_index=last_index+1;
                last_int=A.get(i);
                lis++;
            }
            else{
                int index= upper_bound(1,last_index,A.get(i),temp);
                temp[index]=A.get(i);
                if(last_index==index){
                    last_int=A.get(i);
                }
            }
        }
        return lis;
    }
    public static void main(String[] args) {
        LengthOfLIS I = new LengthOfLIS();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(6);A.add(6);A.add(9);A.add(7);A.add(3);
        A.add(5);A.add(1);A.add(7);A.add(10);
        System.out.println( I.findLIS(A));
    }
}

//
//
//public class Solution {
//    public int findLIS(int[] A) {
//        int n = A.length;
//        int[] temp = new int[n+1];
//        temp[1] = A[0];
//        int len = 1;
//        for(int i=1; i<n; i++) {
//            int index = upperBound(1,len,A[i],temp);
//            if(index==-1) {
//                len++;
//                temp[len] = A[i];
//            }else temp[index] = A[i];
//        }
//        return len;
//    }
//    public int upperBound(int low, int high, int target, int[] temp) {
//        int ans = -1;
//        while(low<=high) {
//            int mid = (low+high)/2;
//            if(temp[mid]>=target) {
//                ans=mid;
//                high=mid-1;
//            }else low=mid+1;
//        }
//        return ans;
//    }
//}