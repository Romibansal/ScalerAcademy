package Advance_DP_Famous_Problems;
//
//Q=Problem Description

//        Given a string A, partition A such that every substring of the partition is a palindrome.
//
//        Return the minimum cuts needed for a palindrome partitioning of A.
//
//
//
//        Problem Constraints

//        1 <= length(A) <= 501
//
//
//
//        Input Format

//        The first and the only argument contains the string A.
//
//
//
//        Output Format


//        Return an integer, representing the minimum cuts needed.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "aba"

//        Input 2:
//
//        A = "aab"
//
//
//        Example Output

//        Output 1:
//
//        0

//        Output 2:
//
//        1
//
//
//        Example Explanation

//        Explanation 1:
//
//        "aba" is already a palindrome, so no cuts are needed.

//        Explanation 2:
//
//        Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


public class PalindromePartitioningII {
    int dp[][];
    public int minCut(String A) {
        dp=new int[A.length()][A.length()];
        for(int l=1;l<=A.length();l++) {
            for (int i = 0; i < A.length(); i++) {
                int j = i + l - 1;
                if (j >= A.length()) {
                    break;
                }
                if (l == 1) {
                    dp[i][j] = 1;
                } else if (l == 2) {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
            int cut[]=new int[A.length()];
            for(int i=0;i<A.length();i++){
                cut[i]=Integer.MAX_VALUE;
            }
            for(int i=0;i<A.length();i++){
                if(dp[0][i]==1){
                    cut[i]=0;
                }
                else{
                    for(int j=0;j<i;j++){
                        if(dp[j+1][i]==1){
                            cut[i]=Math.min(cut[i],cut[j]+1);
                        }
                    }
                }
            }
            return cut[cut.length-1];
    }
    public static void main(String[] args) {
        PalindromePartitioningII I = new PalindromePartitioningII();
        System.out.println( I.minCut("xabaabp"));
    }
}


