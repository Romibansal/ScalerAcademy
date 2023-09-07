package Advance_Bit_Manipulation;

import java.util.ArrayList;

//Q=Problem Description
//        Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
//
//
//        Problem Constraints
//        1 <= len(A) <= 10^5
//        1 <= A[i] <= 10^9


public class MaximumANDPair {
    public int solve(ArrayList<Integer> A) {
        int ans=0;
        for(int i=30;i>-1;i--){
            int count=0;
            for(int j=0;j<A.size();j++){
                if(((A.get(j)>>i)&1)==1){
                    count++;
                }
            }
            if(count>1){
                ans=(ans |(1<<i));
                for(int y=0;y<A.size();y++){
                    if(((A.get(y)>>i)&1)==0){
                        A.set(y,0);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String args []){
        MaximumANDPair S1=new MaximumANDPair();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(6); A.add(7);A.add(8);
        System.out.println( S1.solve(A));
    }
}






