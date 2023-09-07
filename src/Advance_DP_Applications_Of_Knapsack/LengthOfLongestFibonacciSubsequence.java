package Advance_DP_Applications_Of_Knapsack;


import java.util.HashMap;
//
//Q=Problem Description

//        Given a strictly increasing array A of positive integers forming a sequence.
//
//        A sequence X1, X2, X3, ..., XN is fibonacci like if
//        N > =3
//        Xi + Xi+1 = Xi+2 for all i+2 <= N

//        Find and return the length of the longest Fibonacci-like subsequence of A.
//
//        If one does not exist, return 0.
//
//        NOTE: A subsequence is derived from another sequence A by deleting any number of elements
//        (including none) from A, without changing the order of the remaining elements.
//
//
//
//        Problem Constraints

//        3 <= length of the array <= 1000
//
//        1 <= A[i] <= 10^9
//
//
//
//        Input Format

//        The only argument given is the integer array A.
//
//
//
//        Output Format

//        Return the length of the longest Fibonacci-like subsequence of A.
//        If one does not exist, return 0.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 3, 4, 5, 6, 7, 8]

//        Input 2:
//
//        A = [1, 3, 7, 11, 12, 14, 18]
//
//
//        Example Output

//        Output 1:
//
//        5

//        Output 2:
//
//        3
//
//
//        Example Explanation

//        Explanation 1:
//
//        The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].

//        Explanation 2:
//
//        The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
//        The length will be 3.

public class LengthOfLongestFibonacciSubsequence {
    public int solve(int[] A) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            map.put(A[i],i);
        }
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int temp=0;
                int first=A[i];
                int second=A[j];
                int sum=first+second;
                while(map.containsKey(sum)){
                    temp++;
                    first=second;
                    second=sum;
                    sum=first+second;
                }
                ans=Math.max(ans,temp);
            }
        }
        if(ans>0){
            return ans+2;
        }
        return ans;
    }
    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence I = new LengthOfLongestFibonacciSubsequence();
        int[]A=new int[8];
        A[0]=1;A[1]=2;A[2]=3;A[3]=4;A[4]=5;A[5]=6;A[6]=7;A[7]=8;
        System.out.println( I.solve(A));
    }
}


