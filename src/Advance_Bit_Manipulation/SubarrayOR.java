package Advance_Bit_Manipulation;

//Q=Problem Description
//        You are given an array of integers A of size N.
//
//        The value of a subarray is defined as BITWISE OR of all elements in it.
//
//        Return the sum of value of all subarrays of A % 109 + 7.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^8

import java.util.ArrayList;

public class SubarrayOR {
    public int solve(ArrayList<Integer> A) {
        int mod=(int)Math.pow(10,9)+7;
        long ans=0;
        for(int i=0;i<31;i++){
            ArrayList<Integer> B=new ArrayList<>();
            for(int j=0;j<A.size();j++){
                if(((A.get(j)>>i)&1)==1){
                    B.add(1);
                }
                else{
                    B.add(0);
                }
            }
            int size=B.size();
            long sum=0;
            int lastseen=B.size();
            for(int k=B.size()-1;k>-1;k--){
                if(B.get(k)==1){
                    lastseen=k;
                    sum=sum+(size-k);
                }
                else{
                    sum=sum+(size-lastseen);
                }
            }
            long l=sum*(int)Math.pow(2,i);
            ans=(ans%mod+l%mod)%mod;
        }
        return (int)ans;
    }
    public static void main(String args []){
        SubarrayOR S1=new SubarrayOR();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1); A.add(2); A.add(3);A.add(4);A.add(5);
        System.out.println( S1.solve(A));
    }
}






