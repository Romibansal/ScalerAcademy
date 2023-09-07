package Advance_DP_On_Strings;
//
//Q=Problem Description

//        Given two strings A and B, find the minimum number of steps required to convert A to B.
//        (each operation is counted as 1 step.)
//
//        You have the following 3 operations permitted on a word:
//
//        Insert a character
//        Delete a character
//        Replace a character
//
//
//        Problem Constraints

//        1 <= length(A), length(B) <= 450
//
//
//
//        Input Format

//        The first argument of input contains a string, A.
//        The second argument of input contains a string, B.
//
//
//
//        Output Format

//        Return an integer, representing the minimum number of steps required.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "abad"
//        B = "abac"

//        Input 2:
//
//        A = "Anshuman"
//        B = "Antihuman
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Exlanation 1:
//
//        A = "abad" and B = "abac"
//        After applying operation: Replace d with c. We get A = B.
//
//        Explanation 2:
//
//        A = "Anshuman" and B = "Antihuman"
//        After applying operations: Replace s with t and insert i before h. We get A = B.


public class EditDistance {
    int dp[][];
    int method(String A, String B,int i, int j){

        if(i<0 && j<0){
            return 0;
        }
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(A.charAt(i)==B.charAt(j)){
           return method(A,B,i-1,j-1);
        }
        else{
            int replace=1+method(A,B,i-1,j-1);
            int delete=1+method(A,B,i-1,j);
            int insert=1+method(A,B,i,j-1);
            dp[i][j]=Math.min(replace,Math.min(delete,insert));
            return Math.min(replace,Math.min(delete,insert));
        }
    }
    public int minDistance(String A, String B) {
        dp=new int[A.length()][B.length()];
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                dp[i][j]=-1;
            }
        }
        return method( A, B, A.length()-1,B.length()-1);
    }
    public static void main(String[] args) {
        EditDistance I = new EditDistance();

        System.out.println( I.minDistance("aac","abac"));
    }
}


