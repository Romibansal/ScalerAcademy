package Advance_DP_On_Strings;

//Q=Problem Description

//        Given A, B, C find whether C is formed by the interleaving of A and B.
//
//
//
//        Problem Constraints

//        1 <= length(A), length(B) <= 100
//
//        1 <= length(C) <= 200
//
//
//
//        Input Format

//        The first argument of input contains a string, A.
//        The second argument of input contains a string, B.
//        The third argument of input contains a string, C.
//
//
//
//        Output Format

//        Return 1 if string C is formed by interleaving of A and B else 0.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "aabcc"
//        B = "dbbca"
//        C = "aadbbcbcac"

//        Input 2:
//
//        A = "aabcc"
//        B = "dbbca"
//        C = "aadbbbaccc"
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
//        "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
//        Explanation 2:
//
//        It is not possible to get C by interleaving A and B.


public class InterleavingStrings {
    int dp[][];
    int method(int i,int j,int k,String A,String B,String C){
        if(i==A.length() && j==B.length() && k==C.length()){
            return  1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(i<A.length() && k<C.length() && A.charAt(i)==C.charAt(k)){
            if(method(i+1,j,k+1,A,B,C)==1){
                ans=1;
            }
        }
        if(j<B.length() && k<C.length() && B.charAt(j)==C.charAt(k)){
            if(method(i,j+1,k+1,A,B,C)==1){
                ans=1;
            }
        }
        dp[i][j]=ans;
        return ans;
    }
    public int isInterleave(String A, String B, String C) {
        if(C.length()>(A.length()+B.length())){
            return 0;
        }
        dp=new int[A.length()+1][B.length()+1];
        for(int i=0;i<A.length()+1;i++){
            for(int j=0;j<B.length()+1;j++){
                dp[i][j]=-1;
            }
        }
       return method(0,0,0,A,B,C);
    }
    public static void main(String[] args) {
        InterleavingStrings I = new InterleavingStrings();

        System.out.println( I.isInterleave("B","e","Be"));
    }
}

