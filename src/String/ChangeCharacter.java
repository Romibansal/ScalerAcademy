package String;

import java.util.Arrays;


//Q=Problem Description
//        You are given a string A of size N consisting of lowercase alphabets.
//
//        You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
//
//        Find the minimum number of distinct characters in the resulting string.
//
//
//
//        Problem Constraints
//        1 <= N <= 100000
//
//        0 <= B < N

public class ChangeCharacter {
    public int solve(String A, int B) {
        if(A.length()<=B ){
            return 1;
        }
        int C[]=new int[26];
        for(int i=0;i<A.length();i++){
            int index=(int)A.charAt(i)-97;
            C[index]=C[index]+1;
        }
        Arrays.sort(C);
        for(int j=0;j<C.length;j++){
            if(C[j]!=0){
                if((B-C[j])>=0){
                    B=B-C[j];
                    C[j]=0;
                }
            }
        }
        int count=0;
        for(int t=0;t<C.length;t++){
            if(C[t]>0){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]) {
        ChangeCharacter N1 = new ChangeCharacter();
        System.out.println(N1.solve("umeaylnlfd",1));
    }
}
