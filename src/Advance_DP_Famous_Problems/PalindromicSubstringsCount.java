package Advance_DP_Famous_Problems;

// Q=Given a string A consisting of lowercase English alphabets. Your task is to find how many
//  substrings of A are palindrome.
//
//        The substrings with different start indexes or end indexes are counted as different
//        substrings even if they consist of same characters.
//
//        Return the count of palindromic substrings.
//
//        Note: A string is palindrome if it reads the same from backward and forward.
//
//
//        Input Format
//
//        The only argument given is string A.
//
//        Output Format
//
//        Return the count of palindromic substrings.
//
//        Constraints
//
//        1 <= length of the array <= 1000
//
//        For Example
//
//        Input 1:
//
//        A = "abab"
//
//        Output 1:
//        6
//
//        Explanation 1:
//
//        6 palindromic substrings are:
//        "a", "aba", "b", "bab", "a" and "b".
//
//        Input 2:
//
//        A = "ababa"
//
//        Output 2:
//        9
//
//        Explanation 9:
//
//        9 palindromic substrings are:
//
//        "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".

public class PalindromicSubstringsCount {
    int dp[][];
    public int solve(String A) {
        dp=new int[A.length()][A.length()];
        for(int l=1;l<=A.length();l++){
            for(int i=0;i<A.length();i++){
                int j=i+l-1;
                if(j>=A.length()){
                    break;
                }
                if(l==1){
                   dp[i][j]=1;
               }
                else if(l==2){
                    if(A.charAt(i)==A.charAt(j)){
                        dp[i][j]=1;
                    }
                }
                else{
                    if(A.charAt(i)==A.charAt(j)){
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<A.length();i++){
            for(int j=0;j<A.length();j++){
                if(i<=j){
                    if(dp[i][j]==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        PalindromicSubstringsCount I = new PalindromicSubstringsCount();

        System.out.println( I.solve("abab"));
    }
}


