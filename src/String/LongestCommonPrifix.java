package String;

//Q=Problem Description
//        Given the array of strings A, you need to find the longest string S,
//        which is the prefix of ALL the strings in the array.
//
//        The longest common prefix for a pair of strings S1 and S2 is the longest string S
//        which is the prefix of both S1 and S2.
//
//        Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
//
//        Problem Constraints
//        0 <= sum of length of all strings <= 1000000


public class LongestCommonPrifix {
    public String longestCommonPrefix(String[] A) {
        StringBuilder ans=new StringBuilder();
        int len= 2147483647;
        for(int i=0;i<A.length;i++){
            len=Math.min(len,A[i].length());
        }
        for(int j=0;j<len;j++){
            char c=A[0].charAt(j);
            for(int t=1;t<A.length;t++){
                if(A[t].charAt(j)!=c){
                    return ans.toString() ;
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
    public static void main(String args[]) {
        LongestCommonPrifix N1 = new LongestCommonPrifix();
        String A[]=new String[3];
        A[0]="abab";A[1]="ab";A[2]="abcd";
        System.out.println(N1.longestCommonPrefix(A));
    }
}