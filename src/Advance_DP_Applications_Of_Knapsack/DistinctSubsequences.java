package Advance_DP_Applications_Of_Knapsack;

//Q=Problem Description

//        Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence
//        that is identical to the sequence B.
//
//        Subsequence : A subsequence of a string is a new string which is formed from the original
//        string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//
//
//        Problem Constraints

//        1 <= length(A), length(B) <= 700
//
//
//
//        Input Format

//        The first argument of input contains a string A.
//        The second argument of input contains a string B.
//
//
//
//        Output Format

//        Return an integer representing the answer as described in the problem statement.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "abc"
//        B = "abc"

//        Input 2:
//
//        A = "rabbbit"
//        B = "rabbit"
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        3
//
//
//        Example Explanation

//        Explanation 1:
//
//        Both the strings are equal.

//        Explanation 2:
//
//        These are the possible removals of characters:

//        => A = "ra_bbit"
//        => A = "rab_bit"
//        => A = "rabb_it"
//
//        Note: "_" marks the removed character.



public class DistinctSubsequences {
    int dp[][];
    int method(String A, String B, int i,int j){
        if(i==-1 && j==-1){
            return 1;
        }
        if(j==-1){
            return 1;
        }
        if(i==-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(A.charAt(i)!=B.charAt(j)){
            dp[i][j]=method(A,B,i-1,j);
            return dp[i][j];
        }
        else {
            dp[i][j]=(method(A,B,i-1,j)+method(A,B,i-1,j-1));
            return dp[i][j];
        }
    }
    public int numDistinct(String A, String B) {
        dp=new int[A.length()][B.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                dp[i][j]=-1;
            }
        }
       return method(A,B,A.length()-1,B.length()-1);
    }
    public static void main(String[] args) {
        DistinctSubsequences I = new DistinctSubsequences();

        System.out.println( I.numDistinct("rabbbit","rabbit"));
    }
}



