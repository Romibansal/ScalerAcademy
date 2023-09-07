package Advance_DP_On_Strings;


//Q=Problem Description
//        Given two strings A and B. Find the longest common subsequence
//        ( A sequence which does not need to be contiguous), which is common in both the strings.
//
//        You need to return the length of such longest common subsequence.
//
//
//
//        Problem Constraints

//        1 <= Length of A, B <= 1005
//
//
//
//        Input Format

//        First argument is a string A.
//        Second argument is a string B.
//
//
//
//        Output Format

//        Return an integer denoting the length of the longest common subsequence.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "abbcdgf"
//        B = "bbadcgf"

//        Input 2:
//
//        A = "aaaaaa"
//        B = "ababab"
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
//        The longest common subsequence is "bbcgf", which has a length of 5.

//        Explanation 2:
//
//        The longest common subsequence is "aaa", which has a length of 3.
//


public class LongestCommonSubsequence {
    int dp[][];
    int method(String A,String B,int i,int j){
        if(i<0|| j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(A.charAt(i)==B.charAt(j)){
            dp[i][j]=(1+method(A,B,i-1,j-1));
            return (1+method(A,B,i-1,j-1));
        }
        else{
            dp[i][j]=Math.max(method(A,B,i-1,j),method(A,B,i,j-1));
           return Math.max(method(A,B,i-1,j),method(A,B,i,j-1));
        }
    }
    public int solve(String A, String B) {
        dp=new int[A.length()][B.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                dp[i][j]=-1;
            }
        }
       return method(A,B,A.length()-1,B.length()-1);
    }
    public static void main(String[] args) {
        LongestCommonSubsequence I = new LongestCommonSubsequence();

        System.out.println( I.solve("abbcdgf","bbadcgf"));
    }
}

