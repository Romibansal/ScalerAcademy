package String;

//Q=Problem Description
//        Given a string A of size N, find and return the longest palindromic substring in A.
//
//        Substring of string A is A[i...j] where 0 <= i <= j < len(A)
//
//        Palindrome string:
//        A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
//
//        Incase of conflict, return the substring which occurs first ( with the least starting index).
//
//
//
//        Problem Constraints
//        1 <= N <= 6000




public class LongestPalindromicSubstring {
    public String longestPalindrome(String A) {
        int max=1;
        int s=0;
        int e=0;
        for(int i=A.length()-1;i>-1;i--){
            int k=i-1;
            int l=i+1;
            while(k>-1 && l<A.length() && A.charAt(k)==A.charAt(l)){
                k--;
                l++;
            }
            k=k+1;
            l=l-1;
            int diff=l-k+1;
            if(diff>=max){
                max=diff;
                s=k;
                e=l;
            }
        }
        for(int j=A.length()-1;j>0;j--){
            if(A.charAt(j-1)==A.charAt(j)){
                int q=j-2;
                int w=j+1;
                while(q>-1 && w<A.length() && A.charAt(q)==A.charAt(w)){
                    q--;
                    w++;
                }
                q=q+1;
                w=w-1;
                int dif=w-q+1;
                if(dif>=max){
                    max=dif;
                    s=q;
                    e=w;
                }
            }
        }
        return A.substring(s,e+1);
    }

    public static void main(String args[]) {
        LongestPalindromicSubstring N1 = new LongestPalindromicSubstring();
        System.out.println(N1.longestPalindrome("abbcccbbbcaaccbababcbcabca"));
    }
}
