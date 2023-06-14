package Advance_String_Pattern_Matching_And_Rabin_Karp;

import java.util.HashMap;

//Q=Problem Description
//        Given two strings A and B, determine if they are isomorphic.
//
//        A and B are called isomorphic strings if all occurrences of each character in A
//        can be replaced with another character to get B and vice-versa.
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        1 <= |B| <= 100000
//
//        A and B contain only lowercase characters.

public class IsomorphicStrings {
    public int solve(String A, String B) {
        if(A.length()!=B.length()){
            return 0;
        }
        HashMap<Character,Character> a=new HashMap<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if(a.containsKey(c)){
                if(a.get(c)!=B.charAt(i)){
                    return 0;
                }
            }
            else{
                a.put(c,B.charAt(i));
            }
        }
        HashMap<Character,Character> b=new HashMap<>();
        for(int i=0;i<B.length();i++){
            char c1=B.charAt(i);
            if(b.containsKey(c1)){
                if(b.get(c1)!=A.charAt(i)){
                    return 0;
                }
            }
            else{
                b.put(c1,A.charAt(i));
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        IsomorphicStrings I = new IsomorphicStrings();
        System.out.println(I.solve("vc","aa"));
    }
}
