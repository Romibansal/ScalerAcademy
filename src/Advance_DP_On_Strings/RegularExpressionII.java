package Advance_DP_On_Strings;

//Q=Problem Description

//        Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
//
//        ' . ' : Matches any single character.
//        ' * ' : Matches zero or more of the preceding element.
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
//        The second argument of input contains a string B denoting the pattern.
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
//        A = "aab"
//        B = "c*a*b"

//        Input 2:
//
//        A = "acz"
//        B = "a.a"
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
//        'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
//        So, return 1.

//        Explanation 2:
//
//        '.' matches any single character. First two character in string A will be match.
//        But the last character i.e 'z' != 'a'. Return 0.


public class RegularExpressionII {
    int dp[][];
    int method(String A,String B,int i,int j){
        if(i<0 && j<0 ){
            return 1;
        }
        if(j<0){
            return 0;
        }
        if(i<0){
            for(int h=0;h<=j;h=h+2){
                if(h+1>j || B.charAt(h+1)!='*'){
                    return 0;
                }

            }
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(A.charAt(i)==B.charAt(j) || B.charAt(j)=='.'){
            dp[i][j]= method(A,B,i-1,j-1);
            return  dp[i][j];
        }
        if(B.charAt(j)=='*'){
            int temp=method(A,B,i,j-2);
            if(temp==1){
                dp[i][j]=1;
                return 1;
            }
            if(A.charAt(i)==B.charAt(j-1) || B.charAt(j-1)=='.'){
                int temp1=method(A,B,i-1,j);
                if(temp1==1){
                    dp[i][j]=1;
                    return 1;
                }
            }

        }
        return 0;
    }
    public int isMatch(final String A, final String B) {
        dp=new int[A.length()+1][B.length()+1];
        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                dp[i][j]=-1;
            }
        }
        return method(A,B,A.length()-1,B.length()-1);
    }

    public static void main(String[] args) {
        RegularExpressionII I = new RegularExpressionII();

        System.out.println( I.isMatch("aab","c*a*b"));
    }
}



