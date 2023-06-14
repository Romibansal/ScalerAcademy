package Adnvance_Combinatorics_Basics;

import java.util.Arrays;

//Q=Problem Description
//        Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
//        Assume that no characters are repeated.
//
//        Note: The answer might not fit in an integer, so return your answer % 1000003
//
//
//        Problem Constraints
//        1 <= |A| <= 1000

public class SortedPermutationRank {
    int factorial(long a){
        int mod=1000003;
        if(a==1){
            return 1;
        }
        long fact=((a%mod)*(factorial(a-1)%mod))%mod;
        return (int)fact;
    }
    public int findRank(String A) {
        int mod=1000003;
        char tempArray[] = A.toCharArray();
        long ans=0;
        Arrays.sort(tempArray);
        String B=new String(tempArray);
        StringBuilder sb = new StringBuilder(B);
        int i=0;
        int j=0;
        while(sb.length()>0){
            if(sb.charAt(i)==A.charAt(j)){
                sb.deleteCharAt(i);
                i=0;
                j++;
            }
            else{
                int l=A.length();
                ans=(ans%mod+factorial(l-1-j)%mod)%mod;
                i++;
            }
        }
        return (int)(ans+1)%mod;
    }
    public static void main(String[] args) {
        SortedPermutationRank I = new SortedPermutationRank();
        System.out.println(I.findRank("dcba"));
    }
}
