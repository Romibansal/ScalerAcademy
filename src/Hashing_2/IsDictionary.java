package Hashing_2;

import java.util.HashMap;

//Q=Problem Description
//        Surprisingly, in an alien language, they also use English lowercase letters,
//        but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
//        Given an array of words A of size N written in the alien language, and the order
//        of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted
//        lexicographically in this alien language else, return 0.
//
//        Problem Constraints
//        1 <= N, length of each word <= 10^5
//
//        Sum of the length of all words <= 2 * 10^6



public class IsDictionary {
    public int solve(String[] A, String B) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<B.length();i++){
            hm.put(B.charAt(i),i);
        }
        for(int j=0;j<A.length-1;j++){
            if(A[j].length()>A[j+1].length()){
                return 0;
            }
            int k=0;
            while(k<A[j].length() && A[j].charAt(k)==A[j+1].charAt(0)){
                k++;
            }
                char c=A[j].charAt(k);
                char s=A[j+1].charAt(0);
                if(hm.get(c)>hm.get(s)){
                    return 0;
                }

        }
        return 1;
    }
    public static void main(String args []){
        IsDictionary N1=new IsDictionary();
        String[] A=new String[3];
        A[0]="hello";A[1]= "scaler";A[2]= "interviewbit";
        System.out.println( N1.solve(A,"adhbcfegskjlponmirqtxwuvzy"));
    }
}



