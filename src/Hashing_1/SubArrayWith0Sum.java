package Hashing_1;

import java.util.HashMap;

//Q=Problem Description
//        Given an array of integers A, find and return whether the given array contains a
//        non-empty subarray with a sum equal to 0.
//
//        If the given array contains a sub-array with sum zero return 1, else return 0.
//
//        Problem Constraints
//        1 <= |A| <= 100000
//        -10^9 <= A[i] <= 10^9

public class SubArrayWith0Sum {
    public int solve(int[] A) {
        long prefixsum[]=new long[A.length];
        prefixsum[0]=A[0];
        for(int i=1;i<A.length;i++){
            prefixsum[i]=A[i]+prefixsum[i-1];
        }
        HashMap<Long,Integer> hm=new HashMap<>();
        for(int j=0;j<prefixsum.length;j++){
            if(prefixsum[j]==0){
                return 1;
            }
            if( hm.containsKey(prefixsum[j])){
                int v=hm.get(prefixsum[j]);
                v=v+1;
                hm.put(prefixsum[j],v);
            }
            else{
                hm.put(prefixsum[j],1);
            }
        }
        for(int h=0;h<prefixsum.length;h++){
            if(hm.get(prefixsum[h])>1){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String args []){
        SubArrayWith0Sum N1=new SubArrayWith0Sum();
        int A[]=new int[5];
        A[0]=1;A[2]=3;
        A[1]=2;A[3]=4;A[4]=5;
        System.out.println( N1.solve(A));
    }
}

