package Advance_DP_Famous_Problems;

import Advance_DP_On_Strings.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;

//Q=Problem Description
//        Find the longest increasing subsequence of a given array of integers, A.
//
//        In other words, find a subsequence of array in which the subsequence's elements
//        are in strictly increasing order, and in which the subsequence is as long as possible.
//
//        In this case, return the length of the longest increasing subsequence.
//
//
//
//        Problem Constraints

//        1 <= length(A) <= 2500
//        0 <= A[i] <= 2500
//
//
//
//        Input Format

//        The first and the only argument is an integer array A.
//
//
//
//        Output Format

//        Return an integer representing the length of the longest increasing subsequence.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 1, 5]

//        Input 2:
//
//        A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
//
//
//        Example Output

//        Output 1:
//
//        3

//        Output 2:
//
//        6
//
//
//        Example Explanation

//        Explanation 1:
//
//        The longest increasing subsequence: [1, 2, 5]

//        Explanation 2:
//
//        The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or
//        [0, 4, 6, 9, 13, 15]

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> A) {
        int len[]=new int[A.size()];
        for(int i=0;i<A.size();i++){
            len[i]=1;
            for(int j=0;j<i;j++){
                if(A.get(i)>A.get(j) && len[j]+1>len[i]){
                    len[i]=len[j]+1;
                }
            }
        }
        int max=len[0];
        for(int i=0;i<len.length;i++){
            max=Math.max(max,len[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence I = new LongestIncreasingSubsequence();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add(3);A.add(2);A.add(3);A.add(1);A.add(5);A.add(2);
        System.out.println( I.lis(A));
    }
}


