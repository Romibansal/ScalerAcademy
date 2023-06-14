package Advance_Geometry_And_String_Problems;

import java.util.HashMap;

//Q=Problem Description
//        Given a string A and a string B, find the window with minimum length in A,
//        which will contain all the characters in B in linear time complexity.
//        Note that when the count of a character c in B is x,
//        then the count of c in the minimum window in A should be at least x.
//
//        Note:
//
//        If there is no such window in A that covers all characters in B, return the empty string.
//        If there are multiple such windows, return the first occurring minimum window
//        ( with minimum start index and length )
//
//
//        Problem Constraints
//        1 <= size(A), size(B) <= 10^6



public class WindowString {
    public String minWindow(String A, String B) {
        HashMap<Character,Integer> map1= new HashMap<>();
        int k=B.length();
        for(int i=0;i<k;i++) {
            char ch= B.charAt(i);
            if(map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            }
            else {
                map1.put(ch, 1);
            }
        }
        int p1=0;
        int p2=0;
        int match=0;
        int len=-1;
        int ansLen=Integer.MAX_VALUE;
        int st=-1;
        int flag=0;
        HashMap<Character,Integer> map2= new HashMap<>();
        while(p2<A.length()) {
            char ch= A.charAt(p2);
            if(map2.containsKey(ch)) {
                map2.put(ch, map2.get(ch) + 1);
            }
            else {
                map2.put(ch, 1);
            }
            if(map1.containsKey(ch)) {
                if (map2.get(ch) <= map1.get(ch)) {
                    match++;
                }
            }
            while(match==k) {
                flag=1;
                len=p2-p1+1;
                if(len<ansLen) {
                    ansLen=len;
                    st=p1;
                }
                char remove= A.charAt(p1);
                if(map1.containsKey(remove)){
                    if(map2.get(remove)<=map1.get(remove)) {
                        match--;
                    }
                }
                map2.put(remove,map2.get(remove)-1);
                p1++;
            }
            p2++;
        }
        int end= st+ansLen-1;
        return flag==1? A.substring(st,end+1):"";
    }
    public static void main(String[] args) {
        WindowString I = new WindowString();


        System.out.println(I.minWindow("Aa91b","ab"));
    }
}






