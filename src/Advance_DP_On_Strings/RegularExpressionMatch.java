package Advance_DP_On_Strings;

//Q=Problem Description
//        Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
//
//        ' ? ' : Matches any single character.
//        ' * ' : Matches any sequence of characters (including the empty sequence).
//        The matching should cover the entire input string (not partial).
//
//
//
//        Problem Constraints

//        1 <= length(A), length(B) <= 10^4
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

//        Return 1 if the patterns match else return 0.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "aaa"
//        B = "a*"

//        Input 2:
//
//        A = "acz"
//        B = "a?a"
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        0
//
//
//        Example Explanation

//        Explanation 1:
//
//        Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
//        So, the pattern matches we return 1.

//        Explanation 2:
//
//        '?' matches any single character. First two character in string A will be match.
//        But the last character i.e 'z' != 'a'. Return 0.

public class RegularExpressionMatch {
    byte dp[][];
    boolean method(String A, String B,int i,int j){
        if(i<0 && j<0){
            return true;
        }
        if(j<0){
            return false;
        }
        if(i<0){
            for(int k=0;k<=j;k++){
                if(B.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=-1){
            if(dp[i][j]==0){
                return false;
            }
            else{
                return true;
            }
        }
        if(A.charAt(i)==B.charAt(j) || B.charAt(j)=='?'){
            if(method(A,B,i-1,j-1)){
                dp[i][j]=1;
            }
            else{
                dp[i][j]=0;
            }
           return method(A,B,i-1,j-1);
        }
        else if(B.charAt(j)=='*'){
            if(method(A,B,i,j-1) || method(A,B,i-1,j)){
                dp[i][j]=1;
            }
            else{
                dp[i][j]=0;
            }
            return (method(A,B,i,j-1) || method(A,B,i-1,j));
        }
        else if(B.charAt(j)!=A.charAt(i)){
            return  false;
        }
        return true;
    }
    public boolean isMatch(final String A, final String B) {
        dp=new byte[A.length()][B.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                dp[i][j]=-1;
            }
        }
        return method(A,B,A.length()-1,B.length()-1);
    }
    public static void main(String[] args) {
        RegularExpressionMatch I = new RegularExpressionMatch();

        System.out.println( I.isMatch("acz","a?a"));
    }
}


