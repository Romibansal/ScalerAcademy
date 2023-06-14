package Advance_Geometry_And_String_Problems;

import java.util.HashSet;

//Q=Problem Description
//        Given a string A, find the length of the longest substring without repeating characters.
//
//        Note: Users are expected to solve in O(N) time complexity.
//
//
//
//        Problem Constraints
//        1 <= size(A) <= 10^6
//
//        String consists of lowerCase,upperCase characters and digits are also present in the string A.
//
//
//
//        Input Format
//        Single Argument representing string A.



public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> set=new HashSet<>();
        int ans=-1;
        int j=0;
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(set.contains(ch)){
                ans=Math.max(ans,set.size());
                while(A.charAt(j)!=ch){
                    set.remove(A.charAt(j));
                    j++;
                }
                set.remove(A.charAt(j));
                j++;
                set.add(ch);
            }
            else{
                set.add(ch);
            }
        }
        return Math.max(ans,set.size());
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeat I = new LongestSubstringWithoutRepeat();
        System.out.println(I.lengthOfLongestSubstring("dadbc"));
    }

}







