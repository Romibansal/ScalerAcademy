package Advance_Bit_Manipulation;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        Given an integer array A of N integers, find the pair of integers
//        in the array which have minimum XOR value. Report the minimum XOR value.
//
//
//
//        Problem Constraints
//        2 <= length of the array <= 100000
//        0 <= A[i] <= 10^9

public class MinXORValue {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans=(int)Math.pow(10,9);
        for(int i=0;i<A.size()-1;i++){
            ans=Math.min((A.get(i)^A.get(i+1)),ans);
        }
        return ans;
    }
    public static void main(String args []){
        MinXORValue S1=new MinXORValue();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(0); A.add(2); A.add(5);A.add(7);
        System.out.println( S1.findMinXor(A));
    }
}

