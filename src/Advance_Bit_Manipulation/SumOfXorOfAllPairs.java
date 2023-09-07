package Advance_Bit_Manipulation;

import java.util.ArrayList;

//Q=Problem Description
//        Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.
//
//        Since the answer can be large, return the remainder after the dividing the answer by 109+7.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] < 10^9

public class SumOfXorOfAllPairs {
    public int solve(ArrayList<Integer> A) {
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<32;i++){
            long unset=0;
            long set=0;
            for(int j=0;j<A.size();j++){
                if(((A.get(j)>>i)&1)==1){
                    set++;
                }
                else{
                    unset++;
                }
            }
            long pairs=(set%mod*unset%mod)%mod;
            long q=(pairs%mod*(int)(Math.pow(2,i)%mod))%mod;
            ans=(ans%mod+q%mod)%mod;
        }
        return (int)ans;
    }
    public static void main(String args []){
        SumOfXorOfAllPairs S1=new SumOfXorOfAllPairs();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1); A.add(2); A.add(3);
        System.out.println( S1.solve(A));
    }
}






