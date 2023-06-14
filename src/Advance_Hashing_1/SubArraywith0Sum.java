package Advance_Hashing_1;

import java.util.HashSet;

//Q=Problem Description
//        Given an array of integers A, find and return whether the given array contains
//        a non-empty subarray with a sum equal to 0.
//
//        If the given array contains a sub-array with sum zero return 1, else return 0.

//        Problem Constraints
//        1 <= |A| <= 100000
//
//        -10^9 <= A[i] <= 10^9

public class SubArraywith0Sum {
    public int solve(int[] A) {
        long[] ps=new long[A.length];
        ps[0]=A[0];
        if(ps[0]==0){
            return 1;
        }
        for(int i=1;i<A.length;i++){
            ps[i]=ps[i-1]+A[i];
            if(ps[i]==0){
                return 1;
            }
        }
        HashSet<Long> set=new HashSet();
        for(int i=0;i<ps.length;i++){
            if(set.contains(ps[i])){
                return 1;
            }
            else{
                set.add(ps[i]);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        SubArraywith0Sum I = new SubArraywith0Sum();
        int []A=new int[3];
        A[0]=4;A[1]=1;A[2]=-1;
        System.out.println(I.solve(A));
    }
}

