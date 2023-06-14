package Advance_String_Pattern_Matching_And_Rabin_Karp;

//Q=Problem Description
//        You are given two strings, A and B, of size N and M, respectively.
//
//        You have to find the count of all permutations of A present in B as a substring.
//        You can assume a string will have only lowercase letters.
//
//
//        Problem Constraints
//        1 <= N < M <= 10^5



public class PermutationsofAInB {
    boolean isSame(int[] freq, int[] temp_freq){
        for(int i=0;i<26;i++){
            if(freq[i]!=temp_freq[i]){
                return false;
            }
        }
        return true;
    }
    public int solve(String A, String B) {
        int [] freq=new int[26];
        for(int i=0;i<A.length();i++){
            freq[A.charAt(i)-'a']++;
        }
        int [] temp_freq=new int[26];
        for(int i=0;i<A.length();i++){
            temp_freq[B.charAt(i)-'a']++;
        }
        int ans=0;
        if(isSame(freq,temp_freq)){
            ans++;
        }
        int l=1;
        int r=A.length();
        while(r<B.length()){
            temp_freq[B.charAt(l-1)-'a']--;
            temp_freq[B.charAt(r)-'a']++;
            if(isSame(freq,temp_freq)){
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }
    public static void main(String[] args) {
        PermutationsofAInB I = new PermutationsofAInB();


        System.out.println(I.solve("abc","abcbacabc"));
    }
}