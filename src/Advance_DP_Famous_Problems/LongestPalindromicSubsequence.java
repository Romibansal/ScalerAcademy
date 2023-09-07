package Advance_DP_Famous_Problems;

//Q=Problem Description
//        Given a string A. Find the longest palindromic subsequence
//        (A subsequence which does not need to be contiguous and is a palindrome).
//
//        You need to return the length of longest palindromic subsequence.
//
//
//
//        Problem Constraints

//        1 <= length of(A) <= 10^3
//
//
//
//        Input Format

//        First and only integer is a string A.
//
//
//
//        Output Format

//        Return an integer denoting the length of longest palindromic subsequence.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "bebeeed"

//        Input 2:
//
//        A = "aedsead"
//
//
//        Example Output

//        Output 1:
//
//        4

//        Output 2:
//
//        5
//


public class LongestPalindromicSubsequence {
    int dp[][];
    int method(String A,int i, int j){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(A.charAt(i)==A.charAt(j)){
            int temp= 2+method(A,i+1,j-1);
            dp[i][j]=temp;
            return temp;
        }
        else{
            int temp1=Math.max(method(A,i+1,j),method(A,i,j-1));
            dp[i][j]=temp1;
            return temp1;
        }
    }
    public int solve(String A) {
        dp=new int[A.length()][A.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<A.length();j++){
                dp[i][j]=-1;
            }
        }
        return method(A,0,A.length()-1);
    }
    public static void main(String[] args) {
        LongestPalindromicSubsequence I = new LongestPalindromicSubsequence();

        System.out.println( I.solve("aedsead"));
    }
}



